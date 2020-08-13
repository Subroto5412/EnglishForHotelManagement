package com.subroto.english.hotelmanagement.di.module

import androidx.lifecycle.ViewModelProvider
import com.subroto.english.hotelmanagement.di.factory.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelProviderFactory): ViewModelProvider.Factory

}