package com.vav.dealsapp.dealbrowser.core.datastructure;

import android.content.SharedPreferences;

import com.vav.dealsapp.dealbrowser.model.Deal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vaibhav on 12/7/2017.
 */

public class DealsCart implements DealsContract {
    private final SharedPreferences preferences;
    private List<Deal> dealsCart;

    public DealsCart(SharedPreferences preferences) {
        this.preferences = preferences;
        dealsCart = new ArrayList<>();
    }

    @Override
    public List<Deal> getDealsCart() {
        return dealsCart;
    }

    @Override
    public void addItemsToCart(Deal deal) {
        dealsCart.add(deal);
    }

    @Override
    public void removeItemFromCart(Deal deal) {
        for(Deal d: dealsCart){
            if(d.getId()==deal.getId()){
                dealsCart.remove(deal);
                break;
            }
        }
    }

    @Override
    public void RemoveAllItemsFromCart() {
        dealsCart.clear();
    }

    @Override
    public void checkout() {
        dealsCart.clear();
    }
}
