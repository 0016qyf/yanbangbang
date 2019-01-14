package com.dyb.yanbangbang.utils.wxpay;

public class WxPayConfig {
    //小程序appid
    public static final String appid = "wx9a8a1c8388581a1f";
    //微信支付的商户id
    public static final String mch_id = "1504921851";
    //微信支付的商户密钥
    public static final String key = "3531085994185joaig8903j";
    //支付成功后的服务器回调url
    public static final String notify_url = "https://hh.com/wxdev/notify";


    //签名方式，固定值
    public static final String SIGNTYPE = "MD5";
    //交易类型，小程序支付的固定值为JSAPI
    public static final String TRADETYPE = "JSAPI";
    //微信统一下单接口地址
    public static final String pay_url = "https://api.mch.weixin.qq.com/pay/unifiedorder";


}
