package com.calone.vpgilt.contracts;

import android.support.annotation.NonNull;

/**
 * Created by babas on 03/07/18.
 */

public interface VPContract {

    interface Presenter<V extends VPView> {

        void attachView(@NonNull final V view);

        void detachView();
    }


    interface RepositoryListener<M extends Object> {

        void onSuccess(M model);

        void onError(Exception e);
    }

    interface VPView {
        Presenter createPresenter();

        Presenter getPresenter();
    }
}
