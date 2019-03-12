package com.comaiot.net.library.device.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class BaiduSnUtils {
    public static String getSN(String ip) {
        String sn = null;
        Map paramsMap = new LinkedHashMap<String, String>();
        paramsMap.put("ip", ip);
        paramsMap.put("ak", "sNSaHzOlS0lQ1thSpQCCfs2WWtEWi6Gy");
        paramsMap.put("coor", "bd09ll");
        // 调用下面的toQueryString方法，对LinkedHashMap内所有value作utf8编码，拼接返回结果address=%E7%99%BE%E5%BA%A6%E5%A4%A7%E5%8E%A6&output=json&ak=yourak
        String paramsStr = null;
        try {
            paramsStr = toQueryString(paramsMap);
        } catch (UnsupportedEncodingException e) {
            return sn;
        }

        // 对paramsStr前面拼接上/geocoder/v2/?，后面直接拼接yoursk得到/geocoder/v2/?address=%E7%99%BE%E5%BA%A6%E5%A4%A7%E5%8E%A6&output=json&ak=yourakyoursk
        String wholeStr = new String("/location/ip?" + paramsStr + "QTFfNqnaW72sCqjZlPAid3mX2hS3EdOZ");

        // 对上面wholeStr再作utf8编码
        String tempStr = null;
        try {
            tempStr = URLEncoder.encode(wholeStr, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return sn;
        }

        sn = MD5(tempStr);
        // 调用下面的MD5方法得到最后的sn签名7de5a22212ffaa9e326444c75a58f9a0
        return sn;
    }

    // 对Map内所有value作utf8编码，拼接返回结果
    private static String toQueryString(Map<?, ?> data)
            throws UnsupportedEncodingException {
        StringBuffer queryString = new StringBuffer();
        for (Map.Entry<?, ?> pair : data.entrySet()) {
            queryString.append(pair.getKey() + "=");
            queryString.append(URLEncoder.encode((String) pair.getValue(),
                    "UTF-8") + "&");
        }
        if (queryString.length() > 0) {
            queryString.deleteCharAt(queryString.length() - 1);
        }
        return queryString.toString();
    }

    // 来自stackoverflow的MD5计算方法，调用了MessageDigest库函数，并把byte数组结果转换成16进制
    private static String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest
                    .getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
                        .substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }
}
