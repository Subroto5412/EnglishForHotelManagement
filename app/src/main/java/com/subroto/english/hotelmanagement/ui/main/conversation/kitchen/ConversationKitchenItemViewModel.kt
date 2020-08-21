package com.subroto.english.hotelmanagement.ui.main.conversation.kitchen

import androidx.databinding.ObservableField
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import javax.inject.Inject

class ConversationKitchenItemViewModel @Inject constructor(Kitchen : GeetingCoreData, position: Int, listener : ConversationKitchenItemViewModelListener){

    val mKitchen: GeetingCoreData
    val mListener: ConversationKitchenItemViewModelListener
    val id : ObservableField<Int>
    val english: ObservableField<String>
    val bangla : ObservableField<String>

    interface ConversationKitchenItemViewModelListener {

    }
    init {
        mKitchen = Kitchen
        mListener = listener
        id = ObservableField(mKitchen.id)
        english = ObservableField(mKitchen.english)
        bangla = ObservableField(mKitchen.bangla)
    }
}