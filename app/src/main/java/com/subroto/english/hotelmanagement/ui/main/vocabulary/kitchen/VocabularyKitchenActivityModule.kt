package com.subroto.english.hotelmanagement.ui.main.vocabulary.kitchen

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.di.ViewModelKey
import com.subroto.english.hotelmanagement.ui.main.vocabulary.kitchen.VocabularyKitchenActivity
import com.subroto.english.hotelmanagement.ui.main.vocabulary.kitchen.VocabularyKitchenAdapter
import com.subroto.english.hotelmanagement.ui.main.vocabulary.kitchen.VocabularyKitchenViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.util.ArrayList

@Module
abstract class VocabularyKitchenActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(VocabularyKitchenViewModel::class)
    abstract fun provideVocabularyKitchenViewModel(viewModel: VocabularyKitchenViewModel): ViewModel
}

@Module
class VocabularyKitchenAdapterModule {
    @Provides
    fun provideVocabularyKitchenViewModel( dataManager: IDataManager): VocabularyKitchenViewModel {
        return VocabularyKitchenViewModel(dataManager)
    }

    @Provides
    fun provideVocabularyKitchenAdapter(activity: VocabularyKitchenActivity): VocabularyKitchenAdapter {
        return VocabularyKitchenAdapter(activity, ArrayList())
    }
}
