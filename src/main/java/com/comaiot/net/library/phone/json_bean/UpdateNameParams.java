package com.comaiot.net.library.phone.json_bean;

public class UpdateNameParams {
    private String sn;
    private String remark;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "UpdateNameParams{" +
                "sn='" + sn + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
