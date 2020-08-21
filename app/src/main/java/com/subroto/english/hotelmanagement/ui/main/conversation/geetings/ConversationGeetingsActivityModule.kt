package com.subroto.english.hotelmanagement.ui.main.conversation.geetings

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.di.ViewModelKey
import com.subroto.english.hotelmanagement.ui.main.conversation.geetings.ConversationGeetingsActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.geetings.ConversationGeetingsAdapter
import com.subroto.english.hotelmanagement.ui.main.conversation.geetings.ConversationGeetingsViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.util.ArrayList

@Module
abstract class ConversationGeetingsActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(ConversationGeetingsViewModel::class)
    abstract fun provideConversationGeetingsViewModel(viewModel: ConversationGeetingsViewModel): ViewModel
}

@Module
class ConversationGeetingsAdapterModule {
    @Provides
    fun provideConversationGeetingsViewModel( dataManager: IDataManager): ConversationGeetingsViewModel {
        return ConversationGeetingsViewModel(dataManager)
    }

    @Provides
    fun provideConversationGeetingsAdapter(activity: ConversationGeetingsActivity): ConversationGeetingsAdapter {
        return ConversationGeetingsAdapter(activity, ArrayList())
    }
}