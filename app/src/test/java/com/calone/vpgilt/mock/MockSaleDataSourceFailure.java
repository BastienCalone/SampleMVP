package com.calone.vpgilt.mock;

import java.util.List;

import javax.annotation.Nonnull;

import com.calone.vpgilt.contracts.VPContract.RepositoryListener;
import com.calone.vpgilt.models.Sale;
import com.calone.vpgilt.models.SaleDataSource;

/**
 * Created by babas on 04/07/18.
 */

public class MockSaleDataSourceFailure implements SaleDataSource {
    @Override
    public void loadSales(@Nonnull RepositoryListener<List<Sale>> listener) {
        listener.onError(new Exception("Error"));
    }

    @Override
    public void loadSale(@Nonnull RepositoryListener<Sale> listener, String saleKey) {
        listener.onError(new Exception("Error"));
    }
}
