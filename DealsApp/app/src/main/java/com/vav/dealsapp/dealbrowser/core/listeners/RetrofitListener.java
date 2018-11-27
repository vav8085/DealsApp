package com.vav.dealsapp.dealbrowser.core.listeners;

import com.vav.dealsapp.dealbrowser.model.GetDeals;

import java.util.List;

/**
 * Created by Vaibhav on 12/8/2017.
 */

public interface RetrofitListener {
    void onSuccess(GetDeals dealsResponse);
    void onFailure();
}
