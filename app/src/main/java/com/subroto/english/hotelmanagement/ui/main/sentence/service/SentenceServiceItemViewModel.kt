package com.subroto.english.hotelmanagement.ui.main.sentence.service

import androidx.databinding.ObservableField
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import javax.inject.Inject

class SentenceServiceItemViewModel @Inject constructor(Service : GeetingCoreData, position: Int, listener : SentenceServiceItemViewModelListener){

    val mService: GeetingCoreData
    val mListener: SentenceServiceItemViewModelListener
    val id : ObservableField<Int>
    val english: ObservableField<String>
    val bangla : ObservableField<String>

    interface SentenceServiceItemViewModelListener {

    }
    init {
        mService = Service
        mListener = listener
        id = ObservableField(mService.id)
        english = ObservableField(mService.english)
        bangla = ObservableField(mService.bangla)
    }
}