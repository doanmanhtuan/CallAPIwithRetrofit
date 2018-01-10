package com.tuandm12.demoretrofit.service;

import com.tuandm12.demoretrofit.constant.Constant;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Admin on 9/1/2018.
 */

public interface ApiService {

    @GET("getallproducts.php")
    Call<ResponseBody> getAllProduct ();

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
