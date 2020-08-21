package com.subroto.english.hotelmanagement.ui.main.conversation.service

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.databinding.ConversationServiceRowBinding
import com.subroto.english.hotelmanagement.ui.base.BaseViewHolder
import com.subroto.english.hotelmanagement.ui.main.conversation.service.ConversationServiceItemViewModel
import javax.inject.Inject

class ConversationServiceAdapter  @Inject constructor(private val context: Context, val mServiceGeetingCoreData: ArrayList<GeetingCoreData>) : RecyclerView.Adapter<BaseViewHolder>(){

    lateinit var mListener : ServiceAdapterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding : ConversationServiceRowBinding = ConversationServiceRowBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return ConversationServiceViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return mServiceGeetingCoreData.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun addItem(ServiceCoreData: List<GeetingCoreData>) {
        mServiceGeetingCoreData.addAll(ServiceCoreData)
        notifyDataSetChanged()
    }

    fun clearItems() {
        mServiceGeetingCoreData.clear()
    }
    fun setListener(listener : ServiceAdapterListener)
    {
        mListener = listener
    }
    interface ServiceAdapterListener{

    }

    inner class ConversationServiceViewHolder(binding: ConversationServiceRowBinding) : BaseViewHolder(binding.root), ConversationServiceItemViewModel.ConversationServiceItemViewModelListener
    {
        val mBinding : ConversationServiceRowBinding = binding
        private var mConversationServiceItemViewModel : ConversationServiceItemViewModel? = null
        override fun onBind(position: Int)
        {
            val  Service : GeetingCoreData = mServiceGeetingCoreData[position]
            mConversationServiceItemViewModel = ConversationServiceItemViewModel(Service,position,this)
            mBinding.viewModel = mConversationServiceItemViewModel
            mBinding.executePendingBindings()

        }

    }
}