package com.subroto.english.hotelmanagement.ui.main.conversation.service

import androidx.databinding.ObservableField
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import javax.inject.Inject

class ConversationServiceItemViewModel @Inject constructor(Service : GeetingCoreData, position: Int, listener : ConversationServiceItemViewModelListener){

    val mService: GeetingCoreData
    val mListener: ConversationServiceItemViewModelListener
    val id : ObservableField<Int>
    val english: ObservableField<String>
    val bangla : ObservableField<String>

    interface ConversationServiceItemViewModelListener {

    }
    init {
        mService = Service
        mListener = listener
        id = ObservableField(mService.id)
        english = ObservableField(mService.english)
        bangla = ObservableField(mService.bangla)
    }
}