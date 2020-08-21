package com.subroto.english.hotelmanagement.ui.main.conversation.geetings

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.databinding.ConversationFoodRowBinding
import com.subroto.english.hotelmanagement.databinding.ConversationGeetingsRowBinding
import com.subroto.english.hotelmanagement.ui.base.BaseViewHolder
import javax.inject.Inject

class ConversationGeetingsAdapter  @Inject constructor(private val context: Context, val mGeetingCoreData: ArrayList<GeetingCoreData>) : RecyclerView.Adapter<BaseViewHolder>(){

    lateinit var mListener : GeetingsAdapterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding : ConversationGeetingsRowBinding = ConversationGeetingsRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ConversationGeetingsViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return mGeetingCoreData.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun addItem(GeetingsCoreData: List<GeetingCoreData>) {
        mGeetingCoreData.addAll(GeetingsCoreData)
        notifyDataSetChanged()
    }

    fun clearItems() {
        mGeetingCoreData.clear()
    }
    fun setListener(listener : GeetingsAdapterListener)
    {
        mListener = listener
    }
    interface GeetingsAdapterListener{

    }

    inner class ConversationGeetingsViewHolder(binding: ConversationGeetingsRowBinding) : BaseViewHolder(binding.root), ConversationGeetingsItemViewModel.ConversationGeetingsItemViewModelListener
    {
        val mBinding : ConversationGeetingsRowBinding = binding
        private var mConversationGeetingsItemViewModel : ConversationGeetingsItemViewModel? = null
        override fun onBind(position: Int)
        {
            val  Geetings : GeetingCoreData = mGeetingCoreData[position]
            mConversationGeetingsItemViewModel = ConversationGeetingsItemViewModel(Geetings,position,this)
            mBinding.viewModel = mConversationGeetingsItemViewModel
            mBinding.executePendingBindings()

        }

    }
}