package com.comaiot.net.library.phone.inter;

import android.util.Base64;
import android.util.Log;

import com.comaiot.net.library.phone.okhttp.Logger;

import java.net.URLDecoder;
import java.net.URLEncoder;

public class BaseUrl {
    private static String BASE_URL = "I276dbmOVthXyG377YHQmwAqxoRKuQ9DcNiuo32+I87pU//YYJiDkP/QZENicrSiMQnDQbzrXAYdzcBHcGOkyQ==";

    public static final String getBaseUrl() {
        return URLDecoder.decode(new String(Base64.decode(DESUtils.decryptBaseUrl(getUrl()), Base64.DEFAULT)));
    }

    public static final void setBaseUrl(String baseUrl) {
        BASE_URL = baseUrl;
    }

    private static final String getUrl() {
        return BASE_URL;
    }
}
