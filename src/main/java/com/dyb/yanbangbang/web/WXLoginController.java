package com.dyb.yanbangbang.web;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.dyb.yanbangbang.entity.User;
import com.dyb.yanbangbang.service.IUserService;
import com.dyb.yanbangbang.utils.AesUtil;
import com.dyb.yanbangbang.utils.HttpRequest;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Tang on 2018/9/18.
 */
@Controller
@RequestMapping(value = "/wx/")
public class WXLoginController {
    private static final Logger log = LoggerFactory.getLogger(WXLoginController.class);

    @Autowired
    private IUserService iUserService;

    //小程序唯一标识   (在微信小程序管理后台获取)
    String wxspAppid = "wx5f10e67fba9770ad";
    //小程序的 app secret (在微信小程序管理后台获取)
    String wxspSecret = "ba5935af8d21de3a228c6fed570c9f42";
    //授权（必填）
    String grant_type = "authorization_code";

    //获取用户信息的后台
    @ResponseBody
    @RequestMapping(value = "decodeUserInfo", method = RequestMethod.POST)
    public Map decodeUserInfo(String encryptedData, String iv, String code, String session_key) throws Exception{
        log.info("======== encryptedData: "+encryptedData);
        log.info("======== iv: "+iv);
        log.info("======== code: "+code);
        log.info("======== session_key: "+session_key);

        Map map = new HashMap();
        //登录凭证不能为空
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return map;
        }
        if(session_key=="") {
            //请求参数
            String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
            //发送请求
            String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
            //解析相应内容（转换成json对象）
            JSONObject json = JSONObject.parseObject(sr);
            //获取会话密钥（session_key）
            session_key = json.get("session_key").toString();
            log.info("获取用户信息时得到的会话密钥（session_key）："+session_key);
            //用户的唯一标识（openid）
            String openid = (String) json.get("openid");
            log.info("openId: "+openid);
        }

        //////////////// 2、对encryptedData加密数据进行AES解密 ////////////////
        try {
            String result = AesUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            log.info("解密用户信息返回的结果："+result);
            if (null != result && result.length() > 0) {
                map.put("status", 1);
                map.put("msg", "解密成功");

                JSONObject userInfoJSON = JSONObject.parseObject(result);
                Map userInfo = new HashMap();
                userInfo.put("openId", userInfoJSON.get("openId"));
                userInfo.put("nickName", userInfoJSON.get("nickName"));
                userInfo.put("gender", userInfoJSON.get("gender"));
                userInfo.put("city", userInfoJSON.get("city"));
                userInfo.put("province", userInfoJSON.get("province"));
                userInfo.put("country", userInfoJSON.get("country"));
                userInfo.put("avatarUrl", userInfoJSON.get("avatarUrl"));
                userInfo.put("unionId", userInfoJSON.get("unionId"));
                map.put("userInfo", userInfo);
                map.put("session_key", session_key);
                log.info("从微信获取到的个人信息："+map.toString());
                return map;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        map.put("status", 0);
        map.put("msg", "解密失败");
        return map;
    }
    //获取电话号码的后台
    @ResponseBody
    @RequestMapping(value = "decodePhoneInfo", method = RequestMethod.POST)
    public Map decodePhoneInfo(String encryptedData, String iv, String code,String session_key,String userInfo) throws Exception{
        log.info("——————————————————in decodePhoneInfo——————————————————————");
        log.info("------encryptedData: "+encryptedData);
        log.info("------iv: "+iv);
        log.info("------code: "+code);
        log.info("------session_key: "+session_key);
        log.info("------userInfo: "+userInfo);
        Map map = new HashMap();
        String openId = null;

        //登录凭证不能为空
        if (code == null || code.length() == 0) {
            map.put("status", 0);
            map.put("msg", "code 不能为空");
            return map;
        }
        if(session_key==""){
            log.info("%%%%%%%%%进入到获取session_key判断里！");
            //请求参数
            String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
            //发送请求
            String sr = HttpRequest.sendGet("https://api.weixin.qq.com/sns/jscode2session", params);
            //解析相应内容（转换成json对象）
            JSONObject json = JSONObject.parseObject(sr);
            //获取会话密钥（session_key）
            session_key = json.get("session_key").toString();
            log.info("获取到的会话密钥（session_key）："+session_key);
            //用户的唯一标识（openid）
            openId = (String) json.get("openid");
            log.info("openId:"+openId);
        }

        //////////////// 2、对encryptedData加密数据进行AES解密 ////////////////
        try {
            log.info("要解密的会话密钥（session_key）："+session_key);
            String result = AesUtil.decrypt(encryptedData, session_key, iv, "UTF-8");
            if (null != result && result.length() > 0) {
                map.put("status", 1);
                map.put("msg", "解密成功");

                JSONObject phoneInfoJSON = JSONObject.parseObject(result);
                log.info("获取到的电话号码："+phoneInfoJSON.get("phoneNumber"));
                Map phoneInfo = new HashMap();
                phoneInfo.put("phoneNumber", phoneInfoJSON.get("phoneNumber"));
                phoneInfo.put("purePhoneNumber", phoneInfoJSON.get("purePhoneNumber"));
                phoneInfo.put("countryCode", phoneInfoJSON.get("countryCode"));

                map.put("phoneInfo", phoneInfo);
                map.put("session_key", session_key);

                JSONObject jsonObject = JSON.parseObject(userInfo);
                log.info("====userInfo===== : "+jsonObject.toString());
                User user = iUserService.selectOne(new EntityWrapper<User>().eq("openid",jsonObject.getString("openId")));
                //将获取到的信息保存到数据库（user表中）
                //{"country":"China","unionId":"oqL2y0mKqvs5M-pXrqVIlPN2xBlQ","gender":1,"province":"Zhejiang","city":"Hangzhou","avatarUrl":"https://wx.qlogo.cn/mmopen/vi_32/Wicb9BG8vk6rKLve9fNrrfbbd5OwmK2kwkorUzhIoSe84ZNwR2jIic7VxJKdcWicKvVFEaHvqWnz6vPJeAGz6RvIg/132","openId":"otUZN5UgSCbZ__Y-lCpy_bRxrc6o","nickName":"é\u0094\u0084ç¦¾ð\u009F\u0090¦"}
                if (user != null){  //已经有该用户信息了
                    user.setOpenid(jsonObject.getString("openId"));
                    user.setUnionid(jsonObject.getString("unionId"));
                    user.setGender(Integer.parseInt(jsonObject.getString("gender")));
                    user.setAvatarurl(jsonObject.getString("avatarUrl"));
                    user.setPhone(phoneInfoJSON.get("phoneNumber").toString());
                    //对昵称进行base64编码
                    String nikeName = Base64.encodeBase64String(jsonObject.getString("nickName").getBytes("UTF-8"));
                    log.info("Base64编码后的昵称："+nikeName);
                    user.setNikeName(nikeName);  //昵称
                    iUserService.updateByUserId(user);
                }else {   //没有该用户，则新建
                    User user1 = new User();
                    user1.setAvatarurl(jsonObject.getString("avatarUrl"));
                    user1.setOpenid(jsonObject.getString("openId"));
                    user1.setUnionid(jsonObject.getString("unionId"));
                    user1.setPhone(phoneInfoJSON.get("phoneNumber").toString());
                    //对昵称进行base64编码
                    String nikeName = Base64.encodeBase64String(jsonObject.getString("nickName").getBytes("UTF-8"));
                    log.info("Base64编码后的昵称："+nikeName);
                    user1.setNikeName(nikeName);  //昵称
                    iUserService.insert(user1);
                }

                User user2 = iUserService.selectOne(new EntityWrapper<User>().eq("openid",jsonObject.getString("openId")));
                log.info("=======: "+user2.toString());
                //对用户昵称进行解码
                String nikeName = new String(Base64.decodeBase64(user2.getNikeName()),"UTF-8");
                log.info("Base64解码后的昵称："+nikeName);

                map.put("userId",user2.getUserId());
                map.put("openid",user2.getOpenid());
                map.put("phone",user2.getPhone());
                map.put("avatarurl",user2.getAvatarurl());
                map.put("nikeName",nikeName);
                map.put("gender",user2.getGender());
                map.put("school",user2.getSchool());
                map.put("major",user2.getMajor());
                map.put("type",user2.getType());
                map.put("state",user2.getState());
                return map;
            }
        } catch (Exception e) {
            log.info("decodePhoneInfo"+e.getMessage());
            e.printStackTrace();
        }
        map.put("status", 0);
        map.put("msg", "解密失败");
        return map;
    }


    /**
     * 登录
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public String login(HttpServletRequest request) throws Exception{
        request.setCharacterEncoding("utf-8");
        String res = "fail";
        String msg = "";
        int code = -1;
        try{
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String unionId = request.getParameter("unionId");
            String openId = request.getParameter("openId");
            String avatarUrl = request.getParameter("avatarUrl");

            log.info("username: "+username);
            log.info("password: "+password);
            log.info("unionId: "+unionId);
            log.info("openId: "+openId);
            log.info("avatarUrl: "+avatarUrl);

//            User user = userService.findUserByPhone(username);
//            if (user != null){  //手机号一致
//                if (user.getLoginPassword().equals(password)){  //密码正确
//
//                    res = "success";
//                    code = 1;
//                }else {
//                    code = -2;
//                    msg = "密码错误！";
//                }
//            }else {
//                msg = "用户名错误！";
//            }
        }catch (Exception e){
            e.printStackTrace();
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("res",res);
        jsonObject.put("msg",msg);
        jsonObject.put("code",code);
        return jsonObject.toString();
    }

}
