package com.vav.dealsapp.dealbrowser.ui;

import com.vav.dealsapp.dealbrowser.R;
import com.vav.dealsapp.dealbrowser.core.datastructure.DealsContract;
import com.vav.dealsapp.dealbrowser.core.listeners.RetrofitListener;
import com.vav.dealsapp.dealbrowser.model.Deal;
import com.vav.dealsapp.dealbrowser.model.GetDeals;

import javax.inject.Inject;

import retrofit2.Retrofit;

/**
 * Created by Vaibhav on 12/8/2017.
 */

public class DealListPresenter implements DealsListContract.Action, RetrofitListener {
    private DealsRepository dealsRepository;
    private final DealsListContract.View view;
    DealListPresenter(DealsListContract.View view){
        dealsRepository = new DealsRepository(this);
        this.view = view;
    }
    @Override
    public void loadDeals() {
        view.showProgressBar();
        dealsRepository.callDealsService();
    }

    @Override
    public void onDealClicked(Deal deal) {

    }

    @Override
    public void onSuccess(GetDeals dealsResponse) {
        view.showDeals(dealsResponse.getData());

    }

    @Override
    public void onFailure() {
        view.hideDeals();
        view.showToast();
    }
}
