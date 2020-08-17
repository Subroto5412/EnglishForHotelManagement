package com.subroto.english.hotelmanagement.ui.main.home

import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.ui.base.BaseViewModel
import javax.inject.Inject

class HomeViewModel  @Inject constructor(dataManager: IDataManager) : BaseViewModel<IHomeNavigator>(dataManager){

}