package com.subroto.english.hotelmanagement.ui.main.quiz.quiz_progress

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ProgressResultActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(ProgressResultViewModel::class)
    abstract fun bindProgressResultViewModel(viewModel: ProgressResultViewModel): ViewModel
}