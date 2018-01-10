package com.tuandm12.demoretrofit.service;

import android.util.Log;

import com.tuandm12.demoretrofit.listener.GetDataCallBack;
import com.tuandm12.demoretrofit.model.Product;

import org.json.JSONArray;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Admin on 9/1/2018.
 */

public class ApiServiceImp {
    String TAG = ApiServiceImp.class.getSimpleName();
    ApiService apiService;

    public void getAllProduct(final GetDataCallBack dataCallback) {
        apiService = ApiService.retrofit.create(ApiService.class);
        Call<ResponseBody> getProduct = apiService.getAllProduct();
        getProduct.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    JSONArray jsonArray = new JSONArray((response.body().string()));
                    dataCallback.getListSuccess(Product.getAllProduct(jsonArray));
                } catch (Exception e) {
                    dataCallback.getListError(e);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                dataCallback.getListError(new Exception(t));
            }
        });
    }
}
