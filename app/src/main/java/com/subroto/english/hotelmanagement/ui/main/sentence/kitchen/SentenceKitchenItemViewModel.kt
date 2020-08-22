package com.subroto.english.hotelmanagement.ui.main.sentence.kitchen

import androidx.databinding.ObservableField
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import javax.inject.Inject

class SentenceKitchenItemViewModel @Inject constructor(Kitchen : GeetingCoreData, position: Int, listener : SentenceKitchenItemViewModelListener){

    val mKitchen: GeetingCoreData
    val mListener: SentenceKitchenItemViewModelListener
    val id : ObservableField<Int>
    val english: ObservableField<String>
    val bangla : ObservableField<String>

    interface SentenceKitchenItemViewModelListener {

    }
    init {
        mKitchen = Kitchen
        mListener = listener
        id = ObservableField(mKitchen.id)
        english = ObservableField(mKitchen.english)
        bangla = ObservableField(mKitchen.bangla)
    }
}