package com.vav.dealsapp.dealbrowser;

import android.app.Application;

import com.vav.dealsapp.dealbrowser.core.dagger.AppModule;
import com.vav.dealsapp.dealbrowser.core.dagger.DaggerDealsComponent;
import com.vav.dealsapp.dealbrowser.core.dagger.DealsComponent;

/**
 * Created by Vaibhav on 12/7/2017.
 */

public class DealsApplication extends Application {
    private static DealsApplication application = new DealsApplication();
    private static DealsComponent component;
    @Override
    public void onCreate() {
        super.onCreate();
        getDealsComponent();
    }
    public static DealsApplication getApplication() {
        return application;
    }

    public DealsComponent getDealsComponent() {
        if(component==null){
            component=DaggerDealsComponent.builder()
                    .appModule(new AppModule(this)).build();
        }
        return component;
    }
}
