package com.vav.dealsapp.dealbrowser.core.dagger;

import android.content.SharedPreferences;

import com.vav.dealsapp.dealbrowser.core.datastructure.DealsCart;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Vaibhav on 12/7/2017.
 */
@Module
public class DealsCartModule {
    @Provides @Singleton
    public DealsCart providesDealsCart(SharedPreferences preferences){
        return new DealsCart(preferences);
    }
}
