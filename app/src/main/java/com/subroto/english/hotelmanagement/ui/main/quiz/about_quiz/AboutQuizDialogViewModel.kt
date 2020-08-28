package com.subroto.english.hotelmanagement.ui.main.quiz.about_quiz

import com.subroto.english.hotelmanagement.data.AppDataManager
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.ui.base.BaseViewModel
import javax.inject.Inject

class AboutQuizDialogViewModel @Inject constructor(dataManager: IDataManager) : BaseViewModel<IAboutQuizCallback>(dataManager) {
}