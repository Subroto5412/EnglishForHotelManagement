package com.subroto.english.hotelmanagement.ui.main.sentence.kitchen

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.di.ViewModelKey
import com.subroto.english.hotelmanagement.ui.main.sentence.kitchen.SentenceKitchenActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.kitchen.SentenceKitchenAdapter
import com.subroto.english.hotelmanagement.ui.main.sentence.kitchen.SentenceKitchenViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.util.ArrayList

@Module
abstract class SentenceKitchenActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(SentenceKitchenViewModel::class)
    abstract fun provideSentenceKitchenViewModel(viewModel: SentenceKitchenViewModel): ViewModel
}

@Module
class SentenceKitchenAdapterModule {
    @Provides
    fun provideSentenceKitchenViewModel( dataManager: IDataManager): SentenceKitchenViewModel {
        return SentenceKitchenViewModel(dataManager)
    }

    @Provides
    fun provideSentenceKitchenAdapter(activity: SentenceKitchenActivity): SentenceKitchenAdapter {
        return SentenceKitchenAdapter(activity, ArrayList())
    }
}
