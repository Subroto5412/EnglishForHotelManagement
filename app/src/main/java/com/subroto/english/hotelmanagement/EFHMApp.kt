package com.subroto.english.hotelmanagement

import android.content.Context
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject
import com.subroto.english.hotelmanagement.di.component.DaggerIAppComponent

class EFHMApp : MultiDexApplication(), HasAndroidInjector {
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Any>
    val context: Context
        get() = applicationContext

    override fun androidInjector(): AndroidInjector<Any>? {
        return activityDispatchingAndroidInjector
    }

    override fun onCreate() {
        super.onCreate()
        DaggerIAppComponent.builder()
            .application(this)
            .build()
            .inject(this)

      //  AppLogger.init(); //Logger

//        AndroidNetworking.initialize(applicationContext)
//        if (BuildConfig.DEBUG) {
//            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY)
//        }

        //CalligraphyConfig.initDefault(mCalligraphyConfig)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}