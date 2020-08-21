package com.subroto.english.hotelmanagement.ui.main.conversation.geetings

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.MutableLiveData
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.ui.base.BaseViewModel
import com.subroto.english.hotelmanagement.ui.main.conversation.geetings.IConversationGeetingsNavigator
import java.util.ArrayList
import javax.inject.Inject

class ConversationGeetingsViewModel @Inject constructor(
    dataManager: IDataManager
): BaseViewModel<IConversationGeetingsNavigator>(dataManager){

    var GeetingsObservableArrayList : ObservableList<GeetingCoreData> = ObservableArrayList()
    private var GeetingsListLiveData : MutableLiveData<List<GeetingCoreData>> = MutableLiveData()
    fun fetchGeetings()
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
        GeetingsListLiveData.value = selectModel
    }

    fun getGeetingsListLiveData() : MutableLiveData<List<GeetingCoreData>> {
        return GeetingsListLiveData
    }
    fun addGeetingsItemToList(Geetings : List<GeetingCoreData>) {
        GeetingsObservableArrayList.clear()
        GeetingsObservableArrayList.addAll(Geetings)
    }


}