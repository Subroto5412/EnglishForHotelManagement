package com.subroto.english.hotelmanagement.ui.main.sentence.geetings

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.di.ViewModelKey
import com.subroto.english.hotelmanagement.ui.main.sentence.geetings.SentenceGeetingsActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.geetings.SentenceGeetingsAdapter
import com.subroto.english.hotelmanagement.ui.main.sentence.geetings.SentenceGeetingsViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.util.ArrayList

@Module
abstract class SentenceGeetingsActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(SentenceGeetingsViewModel::class)
    abstract fun provideSentenceGeetingsViewModel(viewModel: SentenceGeetingsViewModel): ViewModel
}

@Module
class SentenceGeetingsAdapterModule {
    @Provides
    fun provideSentenceGeetingsViewModel( dataManager: IDataManager): SentenceGeetingsViewModel {
        return SentenceGeetingsViewModel(dataManager)
    }

    @Provides
    fun provideSentenceGeetingsAdapter(activity: SentenceGeetingsActivity): SentenceGeetingsAdapter {
        return SentenceGeetingsAdapter(activity, ArrayList())
    }
}