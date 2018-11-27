package com.vav.dealsapp.dealbrowser.core.dagger;

import android.content.Context;

import com.vav.dealsapp.dealbrowser.DealsApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Vaibhav on 12/7/2017.
 */
@Module
public class AppModule {
    private final DealsApplication application;

    public AppModule(DealsApplication application) {
        this.application = application;
    }
    @Provides @Singleton
    public DealsApplication provideApplication(){
        return application;
    }
    @Provides @Singleton
    public Context provideContext(){
        return application;
    }

}
