package com.subroto.english.hotelmanagement.ui.main.sentence.service

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.databinding.SentenceServiceRowBinding
import com.subroto.english.hotelmanagement.ui.base.BaseViewHolder
import com.subroto.english.hotelmanagement.ui.main.sentence.service.SentenceServiceItemViewModel
import javax.inject.Inject

class SentenceServiceAdapter  @Inject constructor(private val context: Context, val mServiceGeetingCoreData: ArrayList<GeetingCoreData>) : RecyclerView.Adapter<BaseViewHolder>(){

    lateinit var mListener : ServiceAdapterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding : SentenceServiceRowBinding = SentenceServiceRowBinding.inflate(
            LayoutInflater.from(parent.context),parent,false)
        return SentenceServiceViewHolder(binding)
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

    inner class SentenceServiceViewHolder(binding: SentenceServiceRowBinding) : BaseViewHolder(binding.root), SentenceServiceItemViewModel.SentenceServiceItemViewModelListener
    {
        val mBinding : SentenceServiceRowBinding = binding
        private var mSentenceServiceItemViewModel : SentenceServiceItemViewModel? = null
        override fun onBind(position: Int)
        {
            val  Service : GeetingCoreData = mServiceGeetingCoreData[position]
            mSentenceServiceItemViewModel = SentenceServiceItemViewModel(Service,position,this)
            mBinding.viewModel = mSentenceServiceItemViewModel
            mBinding.executePendingBindings()

        }

    }
}