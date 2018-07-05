package com.calone.vpgilt.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by babas on 03/07/18.
 */

public class SaleImageList {

    @SerializedName("161x110")
    private List<SaleImage> mLowResolution;

    public List<SaleImage> getLowResolution() {
        return mLowResolution;
    }

    public void setLowResolution(List<SaleImage> lowResolution) {
        this.mLowResolution = lowResolution;
    }
}
