package com.subroto.english.hotelmanagement.ui.main.quiz.level02

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class QuizLevelTwoActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(QuizLevelTwoViewModel::class)
    abstract fun bindQuizLevelTwoViewModel(viewModel: QuizLevelTwoViewModel) : ViewModel
}