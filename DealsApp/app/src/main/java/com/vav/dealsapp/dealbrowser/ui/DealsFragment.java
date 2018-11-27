package com.vav.dealsapp.dealbrowser.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vav.dealsapp.dealbrowser.R;
import com.vav.dealsapp.dealbrowser.core.listeners.OnDealSelectedListener;
import com.vav.dealsapp.dealbrowser.model.Deal;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vaibhav on 12/2/2017.
 */

public class DealsFragment extends Fragment {
    public static final String TAG = "DealsFragment";
    @BindView(R.id.deals_recycler_view) RecyclerView dealsRecyclerView;
    private List<Deal> deals;

    public DealsFragment() {}
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_deal_list, container, false);
        ButterKnife.bind(this,view);
        //ToDo change layout manager as per type value coming in response
        dealsRecyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        DealsAdapter adapter = new DealsAdapter(deals,(MainActivity) this.getActivity());
        dealsRecyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        setRetainInstance(true);
        return view;
    }
    public void setDeals(List<Deal> deals) {
        this.deals = deals;
    }
}
