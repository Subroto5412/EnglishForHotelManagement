package com.subroto.english.hotelmanagement.ui.main.conversation.service

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.di.ViewModelKey
import com.subroto.english.hotelmanagement.ui.main.conversation.service.ConversationServiceActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.service.ConversationServiceAdapter
import com.subroto.english.hotelmanagement.ui.main.conversation.service.ConversationServiceViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.util.ArrayList

@Module
abstract class ConversationServiceActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(ConversationServiceViewModel::class)
    abstract fun provideConversationServiceViewModel(viewModel: ConversationServiceViewModel): ViewModel
}

@Module
class ConversationServiceAdapterModule {
    @Provides
    fun provideConversationServiceViewModel( dataManager: IDataManager): ConversationServiceViewModel {
        return ConversationServiceViewModel(dataManager)
    }

    @Provides
    fun provideConversationServiceAdapter(activity: ConversationServiceActivity): ConversationServiceAdapter {
        return ConversationServiceAdapter(activity, ArrayList())
    }
}
