package com.vav.dealsapp.dealbrowser.core.dagger;

import com.vav.dealsapp.dealbrowser.model.Deal;
import com.vav.dealsapp.dealbrowser.model.GetDeals;
import com.vav.dealsapp.dealbrowser.networking.DealsApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Vaibhav on 12/7/2017.
 */
@Module
public class NetworkModule {
    @Provides
    public Call<GetDeals> retrofitProvider(){
        return DealsApi.getDealsApi().getDeals();
    }
}
