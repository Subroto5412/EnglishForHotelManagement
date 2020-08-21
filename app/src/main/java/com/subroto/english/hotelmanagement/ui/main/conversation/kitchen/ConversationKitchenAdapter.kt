package com.subroto.english.hotelmanagement.ui.main.conversation.kitchen

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.databinding.ConversationKitchenRowBinding
import com.subroto.english.hotelmanagement.ui.base.BaseViewHolder
import javax.inject.Inject

class ConversationKitchenAdapter  @Inject constructor(private val context: Context, val mKitchenGeetingCoreData: ArrayList<GeetingCoreData>) : RecyclerView.Adapter<BaseViewHolder>(){

    lateinit var mListener : KitchenAdapterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding : ConversationKitchenRowBinding = ConversationKitchenRowBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return ConversationKitchenViewHolder(binding)
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

    inner class ConversationKitchenViewHolder(binding: ConversationKitchenRowBinding) : BaseViewHolder(binding.root), ConversationKitchenItemViewModel.ConversationKitchenItemViewModelListener
    {
        val mBinding : ConversationKitchenRowBinding = binding
        private var mConversationKitchenItemViewModel : ConversationKitchenItemViewModel? = null
        override fun onBind(position: Int)
        {
            val  Kitchen : GeetingCoreData = mKitchenGeetingCoreData[position]
            mConversationKitchenItemViewModel = ConversationKitchenItemViewModel(Kitchen,position,this)
            mBinding.viewModel = mConversationKitchenItemViewModel
            mBinding.executePendingBindings()

        }

    }
}