package com.subroto.english.hotelmanagement.ui.main.quiz.quiz_progress

import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.ui.base.BaseViewModel
import javax.inject.Inject

class ProgressResultViewModel @Inject constructor(dataManager: IDataManager) :
    BaseViewModel<IProgressResultNavigator>(dataManager) {
}