package com.subroto.english.hotelmanagement.ui.main.quiz.about_quiz

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.di.ViewModelKey
import dagger.Binds
import dagger.MapKey
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class AboutQuizDialogModule {
    @Binds
    @IntoMap
    @ViewModelKey(AboutQuizDialogViewModel::class)
    abstract fun bindAboutQuizDialogViewModel(viewModel: AboutQuizDialogViewModel) : ViewModel
}