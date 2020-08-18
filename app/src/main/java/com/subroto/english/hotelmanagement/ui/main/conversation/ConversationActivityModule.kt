package com.subroto.english.hotelmanagement.ui.main.conversation

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.di.ViewModelKey
import com.subroto.english.hotelmanagement.ui.main.sentence.SentenceViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ConversationActivityModule {

    @Binds
    @IntoMap
    @ViewModelKey(ConversationViewModel::class)
    abstract fun bindConversationViewModel(viewModel: ConversationViewModel): ViewModel
}