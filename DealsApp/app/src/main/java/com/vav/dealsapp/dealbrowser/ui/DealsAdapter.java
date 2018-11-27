package com.vav.dealsapp.dealbrowser.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.vav.dealsapp.dealbrowser.R;
import com.vav.dealsapp.dealbrowser.core.listeners.OnDealSelectedListener;
import com.vav.dealsapp.dealbrowser.model.Deal;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vaibhav on 12/2/2017.
 */

public class DealsAdapter extends RecyclerView.Adapter<DealsAdapter.ViewHolder> {
    private List<Deal> deals;
    private final OnDealSelectedListener listener;

    public DealsAdapter(List<Deal> deals, OnDealSelectedListener listener) {
        this.deals = deals;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.deal_list_card,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.price.setText(deals.get(position).getPrice());
        holder.title.setText(deals.get(position).getTitle());
        holder.aisle.setText(deals.get(position).getAisle());

//        The image shows the same using Glide or picasso, in actual project the image will be from different url and will be unique
//        StringBuilder builder = new StringBuilder();
//        builder.append(deals.get(position).getImage());
//        builder.append("technics/");
//        builder.append(position+1);

        Picasso.with(holder.productImage.getContext())
                .load(deals.get(position).getImage()).fit().placeholder(R.drawable.ic_launcher)
                .networkPolicy(NetworkPolicy.NO_CACHE).error(R.drawable.ic_launcher)
                .into(holder.productImage);
    }

    @Override
    public int getItemCount() {
        return deals!=null?deals.size():0;
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.deal_list_item_image_view) ImageView productImage;
        @BindView(R.id.deal_list_item_title) TextView title;
        @BindView(R.id.deal_list_item_price) TextView price;
        @BindView(R.id.aisle) TextView aisle;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            listener.onDealSelected(deals.get(getLayoutPosition()));
        }
    }
}
