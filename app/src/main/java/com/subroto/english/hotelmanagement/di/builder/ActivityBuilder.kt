package com.subroto.english.hotelmanagement.di.builder

import com.subroto.english.hotelmanagement.ui.main.splash.SplashActivity
import com.subroto.english.hotelmanagement.ui.main.splash.SplashActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(
    includes =
    [SplashActivityModule::class]
)

abstract class ActivityBuilder {

    @ContributesAndroidInjector(
        modules = [SplashActivityModule::class]
    )
    internal abstract fun bindSplashActivity(): SplashActivity
}