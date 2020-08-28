package com.subroto.english.hotelmanagement.ui.main.quiz.level01

import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.ui.base.BaseViewModel
import com.subroto.english.hotelmanagement.ui.main.quiz.IQuizNavigator
import javax.inject.Inject

class QuizLevelOneViewModel @Inject constructor(dataManager: IDataManager) : BaseViewModel<IQuizLevelOneNavigator>(dataManager){
}