package com.subroto.english.hotelmanagement.ui.main.conversation.reception

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.di.ViewModelKey
import com.subroto.english.hotelmanagement.ui.main.conversation.reception.ConversationReceptionActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.reception.ConversationReceptionAdapter
import com.subroto.english.hotelmanagement.ui.main.conversation.reception.ConversationReceptionViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.util.ArrayList

@Module
abstract class ConversationReceptionActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(ConversationReceptionViewModel::class)
    abstract fun provideConversationReceptionViewModel(viewModel: ConversationReceptionViewModel): ViewModel
}

@Module
class ConversationReceptionAdapterModule {
    @Provides
    fun provideConversationReceptionViewModel( dataManager: IDataManager): ConversationReceptionViewModel {
        return ConversationReceptionViewModel(dataManager)
    }

    @Provides
    fun provideConversationReceptionAdapter(activity: ConversationReceptionActivity): ConversationReceptionAdapter {
        return ConversationReceptionAdapter(activity, ArrayList())
    }
}
