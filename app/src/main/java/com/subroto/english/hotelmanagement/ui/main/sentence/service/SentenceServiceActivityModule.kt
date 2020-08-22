package com.subroto.english.hotelmanagement.ui.main.sentence.service

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.di.ViewModelKey
import com.subroto.english.hotelmanagement.ui.main.sentence.service.SentenceServiceActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.service.SentenceServiceAdapter
import com.subroto.english.hotelmanagement.ui.main.sentence.service.SentenceServiceViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.util.ArrayList

@Module
abstract class SentenceServiceActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(SentenceServiceViewModel::class)
    abstract fun provideSentenceServiceViewModel(viewModel: SentenceServiceViewModel): ViewModel
}

@Module
class SentenceServiceAdapterModule {
    @Provides
    fun provideSentenceServiceViewModel( dataManager: IDataManager): SentenceServiceViewModel {
        return SentenceServiceViewModel(dataManager)
    }

    @Provides
    fun provideSentenceServiceAdapter(activity: SentenceServiceActivity): SentenceServiceAdapter {
        return SentenceServiceAdapter(activity, ArrayList())
    }
}
