package com.subroto.english.hotelmanagement.ui.main.vocabulary.reception

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.util.ArrayList

@Module
abstract class VocabularyReceptionActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(VocabularyReceptionViewModel::class)
    abstract fun provideVocabularyReceptionViewModel(viewModel: VocabularyReceptionViewModel): ViewModel
}

@Module
class VocabularyReceptionAdapterModule {
    @Provides
    fun provideVocabularyReceptionViewModel( dataManager: IDataManager): VocabularyReceptionViewModel {
        return VocabularyReceptionViewModel(dataManager)
    }

    @Provides
    fun provideVocabularyReceptionAdapter(activity: VocabularyReceptionActivity): VocabularyReceptionAdapter {
        return VocabularyReceptionAdapter(activity, ArrayList())
    }
}
