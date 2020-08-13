package com.subroto.english.hotelmanagement.di.module

import android.app.Application
import android.content.Context
import com.subroto.english.hotelmanagement.data.AppDataManager
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.data.pref.IPreferencesHelper
import com.subroto.english.hotelmanagement.data.pref.PreferencesHelper
import com.subroto.english.hotelmanagement.di.PreferenceInfo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): IDataManager {
        return appDataManager
    }

    @Provides
    @PreferenceInfo
    internal fun providePreferenceName(): String {
        return "dagger_pref"
    }

    @Provides
    @Singleton
    internal fun providePreferencesHelper(appPreferencesHelper: PreferencesHelper): IPreferencesHelper {
        return appPreferencesHelper
    }
}