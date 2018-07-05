package com.calone.vpgilt.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.calone.vpgilt.contracts.VPContract.VPView;
import com.calone.vpgilt.contracts.VPContract.Presenter;

/**
 * Created by babas on 03/07/18.
 */

public abstract class VPFragment extends Fragment implements VPView {
    Presenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View createView = super.onCreateView(inflater, container, savedInstanceState);
        return createView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mPresenter.attachView(this);
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    abstract public Presenter createPresenter();

    @Override
    public Presenter getPresenter() {
        return mPresenter;
    }

    @Override
    public void onDestroyView() {
        mPresenter.detachView();
        super.onDestroyView();
    }
}