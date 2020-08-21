package com.subroto.english.hotelmanagement.ui.main.vocabulary.reception

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.databinding.VocabularyReceptionRowBinding
import com.subroto.english.hotelmanagement.ui.base.BaseViewHolder
import javax.inject.Inject

class VocabularyReceptionAdapter  @Inject constructor(private val context: Context, val mReceptionGeetingCoreData: ArrayList<GeetingCoreData>) : RecyclerView.Adapter<BaseViewHolder>(){

    lateinit var mListener : ReceptionAdapterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding : VocabularyReceptionRowBinding = VocabularyReceptionRowBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return VocabularyReceptionViewHolder(binding)
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

    inner class VocabularyReceptionViewHolder(binding: VocabularyReceptionRowBinding) : BaseViewHolder(binding.root), VocabularyReceptionItemViewModel.VocabularyReceptionItemViewModelListener
    {
        val mBinding : VocabularyReceptionRowBinding = binding
        private var mVocabularyReceptionItemViewModel : VocabularyReceptionItemViewModel? = null
        override fun onBind(position: Int)
        {
            val  Reception : GeetingCoreData = mReceptionGeetingCoreData[position]
            mVocabularyReceptionItemViewModel = VocabularyReceptionItemViewModel(Reception,position,this)
            mBinding.viewModel = mVocabularyReceptionItemViewModel
            mBinding.executePendingBindings()

        }

    }
}