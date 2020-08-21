package com.subroto.english.hotelmanagement.ui.main.conversation.foods

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.databinding.ConversationFoodRowBinding
import com.subroto.english.hotelmanagement.ui.base.BaseViewHolder
import com.subroto.english.hotelmanagement.ui.main.conversation.foods.ConversationFoodsItemViewModel
import javax.inject.Inject

class ConversationFoodsAdapter  @Inject constructor(private val context: Context, val mFoodsGeetingCoreData: ArrayList<GeetingCoreData>) : RecyclerView.Adapter<BaseViewHolder>(){

    lateinit var mListener : FoodsAdapterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding : ConversationFoodRowBinding = ConversationFoodRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ConversationFoodsViewHolder(binding)
    }

    override fun getItemCount(): Int {

        return mFoodsGeetingCoreData.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position)
    }

    fun addItem(foodsCoreData: List<GeetingCoreData>) {
        mFoodsGeetingCoreData.addAll(foodsCoreData)
        notifyDataSetChanged()
    }

    fun clearItems() {
        mFoodsGeetingCoreData.clear()
    }
    fun setListener(listener : FoodsAdapterListener)
    {
        mListener = listener
    }
    interface FoodsAdapterListener{

    }

    inner class ConversationFoodsViewHolder(binding: ConversationFoodRowBinding) : BaseViewHolder(binding.root), ConversationFoodsItemViewModel.ConversationFoodsItemViewModelListener
    {
        val mBinding : ConversationFoodRowBinding = binding
        private var mConversationFoodsItemViewModel : ConversationFoodsItemViewModel? = null
        override fun onBind(position: Int)
        {
            val  foods : GeetingCoreData = mFoodsGeetingCoreData[position]
            mConversationFoodsItemViewModel = ConversationFoodsItemViewModel(foods,position,this)
            mBinding.viewModel = mConversationFoodsItemViewModel
            mBinding.executePendingBindings()

        }

    }
}