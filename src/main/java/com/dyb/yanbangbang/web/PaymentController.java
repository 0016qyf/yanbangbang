package com.dyb.yanbangbang.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dyb.yanbangbang.common.JsonResult;
import com.dyb.yanbangbang.entity.Orders;
import com.dyb.yanbangbang.service.IOrdersService;
import com.dyb.yanbangbang.utils.wxpay.MyConfig;
import com.dyb.yanbangbang.utils.wxpay.PayUtil;
import com.dyb.yanbangbang.utils.wxpay.WxPayConfig;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Tang on 2018/12/13 0013.
 */
@CrossOrigin
@RestController
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);


    private static final String appID = "";
    private static final String secret = "";
    private static final String mchID = "";
    private static final String partnerKey = "";
    private String notify_url = "https://wx.dybsports.com/handGame/notify";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private IOrdersService iOrdersService;

    /**
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/payment")
    public JsonResult payment(HttpServletRequest request, HttpServletResponse response,Orders order) {
        log.info("进入下单的方法");
        try{
            String openId = request.getParameter("openid");
            //生成的随机字符串
            String nonce_str = getRandomStringByLength(32);
            //获取客户端的ip地址
            String spbill_create_ip = getIpAddr(request);
            //商品名称
            String body =order.getExpName();
            //订单号
            order.setOrderCode(String.valueOf(System.currentTimeMillis()));
            String orderNo =order.getOrderCode();
            //测试
            BigDecimal total_fee=new BigDecimal("1");
            total_fee=order.getTotalMoney().multiply(total_fee);
            log.info(openId);
            log.info("开始封装");

            MyConfig wxkey = new MyConfig();
            WXPay wxpay = new WXPay(wxkey, WXPayConstants.SignType.MD5, false);

            //组装参数，用户生成统一下单接口的签名
            Map<String, String> packageParams = new HashMap<String, String>();
            packageParams.put("appid", WxPayConfig.appid);
            packageParams.put("mch_id", WxPayConfig.mch_id);
            packageParams.put("nonce_str", nonce_str);
            packageParams.put("body", body);
            packageParams.put("out_trade_no",orderNo);//商户订单号
            packageParams.put("total_fee", total_fee.toString());//支付金额，这边需要转成字符串类型，否则后面的签名会失败
            packageParams.put("spbill_create_ip", spbill_create_ip);
            packageParams.put("notify_url", WxPayConfig.notify_url);//支付成功后的回调地址
            packageParams.put("trade_type", WxPayConfig.TRADETYPE);//支付方式
            packageParams.put("sign_type",WxPayConfig.SIGNTYPE);
            packageParams.put("openid", openId);
            packageParams.put("attach",order.getBuyerId().toString());

            //调用微信统一下单接口
            Map resp = wxpay.unifiedOrder(packageParams);
            log.info("微信统一下单支付的响应结果：" + resp.toString());
            log.info("微信响应消息return_msg：" + resp.get("return_msg"));
            log.info("微信响应代码return_code：" + resp.get("return_code"));

            //在return_code 和result_code都为SUCCESS的时候有返回prepay_id
            Map<String, Object> rep = new HashMap<>();
            if ("SUCCESS".equals(resp.get("return_code"))) {
                String prepay_id = resp.get("prepay_id").toString();
                log.info("微信统一下单后得到的预支付订单ID：" + prepay_id);
                order.setCreateTime(new Date());
                order.setState(0);
                boolean flag= iOrdersService.insert(order);
                if(flag) {
                    //生成订单
                    rep.put("nonceStr", nonce_str);
                    rep.put("package", "prepay_id=" + prepay_id);
                    Long timeStamp = System.currentTimeMillis() / 1000;
                    rep.put("timeStamp", timeStamp + "");//这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误
                    //拼接签名需要的参数
                    String stringSignTemp = "appId=" + appID + "&nonceStr=" + nonce_str + "&package=prepay_id=" + prepay_id + "&signType=MD5&timeStamp=" + timeStamp;
                    //再次签名，这个签名用于小程序端调用wx.requesetPayment方法
                    String paySign = PayUtil.sign(stringSignTemp, partnerKey, "utf-8").toUpperCase();

                    rep.put("paySign", paySign);
                    rep.put("appId", resp.get("appid"));
                    log.info(rep.toString());
                    return new JsonResult(rep);
                }
            }
        } catch (Exception e) {
            log.info("错误描述" + e.toString());
        }
        return new JsonResult();
    }


    /**
     * 通过微信用户的code换取网页授权access_token
     *
     * @return
     * @throws IOException
     * @throws
     */
    public List<Object> accessToken(String code) throws IOException {
        List<Object> list = new ArrayList<Object>();
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid="
                + appID + "&secret=" + secret + "&code=" + code + "&grant_type=authorization_code";
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(url);
        HttpResponse res = client.execute(post);
        if (res.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            HttpEntity entity = res.getEntity();
            String str = EntityUtils.toString(entity, "utf-8");
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> jsonOb = mapper.readValue(str, Map.class);
            list.add(jsonOb.get("access_token"));
            list.add(jsonOb.get("openid"));
        }
        return list;
    }


    /**
     * 收到支付结果通知时，需要验证签名，可以这样做：
     */
    @RequestMapping("/notify")
    @CrossOrigin
    public String payNotify(HttpServletRequest request, HttpServletResponse response) throws Exception{
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        log.info("=================================调用了异步通知方法！==================================");

        try {
            //获取微信服务端响应的通知
            InputStream inStream = request.getInputStream();
            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }
            outSteam.close();
            inStream.close();
            String result = new String(outSteam.toByteArray(), "utf-8");
            String notifyData = result; // 支付结果通知的xml格式数据

            MyConfig wxkey = new MyConfig();
            WXPay wxpay = new WXPay(wxkey);

            Map<String, String> notifyMap = WXPayUtil.xmlToMap(notifyData);  // 转换成map
            log.info("支付回调中腾讯返回的数据: "+notifyMap);
            if(wxpay.isPayResultNotifySignatureValid(notifyMap)){
                log.info("验证签名正确！");
                //业务方法
                String ordercode=notifyMap.get("out_trade_no");
                String buyerId=notifyMap.get("attach");
                Orders orders= iOrdersService.selectOne(new EntityWrapper<Orders>().eq("order_code",ordercode));
                iOrdersService.update(orders,new EntityWrapper<Orders>().eq("state",1));
                return "success";
            }else {
                log.info("签名错误！");  // 签名错误，如果数据里没有sign字段，也认为是签名错误
            }
        }catch (Exception e){
            log.info("异常: "+e.getMessage());
            e.printStackTrace();
        }
        return null;
    }


    /**
     * StringUtils工具类方法
     * 获取一定长度的随机字符串，范围0-9，a-z
     * @param length：指定字符串长度
     * @return 一定长度的随机字符串
     */
    public static String getRandomStringByLength(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    /**
     * IpUtils工具类方法
     * 获取真实的ip地址
     * @param request
     * @return
     */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            //多次反向代理后会有多个ip值，第一个ip才是真实ip
            int index = ip.indexOf(",");
            if(index != -1){
                return ip.substring(0,index);
            }else{
                return ip;
            }
        }
        ip = request.getHeader("X-Real-IP");
        if(StringUtils.isNotEmpty(ip) && !"unKnown".equalsIgnoreCase(ip)){
            return ip;
        }
        return request.getRemoteAddr();
    }


}