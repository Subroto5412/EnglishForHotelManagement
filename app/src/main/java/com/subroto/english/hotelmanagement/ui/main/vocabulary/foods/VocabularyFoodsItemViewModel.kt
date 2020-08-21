package com.subroto.english.hotelmanagement.ui.main.vocabulary.foods

import androidx.databinding.ObservableField
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import java.text.ParsePosition
import javax.inject.Inject

class VocabularyFoodsItemViewModel @Inject constructor(foods : GeetingCoreData, position: Int, listener : VocabularyFoodsItemViewModelListener){

    val mFoods: GeetingCoreData
    val mListener: VocabularyFoodsItemViewModelListener
    val id : ObservableField<Int>
    val english: ObservableField<String>
    val bangla : ObservableField<String>

    interface VocabularyFoodsItemViewModelListener {

    }
    init {
        mFoods = foods
        mListener = listener
        id = ObservableField(mFoods.id)
        english = ObservableField(mFoods.english)
        bangla = ObservableField(mFoods.bangla)
    }
}