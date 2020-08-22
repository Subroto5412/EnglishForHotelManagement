package com.subroto.english.hotelmanagement.ui.main.sentence.geetings

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.databinding.SentenceGeetingsRowBinding
import com.subroto.english.hotelmanagement.ui.base.BaseViewHolder
import com.subroto.english.hotelmanagement.ui.main.sentence.geetings.SentenceGeetingsItemViewModel
import javax.inject.Inject

class SentenceGeetingsAdapter  @Inject constructor(private val context: Context, val mGeetingCoreData: ArrayList<GeetingCoreData>) : RecyclerView.Adapter<BaseViewHolder>(){

    lateinit var mListener : GeetingsAdapterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding : SentenceGeetingsRowBinding = SentenceGeetingsRowBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return SentenceGeetingsViewHolder(binding)
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

    inner class SentenceGeetingsViewHolder(binding: SentenceGeetingsRowBinding) : BaseViewHolder(binding.root), SentenceGeetingsItemViewModel.SentenceGeetingsItemViewModelListener
    {
        val mBinding : SentenceGeetingsRowBinding = binding
        private var mSentenceGeetingsItemViewModel : SentenceGeetingsItemViewModel? = null
        override fun onBind(position: Int)
        {
            val  Geetings : GeetingCoreData = mGeetingCoreData[position]
            mSentenceGeetingsItemViewModel = SentenceGeetingsItemViewModel(Geetings,position,this)
            mBinding.viewModel = mSentenceGeetingsItemViewModel
            mBinding.executePendingBindings()

        }

    }
}