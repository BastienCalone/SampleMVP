package com.calone.vpgilt.presenters;

import android.support.annotation.NonNull;

import java.util.List;

import com.calone.vpgilt.contracts.SalesContract.SalesView;
import com.calone.vpgilt.contracts.VPContract.RepositoryListener;
import com.calone.vpgilt.contracts.VPContract.Presenter;
import com.calone.vpgilt.models.Sale;
import com.calone.vpgilt.models.SaleDataSource;

/**
 * Created by babas on 03/07/18.
 */

public class SalesPresenter implements Presenter<SalesView> {

    private final SaleDataSource saleRepository;
    private SalesView salesView;

    public SalesPresenter(SaleDataSource saleDataSource) {
        saleRepository = saleDataSource;
    }

    @Override
    public void attachView(@NonNull SalesView view) {
        salesView = view;
        loadSales();
    }

    @Override
    public void detachView() {
        salesView = null;
    }

    private void loadSales() {
        saleRepository.loadSales(new RepositoryListener<List<Sale>>() {
            @Override
            public void onSuccess(List<Sale> model) {
                if (salesView != null) {
                    salesView.loadRecyclerView(model);
                }
            }

            @Override
            public void onError(Exception e) {
                if (salesView != null) {
                    salesView.showToast(e.getMessage());
                }
            }
        });
    }
}
