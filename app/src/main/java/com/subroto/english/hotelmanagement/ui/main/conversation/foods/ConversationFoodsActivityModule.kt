package com.subroto.english.hotelmanagement.ui.main.conversation.foods

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.di.ViewModelKey
import com.subroto.english.hotelmanagement.ui.main.conversation.foods.ConversationFoodsActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.foods.ConversationFoodsAdapter
import com.subroto.english.hotelmanagement.ui.main.conversation.foods.ConversationFoodsViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.util.ArrayList

@Module
abstract class ConversationFoodsActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(ConversationFoodsViewModel::class)
    abstract fun provideConversationFoodsViewModel(viewModel: ConversationFoodsViewModel): ViewModel
}

@Module
class ConversationFoodsAdapterModule {
    @Provides
    fun provideConversationFoodsViewModel( dataManager: IDataManager): ConversationFoodsViewModel {
        return ConversationFoodsViewModel(dataManager)
    }

    @Provides
    fun provideConversationFoodsAdapter(activity: ConversationFoodsActivity): ConversationFoodsAdapter {
        return ConversationFoodsAdapter(activity, ArrayList())
    }
}
