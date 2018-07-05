package com.calone.vpgilt.presenters;

import android.support.annotation.NonNull;

import com.calone.vpgilt.contracts.DetailSaleContract.DetailSaleView;
import com.calone.vpgilt.contracts.VPContract.Presenter;
import com.calone.vpgilt.contracts.VPContract.RepositoryListener;
import com.calone.vpgilt.models.Sale;
import com.calone.vpgilt.models.SaleDataSource;

/**
 * Created by babas on 03/07/18.
 */

public class DetailSalePresenter implements Presenter<DetailSaleView> {

    private String key;
    private SaleDataSource saleRepository;
    private DetailSaleView detailSaleView;

    public DetailSalePresenter(String saleKey, SaleDataSource saleDataSource) {
        this.key = saleKey;
        saleRepository = saleDataSource;
    }

    @Override
    public void attachView(@NonNull DetailSaleView view) {
        detailSaleView = view;
        loadSale();
    }

    @Override
    public void detachView() {
        detailSaleView = null;
    }

    private void loadSale() {
        saleRepository.loadSale(new RepositoryListener<Sale>() {
            @Override
            public void onSuccess(Sale model) {
                if (detailSaleView != null) {
                    detailSaleView.loadData(model);
                }
            }

            @Override
            public void onError(Exception e) {
                if (detailSaleView != null) {
                    detailSaleView.showToast(e.getMessage());
                }
            }
        }, key);
    }
}
