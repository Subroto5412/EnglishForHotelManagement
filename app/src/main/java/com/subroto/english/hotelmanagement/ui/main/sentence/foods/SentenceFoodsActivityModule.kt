package com.subroto.english.hotelmanagement.ui.main.sentence.foods

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.di.ViewModelKey
import com.subroto.english.hotelmanagement.ui.main.sentence.foods.SentenceFoodsActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.foods.SentenceFoodsAdapter
import com.subroto.english.hotelmanagement.ui.main.sentence.foods.SentenceFoodsViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.util.ArrayList

@Module
abstract class SentenceFoodsActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(SentenceFoodsViewModel::class)
    abstract fun provideSentenceFoodsViewModel(viewModel: SentenceFoodsViewModel): ViewModel
}

@Module
class SentenceFoodsAdapterModule {
    @Provides
    fun provideSentenceFoodsViewModel( dataManager: IDataManager): SentenceFoodsViewModel {
        return SentenceFoodsViewModel(dataManager)
    }

    @Provides
    fun provideSentenceFoodsAdapter(activity: SentenceFoodsActivity): SentenceFoodsAdapter {
        return SentenceFoodsAdapter(activity, ArrayList())
    }
}
