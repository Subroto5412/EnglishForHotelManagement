package com.subroto.english.hotelmanagement.ui.main.vocabulary.geeting

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.MutableLiveData
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.ui.base.BaseViewModel
import javax.inject.Inject
import java.util.*

class GeetingViewModel @Inject constructor(
    dataManager: IDataManager
) : BaseViewModel<IGeetingNavigator>(dataManager)
{
    var  geetingObservableArrayList : ObservableList<GeetingCoreData> = ObservableArrayList()
    private var geetingListLiveData : MutableLiveData<List<GeetingCoreData>> = MutableLiveData()

    fun fetchGeetingData()
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


        var data5 = GeetingCoreData(1, "Good Morning","সুপ্রভাত")
        selectModel.add(data5)

        var data6 = GeetingCoreData(2, "Congratulation","অভিনঁদন")
        selectModel.add(data6)

        var data7 = GeetingCoreData(1, "Good Morning","সুপ্রভাত")
        selectModel.add(data7)

        var data8 = GeetingCoreData(2, "Congratulation","অভিনঁদন")
        selectModel.add(data8)


        var data9 = GeetingCoreData(1, "Good Morning","সুপ্রভাত")
        selectModel.add(data9)

        var data10 = GeetingCoreData(2, "Congratulation","অভিনঁদন")
        selectModel.add(data10)

        geetingListLiveData.value = selectModel
    }

    fun getGeetingListLiveData() : MutableLiveData<List<GeetingCoreData>>
    {
        return geetingListLiveData
    }

    fun addGeetingItemToList(geeting : List<GeetingCoreData>)
    {
        geetingObservableArrayList.clear()
        geetingObservableArrayList.addAll(geeting)
    }
}