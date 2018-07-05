package com.calone.vpgilt.models;

import java.util.List;

import javax.annotation.Nonnull;

import com.calone.vpgilt.contracts.VPContract.RepositoryListener;

/**
 * Created by babas on 03/07/18.
 */

public interface SaleDataSource {
    void loadSales(@Nonnull final RepositoryListener<List<Sale>> listener);

    void loadSale(@Nonnull RepositoryListener<Sale> listener, String saleKey);
}
