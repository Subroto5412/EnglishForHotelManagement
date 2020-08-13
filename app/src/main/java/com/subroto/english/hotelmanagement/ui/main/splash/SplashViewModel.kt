package com.subroto.english.hotelmanagement.ui.main.splash

import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.ui.base.BaseViewModel
import javax.inject.Inject

class SplashViewModel @Inject constructor(dataManager: IDataManager) : BaseViewModel<ISplashNavigator>(dataManager){

    fun startSeeding() {
        decideNextActivity()
    }

    private fun decideNextActivity() {
        navigator!!.openMainActivity()
    }
}