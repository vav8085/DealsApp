package com.vav.dealsapp.dealbrowser.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.vav.dealsapp.dealbrowser.DealsApplication;
import com.vav.dealsapp.dealbrowser.R;
import com.vav.dealsapp.dealbrowser.core.datastructure.DealsCart;
import com.vav.dealsapp.dealbrowser.model.Deal;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Vaibhav on 12/3/2017.
 */

public class DealDetailsFragment extends Fragment {
    public static final String TAG = "DealDetailsFragment";
    @BindView(R.id.deals_detail_picture) ImageView dealsImage;
    @BindView(R.id.details_sale_price) TextView dealsSalePrice;
    @BindView(R.id.details_price) TextView dealsPrice;
    @BindView(R.id.details_title) TextView dealsTitle;
    @BindView(R.id.details_details) TextView dealsDescription;
    @BindView(R.id.button_add_to_cart) Button addToCart;
    @BindView(R.id.button_add_to_list) Button addToList;
    @BindView(R.id.regular_price_strike) View strikeThrough;
    @Inject DealsCart dealsCart;

    private Context context;
    Deal deal = null;
    public DealDetailsFragment() {
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deal_details, container, false);
        ButterKnife.bind(this,view);
        DealsApplication.getApplication().getDealsComponent().inject(this);
        setRetainInstance(true);
        dealsPrice.setText(deal.getPrice());
        dealsSalePrice.setText(deal.getSalePrice());
        setStrikethroughVisibility();
        dealsTitle.setText(deal.getTitle());
        dealsDescription.setText(deal.getDescription());
        Picasso.with(dealsImage.getContext())
                .load(deal.getImage()).fit().placeholder(R.drawable.ic_launcher)
                .networkPolicy(NetworkPolicy.NO_CACHE).error(R.drawable.ic_launcher)
                .into(dealsImage);

        return view;
    }

    public void setStrikethroughVisibility(){
        if(deal.getSalePrice()==null || deal.getSalePrice().equals("")){
            strikeThrough.setVisibility(View.GONE);
        }else strikeThrough.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @OnClick(R.id.button_add_to_cart)
    void onAddToCart(){
        dealsCart.addItemsToCart(deal);
        Toast.makeText(context," Added to cart!, Total Items="+dealsCart.getDealsCart().size(),Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.button_add_to_list)
    void onAddToList(){
        Toast.makeText(context, R.string.added_to_list,Toast.LENGTH_SHORT).show();
    }

    public void setDeal(Deal deal) {
        this.deal = deal;
    }
}
