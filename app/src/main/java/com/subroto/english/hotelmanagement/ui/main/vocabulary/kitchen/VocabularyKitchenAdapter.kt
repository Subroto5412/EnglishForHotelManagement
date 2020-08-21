package com.subroto.english.hotelmanagement.ui.main.vocabulary.kitchen

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.databinding.VocabularyKitchenRowBinding
import com.subroto.english.hotelmanagement.ui.base.BaseViewHolder
import com.subroto.english.hotelmanagement.ui.main.vocabulary.kitchen.VocabularyKitchenItemViewModel
import javax.inject.Inject

class VocabularyKitchenAdapter  @Inject constructor(private val context: Context, val mKitchenGeetingCoreData: ArrayList<GeetingCoreData>) : RecyclerView.Adapter<BaseViewHolder>(){

    lateinit var mListener : KitchenAdapterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding : VocabularyKitchenRowBinding = VocabularyKitchenRowBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return VocabularyKitchenViewHolder(binding)
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

    inner class VocabularyKitchenViewHolder(binding: VocabularyKitchenRowBinding) : BaseViewHolder(binding.root), VocabularyKitchenItemViewModel.VocabularyKitchenItemViewModelListener
    {
        val mBinding : VocabularyKitchenRowBinding = binding
        private var mVocabularyKitchenItemViewModel : VocabularyKitchenItemViewModel? = null
        override fun onBind(position: Int)
        {
            val  Kitchen : GeetingCoreData = mKitchenGeetingCoreData[position]
            mVocabularyKitchenItemViewModel = VocabularyKitchenItemViewModel(Kitchen,position,this)
            mBinding.viewModel = mVocabularyKitchenItemViewModel
            mBinding.executePendingBindings()

        }

    }
}