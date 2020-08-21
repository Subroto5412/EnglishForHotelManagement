package com.subroto.english.hotelmanagement.ui.main.conversation

import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.ui.base.BaseViewModel
import com.subroto.english.hotelmanagement.ui.main.sentence.ISentenceNavigator
import javax.inject.Inject

class ConversationViewModel  @Inject constructor(dataManager: IDataManager) : BaseViewModel<IConversationNavigator>(dataManager){

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