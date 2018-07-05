package com.calone.vpgilt.views;

import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import com.calone.vpgilt.R;
import com.calone.vpgilt.Utils.DateFormatUtils;
import com.calone.vpgilt.Utils.ImageLoaderUtils;
import com.calone.vpgilt.VPApplication;
import com.calone.vpgilt.contracts.DetailSaleContract.DetailSaleView;
import com.calone.vpgilt.contracts.VPContract.Presenter;
import com.calone.vpgilt.models.Sale;
import com.calone.vpgilt.models.SaleRepository;
import com.calone.vpgilt.presenters.DetailSalePresenter;

public class DetailSaleFragment extends VPFragment implements DetailSaleView {

    @BindView(R.id.detail_sale_image)
    CircleImageView mSaleImage;
    @BindView(R.id.detail_sale_name)
    AppCompatTextView mSaleName;
    @BindView(R.id.sale_date)
    AppCompatTextView mSaleDate;
    @BindView(R.id.sale_description)
    AppCompatTextView mSaleDescription;

    public DetailSaleFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail_sale, container, false);
        getActivity().setTitle(getString(R.string.detail_title));
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public Presenter createPresenter() {
        return new DetailSalePresenter(getArguments().getString("sale"), SaleRepository.getInstance());
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void loadData(Sale sale) {
        mSaleName.setText(sale.getName());
        mSaleDate.setText(DateFormatUtils.getConcatenedDate(sale.getDateBegin(), sale.getDateEnd()));
        mSaleDescription.setText(sale.getDescription());
        ImageLoaderUtils.loadImage(sale.getImageUrl().getLowResolution().get(0).getUrl(), mSaleImage);
    }

    @Override
    public void showToast(String message) {
        if (message != null) {
            Toast.makeText(VPApplication.getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }
}
