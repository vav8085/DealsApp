package com.vav.dealsapp.dealbrowser.core.dagger;

import com.vav.dealsapp.dealbrowser.core.datastructure.DealsCart;
import com.vav.dealsapp.dealbrowser.ui.DealDetailsFragment;
import com.vav.dealsapp.dealbrowser.ui.DealsRepository;
import com.vav.dealsapp.dealbrowser.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Vaibhav on 12/7/2017.
 */

@Singleton
@Component(
        modules = {
                AppModule.class, PreferencesModule.class, DealsCartModule.class, NetworkModule.class
        }
)
public interface DealsComponent {
    void inject(MainActivity mainActivity);
    void inject(DealsCart dealsCart);
    void inject (DealsRepository dealsRepository);
    void inject(DealDetailsFragment dealsFragment);
}
