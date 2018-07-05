package com.calone.vpgilt.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by babas on 03/07/18.
 */

public class SaleImage {

    @SerializedName("url")
    private String mUrl;

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        this.mUrl = url;
    }
}
