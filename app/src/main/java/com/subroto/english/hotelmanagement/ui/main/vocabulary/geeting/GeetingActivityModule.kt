package com.subroto.english.hotelmanagement.ui.main.vocabulary.geeting

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.util.ArrayList

@Module
abstract class GeetingActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(GeetingViewModel::class)
    abstract fun provideGeetingViewModel(viewModel: GeetingViewModel): ViewModel
}

@Module
class GeetingAdapterModule {
    @Provides
    fun provideGeetingViewModel(
        dataManager: IDataManager
    ): GeetingViewModel {
        return GeetingViewModel(dataManager)
    }

    @Provides
    fun provideGeetingAdapter(activity:GeetingActivity): GeetingAdapter {
        return GeetingAdapter(activity, ArrayList())
    }
}