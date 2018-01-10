package com.tuandm12.demoretrofit.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.tuandm12.demoretrofit.R;
import com.tuandm12.demoretrofit.presenter.ProductPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    private ProductPresenter productPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        productPresenter = new ProductPresenter(this, recyclerView);
    }

    @OnClick(R.id.btnLoadData)
    public void onViewClicked() {
        productPresenter.fetchData();
    }
}
