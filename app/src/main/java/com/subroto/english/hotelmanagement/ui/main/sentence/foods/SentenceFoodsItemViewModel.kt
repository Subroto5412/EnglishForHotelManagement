package com.subroto.english.hotelmanagement.ui.main.sentence.foods

import androidx.databinding.ObservableField
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import javax.inject.Inject

class SentenceFoodsItemViewModel @Inject constructor(foods : GeetingCoreData, position: Int, listener : SentenceFoodsItemViewModelListener){

    val mFoods: GeetingCoreData
    val mListener: SentenceFoodsItemViewModelListener
    val id : ObservableField<Int>
    val english: ObservableField<String>
    val bangla : ObservableField<String>

    interface SentenceFoodsItemViewModelListener {

    }
    init {
        mFoods = foods
        mListener = listener
        id = ObservableField(mFoods.id)
        english = ObservableField(mFoods.english)
        bangla = ObservableField(mFoods.bangla)
    }
}