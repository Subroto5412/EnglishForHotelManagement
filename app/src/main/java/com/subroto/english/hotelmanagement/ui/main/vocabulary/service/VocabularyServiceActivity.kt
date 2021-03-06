package com.subroto.english.hotelmanagement.ui.main.vocabulary.service

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import com.subroto.english.hotelmanagement.R
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.databinding.VocabularyServiceBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.vocabulary.VocabularyActivity
import javax.inject.Inject

class VocabularyServiceActivity  : BaseActivity<VocabularyServiceBinding, VocabularyServiceViewModel>(),
    IVocabularyServiceNavigator, VocabularyServiceAdapter.ServiceAdapterListener{


    @Inject
    lateinit var mVocabularyServiceViewModel: VocabularyServiceViewModel

    @Inject
    lateinit var mVocabularyServiceAdapter: VocabularyServiceAdapter
    lateinit var mVocabularyServiceBinding: VocabularyServiceBinding


    override val viewModel: VocabularyServiceViewModel
        get() = mVocabularyServiceViewModel



    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.vocabulary_service

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        mVocabularyServiceAdapter.setListener(this)
        mVocabularyServiceViewModel.fetchService()

        mVocabularyServiceBinding = viewDataBinding!!
        setUp()
        subscribeToLiveData()

        val backBtn = findViewById<EditText>(R.id.backbtn) as Button
        val titileName = findViewById<EditText>(R.id.title_name_tv) as TextView
        titileName.text = "Service"

        backBtn.setOnClickListener() {
            val intent = Intent(this, VocabularyActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun subscribeToLiveData()
    {
        mVocabularyServiceViewModel.getServiceListLiveData().observe(this, Observer { t ->
            mVocabularyServiceViewModel.addServiceItemToList(t)
            updateService(t)
        })
    }

    fun setUp()
    {
        mVocabularyServiceBinding.serviceRv.itemAnimator = DefaultItemAnimator()
        mVocabularyServiceBinding.serviceRv.adapter = mVocabularyServiceAdapter
    }

    fun updateService(ServiceDataList: List<GeetingCoreData>?)
    {
        mVocabularyServiceAdapter.clearItems()
        if(!ServiceDataList.isNullOrEmpty())
        {
            mVocabularyServiceAdapter.addItem(ServiceDataList)
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, VocabularyServiceActivity::class.java)
        }
    }
}