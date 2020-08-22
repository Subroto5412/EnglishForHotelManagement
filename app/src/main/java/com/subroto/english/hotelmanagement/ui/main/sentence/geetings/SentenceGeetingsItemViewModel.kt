package com.subroto.english.hotelmanagement.ui.main.sentence.geetings

import androidx.databinding.ObservableField
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import javax.inject.Inject

class SentenceGeetingsItemViewModel @Inject constructor(Geetings : GeetingCoreData, position: Int, listener : SentenceGeetingsItemViewModelListener){

    val mGeetings: GeetingCoreData
    val mListener: SentenceGeetingsItemViewModelListener
    val id : ObservableField<Int>
    val english: ObservableField<String>
    val bangla : ObservableField<String>

    interface SentenceGeetingsItemViewModelListener {

    }
    init {
        mGeetings = Geetings
        mListener = listener
        id = ObservableField(mGeetings.id)
        english = ObservableField(mGeetings.english)
        bangla = ObservableField(mGeetings.bangla)
    }
}