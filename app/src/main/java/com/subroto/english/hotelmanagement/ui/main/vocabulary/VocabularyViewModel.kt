package com.subroto.english.hotelmanagement.ui.main.vocabulary

import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.ui.base.BaseViewModel
import com.subroto.english.hotelmanagement.ui.main.home.IHomeNavigator
import javax.inject.Inject


class VocabularyViewModel  @Inject constructor(dataManager: IDataManager) : BaseViewModel<IVocabularyNavigator>(dataManager){

    fun startGeetings() {
        navigator!!.openGeetingsActivity()
    }

    fun startFoods() {
        navigator!!.openFoodsActivity()
    }
    fun startService() {
        navigator!!.openFoodsActivity()
    }
    fun startReception() {
        navigator!!.openReceptionActivity()
    }
    fun startKitchen() {
        navigator!!.openKitchenActivity()
    }
}