package com.subroto.english.hotelmanagement.ui.main.vocabulary.service

import androidx.databinding.ObservableField
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import javax.inject.Inject

class VocabularyServiceItemViewModel @Inject constructor(Service : GeetingCoreData, position: Int, listener : VocabularyServiceItemViewModelListener){

    val mService: GeetingCoreData
    val mListener: VocabularyServiceItemViewModelListener
    val id : ObservableField<Int>
    val english: ObservableField<String>
    val bangla : ObservableField<String>

    interface VocabularyServiceItemViewModelListener {

    }
    init {
        mService = Service
        mListener = listener
        id = ObservableField(mService.id)
        english = ObservableField(mService.english)
        bangla = ObservableField(mService.bangla)
    }
}