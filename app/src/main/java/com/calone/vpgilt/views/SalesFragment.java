package com.calone.vpgilt.views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import com.calone.vpgilt.R;
import com.calone.vpgilt.Utils.FragmentLauncherUtils;
import com.calone.vpgilt.VPApplication;
import com.calone.vpgilt.adapters.SaleClickListener;
import com.calone.vpgilt.adapters.SalesAdapter;
import com.calone.vpgilt.contracts.SalesContract.SalesView;
import com.calone.vpgilt.contracts.VPContract.Presenter;
import com.calone.vpgilt.models.Sale;
import com.calone.vpgilt.models.SaleRepository;
import com.calone.vpgilt.presenters.SalesPresenter;

public class SalesFragment extends VPFragment implements SalesView {

    @BindView(R.id.sales_container)
    RecyclerView mRecyclerView;

    public SalesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sales, container, false);
        getActivity().setTitle(getString(R.string.home_title));
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public Presenter createPresenter() {
        return new SalesPresenter(SaleRepository.getInstance());
    }

    @Override
    public void loadRecyclerView(List<Sale> sales) {
        SalesAdapter salesAdapter = new SalesAdapter(sales, saleClickListener);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(salesAdapter);
    }

    @Override
    public void showToast(String message) {
        if (message != null) {
            Toast.makeText(VPApplication.getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    private SaleClickListener saleClickListener = new SaleClickListener() {
        @Override
        public void onItemClick(Sale sale) {
            Bundle bundle = new Bundle();
            bundle.putString("sale", sale.getKey());
            FragmentLauncherUtils.launchFragment((AppCompatActivity) getActivity(), DetailSaleFragment.class, bundle);
        }
    };
}
