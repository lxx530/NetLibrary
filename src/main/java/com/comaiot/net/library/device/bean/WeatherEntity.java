/**
 * Copyright 2018 bejson.com
 */
package com.comaiot.net.library.device.bean;

import java.util.List;

/**
 * Auto-generated: 2018-09-26 0:1:49
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class WeatherEntity extends BaseEntity {

    private String data;
    private int rt;

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setRt(int rt) {
        this.rt = rt;
    }

    public int getRt() {
        return rt;
    }


    @Override
    public String toString() {
        return "WeatherEntity{" +
                "data='" + data + '\'' +
                ", rt=" + rt +
                '}';
    }
}