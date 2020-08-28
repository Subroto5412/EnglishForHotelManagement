package com.subroto.english.hotelmanagement.ui.main.home

import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.ui.base.BaseViewModel
import javax.inject.Inject

class HomeViewModel  @Inject constructor(dataManager: IDataManager) : BaseViewModel<IHomeNavigator>(dataManager){

    fun startVocabulary() {
        navigator!!.openVocabularyActivity()
    }

    fun startSentence() {
        navigator!!.openSentenceActivity()
    }

    fun startConversation() {
        navigator!!.openConversationActivity()
    }

    fun startQuiz()
    {
        navigator!!.openQuizActivity()
    }
}