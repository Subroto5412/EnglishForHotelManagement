package com.subroto.english.hotelmanagement.ui.main.sentence.reception

import androidx.databinding.ObservableField
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import javax.inject.Inject

class SentenceReceptionItemViewModel @Inject constructor(Reception : GeetingCoreData, position: Int, listener : SentenceReceptionItemViewModelListener){

    val mReception: GeetingCoreData
    val mListener: SentenceReceptionItemViewModelListener
    val id : ObservableField<Int>
    val english: ObservableField<String>
    val bangla : ObservableField<String>

    interface SentenceReceptionItemViewModelListener {

    }
    init {
        mReception = Reception
        mListener = listener
        id = ObservableField(mReception.id)
        english = ObservableField(mReception.english)
        bangla = ObservableField(mReception.bangla)
    }
}