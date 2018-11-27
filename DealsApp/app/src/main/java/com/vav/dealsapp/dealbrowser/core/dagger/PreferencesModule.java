package com.vav.dealsapp.dealbrowser.core.dagger;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Vaibhav on 12/7/2017.
 */
@Module
public class PreferencesModule {
    @Provides @Singleton
    public SharedPreferences sharedPreferencesProvider(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
}
