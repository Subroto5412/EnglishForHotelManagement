package com.subroto.english.hotelmanagement.ui.main.conversation.kitchen

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.di.ViewModelKey
import com.subroto.english.hotelmanagement.ui.main.conversation.kitchen.ConversationKitchenActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.kitchen.ConversationKitchenAdapter
import com.subroto.english.hotelmanagement.ui.main.conversation.kitchen.ConversationKitchenViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.util.ArrayList

@Module
abstract class ConversationKitchenActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(ConversationKitchenViewModel::class)
    abstract fun provideConversationKitchenViewModel(viewModel: ConversationKitchenViewModel): ViewModel
}

@Module
class ConversationKitchenAdapterModule {
    @Provides
    fun provideConversationKitchenViewModel( dataManager: IDataManager): ConversationKitchenViewModel {
        return ConversationKitchenViewModel(dataManager)
    }

    @Provides
    fun provideConversationKitchenAdapter(activity: ConversationKitchenActivity): ConversationKitchenAdapter {
        return ConversationKitchenAdapter(activity, ArrayList())
    }
}
