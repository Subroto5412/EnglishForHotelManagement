package com.subroto.english.hotelmanagement.ui.main.quiz.level03

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class QuizLevelThreeActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(QuizLevelThreeViewModel::class)
    abstract fun bindQuizLevelThreeViewModel(viewModel: QuizLevelThreeViewModel) : ViewModel
}