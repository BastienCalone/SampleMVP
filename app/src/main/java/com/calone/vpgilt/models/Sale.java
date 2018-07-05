package com.calone.vpgilt.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by babas on 03/07/18.
 */

public class Sale {

    @SerializedName("sale_key")
    private String mkey;
    @SerializedName("name")
    private String mName;
    @SerializedName("image_urls")
    private SaleImageList mImageUrl;
    @SerializedName("begins")
    private String mDateBegin;
    @SerializedName("ends")
    private String mDateEnd;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("sale_url")
    private String mSaleUrl;

    public SaleImageList getImageUrl() {
        return mImageUrl;
    }

    public String getDateBegin() {
        return mDateBegin;
    }

    public String getDateEnd() {
        return mDateEnd;
    }

    public String getDescription() {
        return mDescription;
    }

    public String getSaleUrl() {
        return mSaleUrl;
    }

    public String getKey() {
        return mkey;
    }

    public String getName() {
        return mName;
    }

    public void setKey(String key) {
        this.mkey = key;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public void setImageUrl(SaleImageList imageUrl) {
        this.mImageUrl = imageUrl;
    }

    public void setDateBegin(String dateBegin) {
        this.mDateBegin = dateBegin;
    }

    public void setDateEnd(String dateEnd) {
        this.mDateEnd = dateEnd;
    }

    public void setDescription(String description) {
        this.mDescription = description;
    }
}
