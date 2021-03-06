package com.subroto.english.hotelmanagement.ui.main.sentence.service

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.MutableLiveData
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.ui.base.BaseViewModel
import com.subroto.english.hotelmanagement.ui.main.sentence.service.ISentenceServiceNavigator
import java.util.ArrayList
import javax.inject.Inject

class SentenceServiceViewModel @Inject constructor(
    dataManager: IDataManager
): BaseViewModel<ISentenceServiceNavigator>(dataManager){

    var ServiceObservableArrayList : ObservableList<GeetingCoreData> = ObservableArrayList()
    private var ServiceListLiveData : MutableLiveData<List<GeetingCoreData>> = MutableLiveData()
    fun fetchService()
    {
        val selectModel = ArrayList<GeetingCoreData>()

        var data1 = GeetingCoreData(1, "Good Morning","সুপ্রভাত")
        selectModel.add(data1)

        var data2 = GeetingCoreData(2, "Congratulation","অভিনঁদন")
        selectModel.add(data2)

        var data3 = GeetingCoreData(1, "Good Morning","সুপ্রভাত")
        selectModel.add(data3)

        var data4 = GeetingCoreData(2, "Congratulation","অভিনঁদন")
        selectModel.add(data4)
        ServiceListLiveData.value = selectModel
    }

    fun getServiceListLiveData() : MutableLiveData<List<GeetingCoreData>> {
        return ServiceListLiveData
    }
    fun addServiceItemToList(Service : List<GeetingCoreData>) {
        ServiceObservableArrayList.clear()
        ServiceObservableArrayList.addAll(Service)
    }
}