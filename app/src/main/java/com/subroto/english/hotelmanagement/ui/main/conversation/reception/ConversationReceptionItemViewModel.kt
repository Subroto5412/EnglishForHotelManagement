package com.subroto.english.hotelmanagement.ui.main.conversation.reception

import androidx.databinding.ObservableField
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import javax.inject.Inject

class ConversationReceptionItemViewModel @Inject constructor(Reception : GeetingCoreData, position: Int, listener : ConversationReceptionItemViewModelListener){

    val mReception: GeetingCoreData
    val mListener: ConversationReceptionItemViewModelListener
    val id : ObservableField<Int>
    val english: ObservableField<String>
    val bangla : ObservableField<String>

    interface ConversationReceptionItemViewModelListener {

    }
    init {
        mReception = Reception
        mListener = listener
        id = ObservableField(mReception.id)
        english = ObservableField(mReception.english)
        bangla = ObservableField(mReception.bangla)
    }
}