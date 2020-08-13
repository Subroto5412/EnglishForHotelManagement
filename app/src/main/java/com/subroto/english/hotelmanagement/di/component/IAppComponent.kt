package com.subroto.english.hotelmanagement.di.component

import android.app.Application
import com.subroto.english.hotelmanagement.EFHMApp
import com.subroto.english.hotelmanagement.di.builder.ActivityBuilder
import com.subroto.english.hotelmanagement.di.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidInjectionModule::class, AppModule::class, ActivityBuilder::class])
interface IAppComponent : AndroidInjector<EFHMApp> {

    override fun inject(app: EFHMApp)

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): IAppComponent
    }

}