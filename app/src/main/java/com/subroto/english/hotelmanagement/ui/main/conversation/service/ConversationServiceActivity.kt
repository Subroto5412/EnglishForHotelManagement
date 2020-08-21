package com.subroto.english.hotelmanagement.ui.main.conversation.service

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
import com.subroto.english.hotelmanagement.databinding.ConversationServiceBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.service.IConversationServiceNavigator
import com.subroto.english.hotelmanagement.ui.main.conversation.service.ConversationServiceAdapter
import com.subroto.english.hotelmanagement.ui.main.conversation.service.ConversationServiceViewModel
import com.subroto.english.hotelmanagement.ui.main.conversation.ConversationActivity
import javax.inject.Inject

class ConversationServiceActivity  : BaseActivity<ConversationServiceBinding, ConversationServiceViewModel>(),
    IConversationServiceNavigator, ConversationServiceAdapter.ServiceAdapterListener{


    @Inject
    lateinit var mConversationServiceViewModel: ConversationServiceViewModel

    @Inject
    lateinit var mConversationServiceAdapter: ConversationServiceAdapter
    lateinit var mConversationServiceBinding: ConversationServiceBinding


    override val viewModel: ConversationServiceViewModel
        get() = mConversationServiceViewModel



    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.conversation_service

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        mConversationServiceAdapter.setListener(this)
        mConversationServiceViewModel.fetchService()

        mConversationServiceBinding = viewDataBinding!!
        setUp()
        subscribeToLiveData()

        val backBtn = findViewById<EditText>(R.id.backbtn) as Button
        val titileName = findViewById<EditText>(R.id.title_name_tv) as TextView
        titileName.text = "Service"

        backBtn.setOnClickListener() {
            val intent = Intent(this, ConversationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun subscribeToLiveData()
    {
        mConversationServiceViewModel.getServiceListLiveData().observe(this, Observer { t ->
            mConversationServiceViewModel.addServiceItemToList(t)
            updateService(t)
        })
    }

    fun setUp()
    {
        mConversationServiceBinding.serviceRv.itemAnimator = DefaultItemAnimator()
        mConversationServiceBinding.serviceRv.adapter = mConversationServiceAdapter
    }

    fun updateService(ServiceDataList: List<GeetingCoreData>?)
    {
        mConversationServiceAdapter.clearItems()
        if(!ServiceDataList.isNullOrEmpty())
        {
            mConversationServiceAdapter.addItem(ServiceDataList)
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ConversationServiceActivity::class.java)
        }
    }
}