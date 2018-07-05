package com.calone.vpgilt.contracts;

import com.calone.vpgilt.contracts.VPContract.VPView;
import com.calone.vpgilt.models.Sale;

/**
 * Created by babas on 03/07/18.
 */

public interface DetailSaleContract {

    interface DetailSaleView extends VPView {
        void loadData(Sale sale);

        void showToast(String message);
    }
}
