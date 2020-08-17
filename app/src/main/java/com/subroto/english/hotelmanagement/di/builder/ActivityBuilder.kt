package com.subroto.english.hotelmanagement.di.builder

import com.subroto.english.hotelmanagement.ui.main.home.HomeActivity
import com.subroto.english.hotelmanagement.ui.main.home.HomeActivityModule
import com.subroto.english.hotelmanagement.ui.main.splash.SplashActivity
import com.subroto.english.hotelmanagement.ui.main.splash.SplashActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes =
    [SplashActivityModule::class,
        HomeActivityModule::class]
)

abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [SplashActivityModule::class]
    )
    internal abstract fun bindSplashActivity(): SplashActivity

    @ContributesAndroidInjector(
        modules = [HomeActivityModule::class]
    )
    internal abstract fun bindHomeActivity(): HomeActivity
}