package com.subroto.english.hotelmanagement.ui.main.vocabulary.foods

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.databinding.VocabularyFoodRowBinding
import com.subroto.english.hotelmanagement.ui.base.BaseViewHolder
import javax.inject.Inject

class VocabularyFoodsAdapter  @Inject constructor(private val context: Context, val mFoodsGeetingCoreData: ArrayList<GeetingCoreData>) : RecyclerView.Adapter<BaseViewHolder>(){

    lateinit var mListener : FoodsAdapterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding : VocabularyFoodRowBinding = VocabularyFoodRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return VocabularyFoodsViewHolder(binding)
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

    inner class VocabularyFoodsViewHolder(binding: VocabularyFoodRowBinding) : BaseViewHolder(binding.root), VocabularyFoodsItemViewModel.VocabularyFoodsItemViewModelListener
    {
        val mBinding : VocabularyFoodRowBinding = binding
        private var mVocabularyFoodsItemViewModel : VocabularyFoodsItemViewModel? = null
        override fun onBind(position: Int)
        {
            val  foods : GeetingCoreData = mFoodsGeetingCoreData[position]
            mVocabularyFoodsItemViewModel = VocabularyFoodsItemViewModel(foods,position,this)
            mBinding.viewModel = mVocabularyFoodsItemViewModel
            mBinding.executePendingBindings()

        }

    }
}