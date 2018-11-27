package com.vav.dealsapp.dealbrowser.ui;

import android.view.View;
import android.widget.Toast;

import com.vav.dealsapp.dealbrowser.DealsApplication;
import com.vav.dealsapp.dealbrowser.R;
import com.vav.dealsapp.dealbrowser.core.listeners.RetrofitListener;
import com.vav.dealsapp.dealbrowser.model.Deal;
import com.vav.dealsapp.dealbrowser.model.GetDeals;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Vaibhav on 12/8/2017.
 */

public class DealsRepository implements DealsListContract.Repository {
    @Inject Call<GetDeals> call;

    private RetrofitListener listener;

    DealsRepository(RetrofitListener listener){
        this.listener = listener;
        DealsApplication.getApplication().getDealsComponent().inject(this);
    }

    @Override
    public void callDealsService() {
        call.clone().enqueue(new Callback<GetDeals>() {
            @Override
            public void onResponse(Call<GetDeals> call, Response<GetDeals> response) {
                listener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<GetDeals> call, Throwable t) {
                listener.onFailure();
            }
        });
    }
}

