package com.subroto.english.hotelmanagement.ui.main.vocabulary.geeting

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.databinding.GeetingRowBinding
import com.subroto.english.hotelmanagement.ui.base.BaseViewHolder
import javax.inject.Inject

class GeetingAdapter @Inject constructor(private val context: Context, val mGeetingCoreDataList: ArrayList<GeetingCoreData>) :
    RecyclerView.Adapter<BaseViewHolder>() {

    lateinit var mListener: GeetingAdapterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        val binding: GeetingRowBinding =
            GeetingRowBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return GeetingViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mGeetingCoreDataList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun addItems(geetingCoreData: List<GeetingCoreData>)
    {
        mGeetingCoreDataList.addAll(geetingCoreData)
        notifyDataSetChanged()
    }

    fun clearItems()
    {
        mGeetingCoreDataList.clear()
    }

    fun setListener(listener: GeetingAdapterListener) {
        mListener = listener
    }

    interface GeetingAdapterListener {
    }

    inner class GeetingViewHolder(binding: GeetingRowBinding) : BaseViewHolder(binding.root),GeetingItemViewModel.GeetingItemViewModelListener
    {
        val mBinding : GeetingRowBinding = binding
        private  var mGeetingItemViewModel : GeetingItemViewModel?=null
        override fun onBind(position: Int) {
          val geeting : GeetingCoreData = mGeetingCoreDataList[position]
            mGeetingItemViewModel = GeetingItemViewModel(geeting, position, this)
            mBinding.viewModel = mGeetingItemViewModel
            mBinding.executePendingBindings()
        }

    }

}