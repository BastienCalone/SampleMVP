package com.calone.vpgilt.models;

import android.support.annotation.NonNull;

import java.util.List;

import javax.annotation.Nonnull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.calone.vpgilt.R;
import com.calone.vpgilt.VPApplication;
import com.calone.vpgilt.contracts.VPContract.RepositoryListener;
import com.calone.vpgilt.services.APIClient;


/**
 * Created by babas on 03/07/18.
 */

public class SaleRepository implements SaleDataSource {

    private static SaleRepository mSaleRepository = null;
    private SaleList mListSales;
    private String apiKey = VPApplication.getContext().getString(R.string.apikey);

    public static SaleRepository getInstance() {
        if (mSaleRepository == null) {
            mSaleRepository = new SaleRepository();
        }

        return mSaleRepository;
    }

    public void loadSales(@Nonnull final RepositoryListener<List<Sale>> listener) {
        if (mListSales != null) {
            listener.onSuccess(getSubList(mListSales.getSaleList()));
        }

        SaleApi saleApi = APIClient.getClient().create(SaleApi.class);
        final Call<SaleList> listCall = saleApi.getSales(apiKey);
        listCall.enqueue(new Callback<SaleList>() {
            @Override
            public void onResponse(@NonNull Call<SaleList> call, @NonNull Response<SaleList> response) {
                mListSales = response.body();
                if (mListSales != null) {
                    listener.onSuccess(getSubList(mListSales.getSaleList()));

                } else {
                    listener.onError(new Exception("No data found"));
                }
            }

            @Override
            public void onFailure(Call<SaleList> call, Throwable t) {
                listener.onError(new Exception("Error API"));
            }
        });
    }

    public void loadSale(@Nonnull RepositoryListener<Sale> listener, String saleKey) {
        int i;
        for (i = 0; i < mListSales.getSaleList().size(); i++) {
            if (mListSales.getSaleList().get(i).getKey().equals(saleKey)) {
                listener.onSuccess(mListSales.getSaleList().get(i));
                return;
            }
        }

        listener.onError(new Exception("No Data Found"));
    }

    private List<Sale> getSubList(List<Sale> list) {
        if (list.size() > 10) {
            list = list.subList(0, 10);
        }

        return list;
    }
}
