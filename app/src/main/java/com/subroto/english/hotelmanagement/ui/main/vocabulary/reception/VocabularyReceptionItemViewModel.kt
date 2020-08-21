package com.subroto.english.hotelmanagement.ui.main.vocabulary.reception

import androidx.databinding.ObservableField
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import javax.inject.Inject

class VocabularyReceptionItemViewModel @Inject constructor(Reception : GeetingCoreData, position: Int, listener : VocabularyReceptionItemViewModelListener){

    val mReception: GeetingCoreData
    val mListener: VocabularyReceptionItemViewModelListener
    val id : ObservableField<Int>
    val english: ObservableField<String>
    val bangla : ObservableField<String>

    interface VocabularyReceptionItemViewModelListener {

    }
    init {
        mReception = Reception
        mListener = listener
        id = ObservableField(mReception.id)
        english = ObservableField(mReception.english)
        bangla = ObservableField(mReception.bangla)
    }
}