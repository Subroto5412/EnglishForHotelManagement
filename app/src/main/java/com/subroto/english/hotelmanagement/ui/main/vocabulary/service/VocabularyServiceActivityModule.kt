package com.subroto.english.hotelmanagement.ui.main.vocabulary.service

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.di.ViewModelKey

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.util.ArrayList

@Module
abstract class VocabularyServiceActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(VocabularyServiceViewModel::class)
    abstract fun provideVocabularyServiceViewModel(viewModel: VocabularyServiceViewModel): ViewModel
}

@Module
class VocabularyServiceAdapterModule {
    @Provides
    fun provideVocabularyServiceViewModel( dataManager: IDataManager): VocabularyServiceViewModel {
        return VocabularyServiceViewModel(dataManager)
    }

    @Provides
    fun provideVocabularyServiceAdapter(activity: VocabularyServiceActivity): VocabularyServiceAdapter {
        return VocabularyServiceAdapter(activity, ArrayList())
    }
}
