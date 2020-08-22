package com.subroto.english.hotelmanagement.ui.main.sentence.reception

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.databinding.SentenceReceptionRowBinding
import com.subroto.english.hotelmanagement.ui.base.BaseViewHolder
import com.subroto.english.hotelmanagement.ui.main.sentence.reception.SentenceReceptionItemViewModel
import javax.inject.Inject

class SentenceReceptionAdapter  @Inject constructor(private val context: Context, val mReceptionGeetingCoreData: ArrayList<GeetingCoreData>) : RecyclerView.Adapter<BaseViewHolder>(){

    lateinit var mListener : ReceptionAdapterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding : SentenceReceptionRowBinding = SentenceReceptionRowBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return SentenceReceptionViewHolder(binding)
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

    inner class SentenceReceptionViewHolder(binding: SentenceReceptionRowBinding) : BaseViewHolder(binding.root), SentenceReceptionItemViewModel.SentenceReceptionItemViewModelListener
    {
        val mBinding : SentenceReceptionRowBinding = binding
        private var mSentenceReceptionItemViewModel : SentenceReceptionItemViewModel? = null
        override fun onBind(position: Int)
        {
            val  Reception : GeetingCoreData = mReceptionGeetingCoreData[position]
            mSentenceReceptionItemViewModel = SentenceReceptionItemViewModel(Reception,position,this)
            mBinding.viewModel = mSentenceReceptionItemViewModel
            mBinding.executePendingBindings()

        }

    }
}