package com.calone.vpgilt.adapters;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import com.calone.vpgilt.R;
import com.calone.vpgilt.Utils.ImageLoaderUtils;
import com.calone.vpgilt.models.Sale;

/**
 * Created by babas on 03/07/18.
 */

public class SalesAdapter extends RecyclerView.Adapter<SalesAdapter.SaleViewHolder> {

    private List<Sale> mSales;
    private SaleClickListener mListener;

    public SalesAdapter(List<Sale> list, SaleClickListener saleClickListener) {
        mSales = list;
        mListener = saleClickListener;
    }

    @Override
    public SalesAdapter.SaleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sale_row, parent, false);
        return new SaleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SalesAdapter.SaleViewHolder holder, final int position) {
        ImageLoaderUtils.loadImage(mSales.get(position).
                getImageUrl().getLowResolution().get(0).getUrl(), holder.mSaleImage);

        holder.mSaleName.setText(mSales.get(position).getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onItemClick(mSales.get(position));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mSales.size();
    }

    class SaleViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.sale_image)
        CircleImageView mSaleImage;
        @BindView(R.id.sale_name)
        AppCompatTextView mSaleName;

        SaleViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
