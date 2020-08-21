package com.subroto.english.hotelmanagement.ui.main.vocabulary.kitchen

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.MutableLiveData
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.ui.base.BaseViewModel
import com.subroto.english.hotelmanagement.ui.main.vocabulary.kitchen.IVocabularyKitchenNavigator
import java.util.ArrayList
import javax.inject.Inject

class VocabularyKitchenViewModel @Inject constructor(
    dataManager: IDataManager
): BaseViewModel<IVocabularyKitchenNavigator>(dataManager){

    var KitchenObservableArrayList : ObservableList<GeetingCoreData> = ObservableArrayList()
    private var KitchenListLiveData : MutableLiveData<List<GeetingCoreData>> = MutableLiveData()
    fun fetchKitchen()
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
        KitchenListLiveData.value = selectModel
    }

    fun getKitchenListLiveData() : MutableLiveData<List<GeetingCoreData>> {
        return KitchenListLiveData
    }
    fun addKitchenItemToList(Kitchen : List<GeetingCoreData>) {
        KitchenObservableArrayList.clear()
        KitchenObservableArrayList.addAll(Kitchen)
    }
}