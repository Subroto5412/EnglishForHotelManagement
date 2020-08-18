package com.subroto.english.hotelmanagement.ui.main.sentence

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SentenceActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(SentenceViewModel::class)
    abstract fun bindSentenceViewModel(viewModel: SentenceViewModel): ViewModel
}
