package com.subroto.english.hotelmanagement.ui.main.vocabulary.service

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.databinding.VocabularyServiceRowBinding
import com.subroto.english.hotelmanagement.ui.base.BaseViewHolder
import javax.inject.Inject

class VocabularyServiceAdapter  @Inject constructor(private val context: Context, val mServiceGeetingCoreData: ArrayList<GeetingCoreData>) : RecyclerView.Adapter<BaseViewHolder>(){

    lateinit var mListener : ServiceAdapterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val binding : VocabularyServiceRowBinding = VocabularyServiceRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return VocabularyServiceViewHolder(binding)
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

    inner class VocabularyServiceViewHolder(binding: VocabularyServiceRowBinding) : BaseViewHolder(binding.root), VocabularyServiceItemViewModel.VocabularyServiceItemViewModelListener
    {
        val mBinding : VocabularyServiceRowBinding = binding
        private var mVocabularyServiceItemViewModel : VocabularyServiceItemViewModel? = null
        override fun onBind(position: Int)
        {
            val  Service : GeetingCoreData = mServiceGeetingCoreData[position]
            mVocabularyServiceItemViewModel = VocabularyServiceItemViewModel(Service,position,this)
            mBinding.viewModel = mVocabularyServiceItemViewModel
            mBinding.executePendingBindings()

        }

    }
}