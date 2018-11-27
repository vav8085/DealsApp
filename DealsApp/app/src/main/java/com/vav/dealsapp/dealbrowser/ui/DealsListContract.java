package com.vav.dealsapp.dealbrowser.ui;

import com.vav.dealsapp.dealbrowser.model.Deal;

import java.util.List;

/**
 * Created by Vaibhav on 12/8/2017.
 */

public interface DealsListContract {
    public interface View{
        void showDeals(List<Deal> deals);
        void showRetryButton();
        void hideRetryButton();
        void showProgressBar();
        void hideProgressBar();
        void hideDeals();
        void showToast();
    }
    public interface Action{
        void loadDeals();
        void onDealClicked(Deal deal);

    }
    public interface Repository{
        void callDealsService();
    }
}
