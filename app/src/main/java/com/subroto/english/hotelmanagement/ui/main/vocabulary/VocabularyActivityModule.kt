package com.subroto.english.hotelmanagement.ui.main.vocabulary

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.di.ViewModelKey
import com.subroto.english.hotelmanagement.ui.main.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class VocabularyActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(VocabularyViewModel::class)
    abstract fun bindVocabularyViewModel(viewModel: VocabularyViewModel): ViewModel
}
