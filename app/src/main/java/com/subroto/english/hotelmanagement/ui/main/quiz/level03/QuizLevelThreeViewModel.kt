package com.subroto.english.hotelmanagement.ui.main.quiz.level03

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableList
import androidx.lifecycle.MutableLiveData
import com.subroto.english.hotelmanagement.R
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.data.domainModel.QuizCordDataLevelThree
import com.subroto.english.hotelmanagement.ui.base.BaseViewModel
import java.util.*
import javax.inject.Inject

class QuizLevelThreeViewModel @Inject constructor(dataManager: IDataManager) :
    BaseViewModel<IQuizLevelThreeNavigator>(dataManager) {

    var QuizLevelThreeObservableArrayList: ObservableList<QuizCordDataLevelThree> =
        ObservableArrayList()
    private var QuizLevelThreeListLiveData: MutableLiveData<List<QuizCordDataLevelThree>> =
        MutableLiveData()


    fun fetchQuizLevelThree() {
        val selectModel = ArrayList<QuizCordDataLevelThree>()

        var data1 = QuizCordDataLevelThree(
            1,
            "Why do you want to work at this hotel? ",
            R.drawable.slider_pic2,
            R.drawable.slider_pic1,
            R.drawable.slider_pic3,
            R.drawable.interview,
            "1"
        )
        selectModel.add(data1)

        var data2 = QuizCordDataLevelThree(
            2,
            "Why do you want to work at this hotel? ",
            R.drawable.slider_pic3,
            R.drawable.slider_pic1,
            R.drawable.slider_pic2,
            R.drawable.sentence,
            "2"
        )
        selectModel.add(data2)

        var data3 = QuizCordDataLevelThree(
            3,
            "Why do you want to work at this hotel? ",
            R.drawable.slider_pic1,
            R.drawable.slider_pic1,
            R.drawable.slider_pic3,
            R.drawable.interview,
            "3"
        )
        selectModel.add(data3)

        var data4 = QuizCordDataLevelThree(
            4,
            "Why do you want to work at this hotel? ",
            R.drawable.slider_pic3,
            R.drawable.slider_pic2,
            R.drawable.slider_pic1,
            R.drawable.vocabulary,
            "4"
        )
        selectModel.add(data4)

        var data5 = QuizCordDataLevelThree(
            5,
            "Why do you want to work at this hotel? ",
            R.drawable.slider_pic2,
            R.drawable.slider_pic1,
            R.drawable.slider_pic3,
            R.drawable.conversation,
            "1"
        )
        selectModel.add(data5)

        var data6 = QuizCordDataLevelThree(
            6,
            "Why do you want to work at this hotel? ",
            R.drawable.slider_pic1,
            R.drawable.slider_pic2,
            R.drawable.slider_pic3,
            R.drawable.interview,
            "3"
        )
        selectModel.add(data6)
        QuizLevelThreeListLiveData.value = selectModel
    }

    fun getQuizLevelThreeListLiveData(): MutableLiveData<List<QuizCordDataLevelThree>> {
        return QuizLevelThreeListLiveData
    }

    fun addQuizLevelThreeItemToList(QuizLevelThree: List<QuizCordDataLevelThree>) {
        QuizLevelThreeObservableArrayList.clear()
        QuizLevelThreeObservableArrayList.addAll(QuizLevelThree)
    }
}