package com.subroto.english.hotelmanagement.ui.main.sentence.foods

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.databinding.SentenceFoodRowBinding
import com.subroto.english.hotelmanagement.ui.base.BaseViewHolder
import javax.inject.Inject

class SentenceFoodsAdapter  @Inject constructor(private val context: Context, val mFoodsGeetingCoreData: ArrayList<GeetingCoreData>) : RecyclerView.Adapter<BaseViewHolder>(){

    lateinit var mListener : FoodsAdapterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding : SentenceFoodRowBinding = SentenceFoodRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SentenceFoodsViewHolder(binding)
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

    inner class SentenceFoodsViewHolder(binding: SentenceFoodRowBinding) : BaseViewHolder(binding.root), SentenceFoodsItemViewModel.SentenceFoodsItemViewModelListener
    {
        val mBinding : SentenceFoodRowBinding = binding
        private var mSentenceFoodsItemViewModel : SentenceFoodsItemViewModel? = null
        override fun onBind(position: Int)
        {
            val  foods : GeetingCoreData = mFoodsGeetingCoreData[position]
            mSentenceFoodsItemViewModel = SentenceFoodsItemViewModel(foods,position,this)
            mBinding.viewModel = mSentenceFoodsItemViewModel
            mBinding.executePendingBindings()

        }

    }
}