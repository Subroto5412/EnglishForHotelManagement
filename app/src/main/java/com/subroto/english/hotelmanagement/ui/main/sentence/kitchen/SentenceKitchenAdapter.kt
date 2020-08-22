package com.subroto.english.hotelmanagement.ui.main.sentence.kitchen

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.databinding.SentenceKitchenRowBinding
import com.subroto.english.hotelmanagement.ui.base.BaseViewHolder
import com.subroto.english.hotelmanagement.ui.main.sentence.kitchen.SentenceKitchenItemViewModel
import javax.inject.Inject

class SentenceKitchenAdapter  @Inject constructor(private val context: Context, val mKitchenGeetingCoreData: ArrayList<GeetingCoreData>) : RecyclerView.Adapter<BaseViewHolder>(){

    lateinit var mListener : KitchenAdapterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding : SentenceKitchenRowBinding = SentenceKitchenRowBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return SentenceKitchenViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return mKitchenGeetingCoreData.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun addItem(KitchenCoreData: List<GeetingCoreData>) {
        mKitchenGeetingCoreData.addAll(KitchenCoreData)
        notifyDataSetChanged()
    }

    fun clearItems() {
        mKitchenGeetingCoreData.clear()
    }
    fun setListener(listener : KitchenAdapterListener)
    {
        mListener = listener
    }
    interface KitchenAdapterListener{

    }

    inner class SentenceKitchenViewHolder(binding: SentenceKitchenRowBinding) : BaseViewHolder(binding.root), SentenceKitchenItemViewModel.SentenceKitchenItemViewModelListener
    {
        val mBinding : SentenceKitchenRowBinding = binding
        private var mSentenceKitchenItemViewModel : SentenceKitchenItemViewModel? = null
        override fun onBind(position: Int)
        {
            val  Kitchen : GeetingCoreData = mKitchenGeetingCoreData[position]
            mSentenceKitchenItemViewModel = SentenceKitchenItemViewModel(Kitchen,position,this)
            mBinding.viewModel = mSentenceKitchenItemViewModel
            mBinding.executePendingBindings()

        }

    }
}