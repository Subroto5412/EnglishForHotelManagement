package com.subroto.english.hotelmanagement.ui.main.conversation.foods

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.MutableLiveData
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.ui.base.BaseViewModel
import com.subroto.english.hotelmanagement.ui.main.conversation.foods.IConversationFoodsNavigator
import java.util.ArrayList
import javax.inject.Inject

class ConversationFoodsViewModel @Inject constructor(
    dataManager: IDataManager
): BaseViewModel<IConversationFoodsNavigator>(dataManager){

    var foodsObservableArrayList : ObservableList<GeetingCoreData> = ObservableArrayList()
    private var foodsListLiveData : MutableLiveData<List<GeetingCoreData>> = MutableLiveData()
    fun fetchFoods()
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
        foodsListLiveData.value = selectModel
    }

    fun getFoodsListLiveData() : MutableLiveData<List<GeetingCoreData>> {
        return foodsListLiveData
    }
    fun addFoodsItemToList(foods : List<GeetingCoreData>) {
        foodsObservableArrayList.clear()
        foodsObservableArrayList.addAll(foods)
    }


}