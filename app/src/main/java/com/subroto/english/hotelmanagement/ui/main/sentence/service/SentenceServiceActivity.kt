package com.subroto.english.hotelmanagement.ui.main.sentence.service

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
import com.subroto.english.hotelmanagement.databinding.SentenceServiceBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.SentenceActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.service.SentenceServiceAdapter
import com.subroto.english.hotelmanagement.ui.main.sentence.service.SentenceServiceViewModel
import com.subroto.english.hotelmanagement.ui.main.sentence.service.ISentenceServiceNavigator
import javax.inject.Inject

class SentenceServiceActivity  : BaseActivity<SentenceServiceBinding, SentenceServiceViewModel>(),
    ISentenceServiceNavigator, SentenceServiceAdapter.ServiceAdapterListener{


    @Inject
    lateinit var mSentenceServiceViewModel: SentenceServiceViewModel

    @Inject
    lateinit var mSentenceServiceAdapter: SentenceServiceAdapter
    lateinit var mSentenceServiceBinding: SentenceServiceBinding


    override val viewModel: SentenceServiceViewModel
        get() = mSentenceServiceViewModel



    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.sentence_service

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        mSentenceServiceAdapter.setListener(this)
        mSentenceServiceViewModel.fetchService()

        mSentenceServiceBinding = viewDataBinding!!
        setUp()
        subscribeToLiveData()

        val backBtn = findViewById<EditText>(R.id.backbtn) as Button
        val titileName = findViewById<EditText>(R.id.title_name_tv) as TextView
        titileName.text = "Service"

        backBtn.setOnClickListener() {
            val intent = Intent(this, SentenceActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun subscribeToLiveData()
    {
        mSentenceServiceViewModel.getServiceListLiveData().observe(this, Observer { t ->
            mSentenceServiceViewModel.addServiceItemToList(t)
            updateService(t)
        })
    }

    fun setUp()
    {
        mSentenceServiceBinding.serviceRv.itemAnimator = DefaultItemAnimator()
        mSentenceServiceBinding.serviceRv.adapter = mSentenceServiceAdapter
    }

    fun updateService(ServiceDataList: List<GeetingCoreData>?)
    {
        mSentenceServiceAdapter.clearItems()
        if(!ServiceDataList.isNullOrEmpty())
        {
            mSentenceServiceAdapter.addItem(ServiceDataList)
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SentenceServiceActivity::class.java)
        }
    }
}