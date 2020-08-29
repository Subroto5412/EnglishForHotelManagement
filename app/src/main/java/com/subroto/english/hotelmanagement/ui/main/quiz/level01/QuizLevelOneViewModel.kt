package com.subroto.english.hotelmanagement.ui.main.quiz.level01

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.MutableLiveData
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.data.domainModel.QuizCordData
import com.subroto.english.hotelmanagement.ui.base.BaseViewModel
import com.subroto.english.hotelmanagement.ui.main.quiz.IQuizNavigator
import java.util.ArrayList
import javax.inject.Inject

class QuizLevelOneViewModel @Inject constructor(dataManager: IDataManager) : BaseViewModel<IQuizLevelOneNavigator>(dataManager){

    var QuizLevelOneObservableArrayList : ObservableList<QuizCordData> = ObservableArrayList()
    private var QuizLevelOneListLiveData : MutableLiveData<List<QuizCordData>> = MutableLiveData()


    fun fetchQuizLevelOne()
    {
        val selectModel = ArrayList<QuizCordData>()

        var data1 = QuizCordData(1, "","Why do you want to work at this hotel? Do you have any experience working in a hotel in Bangladesh?","Yest I have","No I didn’t","A little bit","For 1 year","1")
        selectModel.add(data1)

        var data2 = QuizCordData(2, "","Why do you want to work at this hotel? Do you have any experience working in a hotel in Bangladesh?22222","Yest I have","No I didn’t","A little bit","For 1 year","3")
        selectModel.add(data2)

        var data3 = QuizCordData(3, "","Why do you want to work at this hotel? Do you have any experience working in a hotel in Bangladesh?3333","Yest I have","No I didn’t","A little bit","For 1 year","2")
        selectModel.add(data3)

        var data4 = QuizCordData(4, "","Why do you want to work at this hotel? Do you have any experience working in a hotel in Bangladesh?44444","Yest I have","No I didn’t","A little bit","For 1 year","4")
        selectModel.add(data4)

        var data5 = QuizCordData(5, "","Why do you want to work at this hotel? Do you have any experience working in a hotel in Bangladesh?5555","Yest I have","No I didn’t","A little bit","For 1 year","1")
        selectModel.add(data5)

        var data6 = QuizCordData(6, "","Why do you want to work at this hotel? Do you have any experience working in a hotel in Bangladesh?666","Yest I have","No I didn’t","A little bit","For 1 year","3")
        selectModel.add(data6)
        QuizLevelOneListLiveData.value = selectModel
    }

    fun getQuizLevelOneListLiveData() : MutableLiveData<List<QuizCordData>> {
        return QuizLevelOneListLiveData
    }
    fun addQuizLevelOneItemToList(QuizLevelOne : List<QuizCordData>) {
        QuizLevelOneObservableArrayList.clear()
        QuizLevelOneObservableArrayList.addAll(QuizLevelOne)
    }
}