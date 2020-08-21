package com.subroto.english.hotelmanagement.ui.main.vocabulary.kitchen

import androidx.databinding.ObservableField
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import javax.inject.Inject

class VocabularyKitchenItemViewModel @Inject constructor(Kitchen : GeetingCoreData, position: Int, listener : VocabularyKitchenItemViewModelListener){

    val mKitchen: GeetingCoreData
    val mListener: VocabularyKitchenItemViewModelListener
    val id : ObservableField<Int>
    val english: ObservableField<String>
    val bangla : ObservableField<String>

    interface VocabularyKitchenItemViewModelListener {

    }
    init {
        mKitchen = Kitchen
        mListener = listener
        id = ObservableField(mKitchen.id)
        english = ObservableField(mKitchen.english)
        bangla = ObservableField(mKitchen.bangla)
    }
}