package com.tuandm12.demoretrofit.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tuandm12.demoretrofit.R;
import com.tuandm12.demoretrofit.model.Product;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Admin on 9/1/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductHolder> {
    private List<Product> listProduct;
    private Context context;

    public ProductAdapter(List<Product> listProduct, Context context) {
        this.listProduct = listProduct;
        this.context = context;
    }

    @Override
    public ProductHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item, parent, false);
        return new ProductHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductHolder holder, int position) {
        Product products = listProduct.get(position);
        holder.txtName.setText(products.getProductName());
        Glide.with(context).load(products.getThumnail())
                .centerCrop()
                .into(holder.imgThumnal);
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    class ProductHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_Thumnail)
        ImageView imgThumnal;
        @BindView(R.id.tv_Name)
        TextView txtName;

        public ProductHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
