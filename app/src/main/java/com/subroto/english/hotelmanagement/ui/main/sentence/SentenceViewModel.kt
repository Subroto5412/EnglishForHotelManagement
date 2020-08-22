package com.subroto.english.hotelmanagement.ui.main.sentence

import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.ui.base.BaseViewModel
import com.subroto.english.hotelmanagement.ui.main.vocabulary.IVocabularyNavigator
import javax.inject.Inject

class SentenceViewModel  @Inject constructor(dataManager: IDataManager) : BaseViewModel<ISentenceNavigator>(dataManager){

    fun startGeetings() {
        navigator!!.openGeetingsActivity()
    }

    fun startFoods() {
        navigator!!.openFoodsActivity()
    }
    fun startService() {
        navigator!!.openServiceActivity()
    }
    fun startReception() {
        navigator!!.openReceptionActivity()
    }
    fun startKitchen() {
        navigator!!.openKitchenActivity()
    }
}