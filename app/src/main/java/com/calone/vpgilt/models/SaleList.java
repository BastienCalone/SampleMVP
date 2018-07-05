package com.calone.vpgilt.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by babas on 03/07/18.
 */

public class SaleList {
    @SerializedName("sales")
    private List<Sale> mSaleList;

    public List<Sale> getSaleList() {
        return mSaleList;
    }
}
