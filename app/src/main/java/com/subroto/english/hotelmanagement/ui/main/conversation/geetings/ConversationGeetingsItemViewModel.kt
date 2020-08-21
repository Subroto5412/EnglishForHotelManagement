package com.subroto.english.hotelmanagement.ui.main.conversation.geetings

import androidx.databinding.ObservableField
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import javax.inject.Inject

class ConversationGeetingsItemViewModel @Inject constructor(Geetings : GeetingCoreData, position: Int, listener : ConversationGeetingsItemViewModelListener){

    val mGeetings: GeetingCoreData
    val mListener: ConversationGeetingsItemViewModelListener
    val id : ObservableField<Int>
    val english: ObservableField<String>
    val bangla : ObservableField<String>

    interface ConversationGeetingsItemViewModelListener {

    }
    init {
        mGeetings = Geetings
        mListener = listener
        id = ObservableField(mGeetings.id)
        english = ObservableField(mGeetings.english)
        bangla = ObservableField(mGeetings.bangla)
    }
}