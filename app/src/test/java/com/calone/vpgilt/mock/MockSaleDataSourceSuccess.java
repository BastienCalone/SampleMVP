package com.calone.vpgilt.mock;

import android.support.annotation.NonNull;

import java.util.List;

import javax.annotation.Nonnull;

import com.calone.vpgilt.contracts.VPContract.RepositoryListener;
import com.calone.vpgilt.models.Sale;
import com.calone.vpgilt.models.SaleDataSource;

/**
 * Created by babas on 04/07/18.
 */

public class MockSaleDataSourceSuccess implements SaleDataSource {

    @NonNull
    private final List<Sale> mListSale;
    @NonNull
    private final Sale mSale;

    public MockSaleDataSourceSuccess(@NonNull Sale sale, List<Sale> lstSale) {
        this.mListSale = lstSale;
        this.mSale = sale;
    }


    @Override
    public void loadSales(@Nonnull RepositoryListener<List<Sale>> listener) {
        listener.onSuccess(mListSale);
    }

    @Override
    public void loadSale(@Nonnull RepositoryListener<Sale> listener, String saleKey) {
        listener.onSuccess(mSale);
    }
}
