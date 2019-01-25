package com.comaiot.net.library.phone.bean;

import java.io.Serializable;
import java.util.Arrays;

public class AppRemoveAidEntity extends BaseAppEntity {
    private Content[] content;

    public Content[] getContent() {
        return content;
    }

    public void setContent(Content[] content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static class Content implements Serializable{

    }
}
