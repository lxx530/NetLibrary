//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.comaiot.net.library.phone.bean;

import java.io.Serializable;

public class BaseAppEntity implements Serializable {
    private int errcode;
    private String errmsg;

    public BaseAppEntity() {
    }

    public int getErrcode() {
        return this.errcode;
    }

    public void setErrcode(int var1) {
        this.errcode = var1;
    }

    public String getErrmsg() {
        return this.errmsg;
    }

    public void setErrmsg(String var1) {
        this.errmsg = var1;
    }

    public String toString() {
        return "BaseAppEntity{errcode=" + this.errcode + ", errmsg='" + this.errmsg + '\'' + '}';
    }
}
