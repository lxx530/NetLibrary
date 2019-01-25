package com.comaiot.net.library.device.bean;

import java.io.Serializable;
import java.util.Arrays;

public class IpEntity extends BaseEntity {
    private String city;
    private String country;
    private String query;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "IpEntity{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", query='" + query + '\'' +
                '}';
    }
}
