package com.subroto.english.hotelmanagement.ui.main.conversation.reception

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.databinding.ConversationReceptionRowBinding
import com.subroto.english.hotelmanagement.ui.base.BaseViewHolder
import com.subroto.english.hotelmanagement.ui.main.conversation.reception.ConversationReceptionItemViewModel
import javax.inject.Inject

class ConversationReceptionAdapter  @Inject constructor(private val context: Context, val mReceptionGeetingCoreData: ArrayList<GeetingCoreData>) : RecyclerView.Adapter<BaseViewHolder>(){

    lateinit var mListener : ReceptionAdapterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding : ConversationReceptionRowBinding = ConversationReceptionRowBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return ConversationReceptionViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return mReceptionGeetingCoreData.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun addItem(ReceptionCoreData: List<GeetingCoreData>) {
        mReceptionGeetingCoreData.addAll(ReceptionCoreData)
        notifyDataSetChanged()
    }

    fun clearItems() {
        mReceptionGeetingCoreData.clear()
    }
    fun setListener(listener : ReceptionAdapterListener)
    {
        mListener = listener
    }
    interface ReceptionAdapterListener{

    }

    inner class ConversationReceptionViewHolder(binding: ConversationReceptionRowBinding) : BaseViewHolder(binding.root), ConversationReceptionItemViewModel.ConversationReceptionItemViewModelListener
    {
        val mBinding : ConversationReceptionRowBinding = binding
        private var mConversationReceptionItemViewModel : ConversationReceptionItemViewModel? = null
        override fun onBind(position: Int)
        {
            val  Reception : GeetingCoreData = mReceptionGeetingCoreData[position]
            mConversationReceptionItemViewModel = ConversationReceptionItemViewModel(Reception,position,this)
            mBinding.viewModel = mConversationReceptionItemViewModel
            mBinding.executePendingBindings()

        }

    }
}