package com.subroto.english.hotelmanagement.ui.main.sentence.reception

import androidx.lifecycle.ViewModel
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.di.ViewModelKey
import com.subroto.english.hotelmanagement.ui.main.sentence.reception.SentenceReceptionActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.reception.SentenceReceptionAdapter
import com.subroto.english.hotelmanagement.ui.main.sentence.reception.SentenceReceptionViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import java.util.ArrayList

@Module
abstract class SentenceReceptionActivityModule {
    @Binds
    @IntoMap
    @ViewModelKey(SentenceReceptionViewModel::class)
    abstract fun provideSentenceReceptionViewModel(viewModel: SentenceReceptionViewModel): ViewModel
}

@Module
class SentenceReceptionAdapterModule {
    @Provides
    fun provideSentenceReceptionViewModel( dataManager: IDataManager): SentenceReceptionViewModel {
        return SentenceReceptionViewModel(dataManager)
    }

    @Provides
    fun provideSentenceReceptionAdapter(activity: SentenceReceptionActivity): SentenceReceptionAdapter {
        return SentenceReceptionAdapter(activity, ArrayList())
    }
}