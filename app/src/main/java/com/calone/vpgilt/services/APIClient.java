package com.calone.vpgilt.services;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.calone.vpgilt.R;
import com.calone.vpgilt.VPApplication;

/**
 * Created by babas on 03/07/18.
 */

public class APIClient {

    private static Retrofit mRetrofit = null;
    private static String baseUrl = VPApplication.getContext().getString(R.string.api_url);

    public static Retrofit getClient() {
        if (mRetrofit == null) {
            OkHttpClient client = new OkHttpClient.Builder().build();
            mRetrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();
        }
        return mRetrofit;
    }
}
