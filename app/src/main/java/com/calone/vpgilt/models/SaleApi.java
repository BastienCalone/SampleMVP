package com.calone.vpgilt.models;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by babas on 04/07/18.
 */

public interface SaleApi {
    @GET("women/active.json")
    Call<SaleList> getSales(@Query("apikey") String key);
}
