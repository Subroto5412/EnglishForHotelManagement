package com.subroto.english.hotelmanagement.ui.main.vocabulary.foods

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.di.ViewModelKey
import com.subroto.english.hotelmanagement.ui.main.vocabulary.geeting.GeetingViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.util.ArrayList

@Module
abstract class VocabularyFoodsActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(VocabularyFoodsViewModel::class)
    abstract fun provideVocabularyFoodsViewModel(viewModel: VocabularyFoodsViewModel): ViewModel
}

@Module
class VocabularyFoodsAdapterModule {
    @Provides
    fun provideVocabularyFoodsViewModel( dataManager: IDataManager): VocabularyFoodsViewModel {
        return VocabularyFoodsViewModel(dataManager)
    }

    @Provides
    fun provideVocabularyFoodsAdapter(activity: VocabularyFoodsActivity):VocabularyFoodsAdapter {
        return VocabularyFoodsAdapter(activity, ArrayList())
    }
}
