package com.subroto.english.hotelmanagement.ui.main.vocabulary.reception

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.MutableLiveData
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.ui.base.BaseViewModel
import com.subroto.english.hotelmanagement.ui.main.vocabulary.reception.IVocabularyReceptionNavigator
import java.util.ArrayList
import javax.inject.Inject

class VocabularyReceptionViewModel @Inject constructor(
    dataManager: IDataManager
): BaseViewModel<IVocabularyReceptionNavigator>(dataManager){

    var ReceptionObservableArrayList : ObservableList<GeetingCoreData> = ObservableArrayList()
    private var ReceptionListLiveData : MutableLiveData<List<GeetingCoreData>> = MutableLiveData()
    fun fetchReception()
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
        ReceptionListLiveData.value = selectModel
    }

    fun getReceptionListLiveData() : MutableLiveData<List<GeetingCoreData>> {
        return ReceptionListLiveData
    }
    fun addReceptionItemToList(Reception : List<GeetingCoreData>) {
        ReceptionObservableArrayList.clear()
        ReceptionObservableArrayList.addAll(Reception)
    }
}