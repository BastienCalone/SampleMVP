package com.calone.vpgilt.contracts;

import java.util.List;

import com.calone.vpgilt.contracts.VPContract.VPView;
import com.calone.vpgilt.models.Sale;

/**
 * Created by babas on 03/07/18.
 */

public interface SalesContract {

    interface SalesView extends VPView {
        void loadRecyclerView(List<Sale> sales);

        void showToast(String message);
    }
}
