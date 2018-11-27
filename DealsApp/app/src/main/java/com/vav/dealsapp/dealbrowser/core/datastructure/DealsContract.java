package com.vav.dealsapp.dealbrowser.core.datastructure;

import com.vav.dealsapp.dealbrowser.model.Deal;

import java.util.List;

/**
 * Created by Vaibhav on 12/6/2017.
 */

public interface DealsContract {
    List<Deal> getDealsCart();
    void addItemsToCart(Deal deal);
    void removeItemFromCart(Deal deal);
    void RemoveAllItemsFromCart();
    void checkout();
}
