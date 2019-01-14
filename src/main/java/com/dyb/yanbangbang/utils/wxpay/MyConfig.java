package com.dyb.yanbangbang.utils.wxpay;

import com.github.wxpay.sdk.WXPayConfig;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
/**
 * Created by Tang on 2018/12/15 0015.
 */
public class MyConfig implements WXPayConfig {

    private byte[] certData;

    public MyConfig() throws Exception {
        String certPath = "C:/Users/Administrator/Desktop/mammon/src/main/resources/static/apiclient_cert.p12";
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }
    @Override
    public String getAppID() {
        return "wx8ec4b362341b9d8d";
    }

    @Override
    public String getMchID() {
        return "1508698121";
    }

    @Override
    public String getKey() {
        return "KwDwhmDImmtYsO4pzCSm5nFAfYss77y2";
    }

    @Override
    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    @Override
    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    @Override
    public int getHttpReadTimeoutMs() {
        return 10000;
    }
}

