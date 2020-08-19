package com.subroto.english.hotelmanagement.ui.main.vocabulary.geeting

import androidx.databinding.InverseBindingListener
import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableField
import androidx.databinding.ObservableList
import androidx.lifecycle.MutableLiveData
import com.subroto.english.hotelmanagement.data.IDataManager
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.ui.base.BaseViewModel
import java.text.ParsePosition
import javax.inject.Inject

class GeetingItemViewModel @Inject constructor(geeting: GeetingCoreData, position: Int, listener: GeetingItemViewModelListener)
{
    private val mGeeting: GeetingCoreData
    val mListener: GeetingItemViewModelListener
   val id: ObservableField<Int>
   val english: ObservableField<String>
   val bangla: ObservableField<String>

    interface GeetingItemViewModelListener {
    }

    init {
        mGeeting = geeting
        mListener = listener
        id = ObservableField(mGeeting.id)
        english = ObservableField(mGeeting.english)
        bangla = ObservableField(mGeeting.bangla)
    }
}