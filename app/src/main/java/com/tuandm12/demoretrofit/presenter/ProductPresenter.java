package com.tuandm12.demoretrofit.presenter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.tuandm12.demoretrofit.adapter.ProductAdapter;
import com.tuandm12.demoretrofit.listener.GetDataCallBack;
import com.tuandm12.demoretrofit.model.Product;
import com.tuandm12.demoretrofit.service.ApiServiceImp;
import com.tuandm12.demoretrofit.view.MainActivity;

import java.util.ArrayList;

/**
 * Created by Admin on 9/1/2018.
 */

public class ProductPresenter {
    String TAG = ProductPresenter.class.getSimpleName();
    private RecyclerView.LayoutManager layoutManager;
    private ProductAdapter productAdapter;
    private ArrayList<Product> productsList;
    ApiServiceImp apiServiceIml;
    Context context;

    public ProductPresenter(Context context, RecyclerView recyclerView) {
        this.context = context;
        apiServiceIml = new ApiServiceImp();
        layoutManager = new GridLayoutManager(context,2);
        recyclerView.setLayoutManager(layoutManager);
        productsList = new ArrayList<>();
        productAdapter = new ProductAdapter(productsList,context);
        recyclerView.setAdapter(productAdapter);
    }

    /**
     * parse data
     * Noti adapter
     * */
    public void fetchData() {
        //Call method getAllProduct in API
        apiServiceIml.getAllProduct(new GetDataCallBack() {
            @Override
            public void getListSuccess(ArrayList<Product> list) {
                Log.d(TAG, list.toString());
                productsList.addAll(list);
                productAdapter.notifyDataSetChanged();
            }

            @Override
            public void getListError(Exception e) {
                Toast.makeText(context, "Đã xảy ra lỗi!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
