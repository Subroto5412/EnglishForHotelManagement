package com.subroto.english.hotelmanagement.ui.main.conversation.foods

import androidx.databinding.ObservableField
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import javax.inject.Inject

class ConversationFoodsItemViewModel @Inject constructor(foods : GeetingCoreData, position: Int, listener : ConversationFoodsItemViewModelListener){

    val mFoods: GeetingCoreData
    val mListener: ConversationFoodsItemViewModelListener
    val id : ObservableField<Int>
    val english: ObservableField<String>
    val bangla : ObservableField<String>

    interface ConversationFoodsItemViewModelListener {

    }
    init {
        mFoods = foods
        mListener = listener
        id = ObservableField(mFoods.id)
        english = ObservableField(mFoods.english)
        bangla = ObservableField(mFoods.bangla)
    }
}