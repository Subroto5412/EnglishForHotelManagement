package com.subroto.english.hotelmanagement.ui.main.quiz.level01

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.di.ViewModelKey
import com.subroto.english.hotelmanagement.ui.main.quiz.QuizViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class QuizLevelOneActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(QuizLevelOneViewModel::class)
    abstract fun bindQuizLevelOneViewModel(viewModel: QuizLevelOneViewModel) : ViewModel
}