package com.comaiot.net.library.device.bean;

import java.io.Serializable;

public class BaiduCityEntity implements Serializable {
    private String address;
    private Content content;
    private int status;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BaiduCityEntity{" +
                "address='" + address + '\'' +
                ", content=" + content +
                ", status=" + status +
                '}';
    }

    public static class Content implements Serializable {
        private String address;
        private AddressData address_detail;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public AddressData getAddress_detail() {
            return address_detail;
        }

        public void setAddress_detail(AddressData address_detail) {
            this.address_detail = address_detail;
        }

        @Override
        public String toString() {
            return "Content{" +
                    "address='" + address + '\'' +
                    ", address_detail=" + address_detail +
                    '}';
        }
    }

    public static class AddressData implements Serializable {
        private String city;
        private String district;
        private int city_code;
        private String province;
        private String street;
        private String street_number;

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public int getCity_code() {
            return city_code;
        }

        public void setCity_code(int city_code) {
            this.city_code = city_code;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getStreet() {
            return street;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getStreet_number() {
            return street_number;
        }

        public void setStreet_number(String street_number) {
            this.street_number = street_number;
        }

        @Override
        public String toString() {
            return "AddressData{" +
                    "city='" + city + '\'' +
                    ", district='" + district + '\'' +
                    ", city_code=" + city_code +
                    ", province='" + province + '\'' +
                    ", street='" + street + '\'' +
                    ", street_number='" + street_number + '\'' +
                    '}';
        }
    }
}
