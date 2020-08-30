package com.subroto.english.hotelmanagement.ui.main.quiz.level02

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.MutableLiveData
import com.subroto.english.hotelmanagement.R
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.data.domainModel.QuizCordData
import com.subroto.english.hotelmanagement.ui.base.BaseViewModel
import java.util.ArrayList
import javax.inject.Inject

class QuizLevelTwoViewModel @Inject constructor(dataManager: IDataManager) :
    BaseViewModel<IQuizLevelTwoNavigator>(dataManager) {

    var QuizLevelTwoObservableArrayList: ObservableList<QuizCordData> = ObservableArrayList()
    private var QuizLevelTwoListLiveData: MutableLiveData<List<QuizCordData>> = MutableLiveData()


    fun fetchQuizLevelTwo() {
        val selectModel = ArrayList<QuizCordData>()

        var data1 = QuizCordData(
            1,
            R.drawable.slider_pic2,
            "Why do you want to work at this hotel? ",
            "Yest I have",
            "No I didn’t",
            "A little bit",
            "For 1 year",
            "1"
        )
        selectModel.add(data1)

        var data2 = QuizCordData(
            2,
            R.drawable.slider_pic3,
            "Why do you want to work at this hotel?22222",
            "Yest I have",
            "No I didn’t",
            "A little bit",
            "For 1 year",
            "3"
        )
        selectModel.add(data2)

        var data3 = QuizCordData(
            3,
            R.drawable.slider_pic1,
            "Why do you want to work at this hotel?3333",
            "Yest I have",
            "No I didn’t",
            "A little bit",
            "For 1 year",
            "2"
        )
        selectModel.add(data3)

        var data4 = QuizCordData(
            4,
            R.drawable.slider_pic2,
            "Why do you want to work at this hotel?44444",
            "Yest I have",
            "No I didn’t",
            "A little bit",
            "For 1 year",
            "4"
        )
        selectModel.add(data4)

        var data5 = QuizCordData(
            5,
            R.drawable.slider_pic3,
            "Why do you want to work at this hotel?5555",
            "Yest I have",
            "No I didn’t",
            "A little bit",
            "For 1 year",
            "1"
        )
        selectModel.add(data5)

        var data6 = QuizCordData(
            6,
            R.drawable.slider_pic1,
            "Why do you want to work at this hotel?666",
            "Yest I have",
            "No I didn’t",
            "A little bit",
            "For 1 year",
            "3"
        )
        selectModel.add(data6)
        QuizLevelTwoListLiveData.value = selectModel
    }

    fun getQuizLevelTwoListLiveData(): MutableLiveData<List<QuizCordData>> {
        return QuizLevelTwoListLiveData
    }

    fun addQuizLevelTwoItemToList(QuizLevelTwo: List<QuizCordData>) {
        QuizLevelTwoObservableArrayList.clear()
        QuizLevelTwoObservableArrayList.addAll(QuizLevelTwo)
    }
}