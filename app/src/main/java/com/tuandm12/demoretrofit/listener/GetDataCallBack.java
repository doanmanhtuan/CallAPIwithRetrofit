package com.tuandm12.demoretrofit.listener;

import com.tuandm12.demoretrofit.model.Product;

import java.util.ArrayList;

/**
 * Created by Admin on 9/1/2018.
 */

public interface GetDataCallBack {
    void getListSuccess(ArrayList<Product> list);
    void getListError(Exception e);
}
