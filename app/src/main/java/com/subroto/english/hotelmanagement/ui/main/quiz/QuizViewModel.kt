package com.subroto.english.hotelmanagement.ui.main.quiz

import com.subroto.english.hotelmanagement.data.AppDataManager
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.ui.base.BaseViewModel
import javax.inject.Inject

class QuizViewModel @Inject constructor(dataManager: IDataManager) : BaseViewModel<IQuizNavigator>(dataManager){
    fun quizRules() {
        navigator!!.openQuizRules()
    }

    fun quizLevel01() {
        navigator!!.openQuizLevel01()
    }

    fun quizLevel02() {
        navigator!!.openQuizLevel02()
    }

    fun quizLevel03() {
        navigator!!.openQuizLevel03()
    }

    fun quizLevel04() {
        navigator!!.openQuizLevel04()
    }
}