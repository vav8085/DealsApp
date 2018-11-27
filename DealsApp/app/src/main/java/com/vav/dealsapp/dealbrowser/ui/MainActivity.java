package com.vav.dealsapp.dealbrowser.ui;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.vav.dealsapp.dealbrowser.DealsApplication;
import com.vav.dealsapp.dealbrowser.R;
import com.vav.dealsapp.dealbrowser.core.datastructure.DealsContract;
import com.vav.dealsapp.dealbrowser.core.listeners.OnDealSelectedListener;
import com.vav.dealsapp.dealbrowser.model.Deal;
import com.vav.dealsapp.dealbrowser.model.GetDeals;
import com.vav.dealsapp.dealbrowser.networking.DealsApi;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends Activity implements OnDealSelectedListener,DealsListContract.View {
    @BindView(R.id.progressbar) ProgressBar progressBar;
    @BindView(R.id.retry_button) Button retryButton;

    private DealsListContract.Action mPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setStatusBarColor(this);
        if(savedInstanceState==null) {
            mPresenter = new DealListPresenter(this);
            mPresenter.loadDeals();
        }
    }

    private void setStatusBarColor(MainActivity activity) {
        Window window = activity.getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(activity, R.color.actionbar_color));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Don't create the menu for now
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    private void openFragment(Fragment fragment,String tag) {
        getFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .replace(R.id.container,fragment,tag)
                .addToBackStack(null)
                .commit();
    }
    @Override
    public void onDealSelected(Deal deal) {
        DealDetailsFragment dealDetailsFragment = new DealDetailsFragment();
        dealDetailsFragment.setDeal(deal);
        openFragment(dealDetailsFragment,DealDetailsFragment.TAG);
    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().findFragmentByTag(DealDetailsFragment.TAG)!=null
                && getFragmentManager().findFragmentByTag(DealDetailsFragment.TAG).isVisible()){
            getFragmentManager().popBackStack();
        }else finish();
    }

    @OnClick(R.id.retry_button)
    public void onRetryClick(View view) {
        mPresenter.loadDeals();
    }

    @Override
    public void showDeals(List<Deal> deals) {
        progressBar.setVisibility(View.GONE);
        retryButton.setVisibility(View.GONE);
        DealsFragment dealsFragment = new DealsFragment();
        dealsFragment.setDeals(deals);
        openFragment(dealsFragment,DealsFragment.TAG);
    }

    @Override
    public void showRetryButton() {
        retryButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideRetryButton() {
        retryButton.setVisibility(View.GONE);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void hideDeals() {
        retryButton.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showToast() {
        Toast.makeText(MainActivity.this,  R.string.no_network,Toast.LENGTH_SHORT).show();
    }
}
