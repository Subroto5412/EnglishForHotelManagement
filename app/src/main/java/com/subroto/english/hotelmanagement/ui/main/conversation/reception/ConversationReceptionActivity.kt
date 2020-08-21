package com.subroto.english.hotelmanagement.ui.main.conversation.reception

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
import com.subroto.english.hotelmanagement.databinding.ConversationReceptionBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.ConversationActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.reception.IConversationReceptionNavigator
import com.subroto.english.hotelmanagement.ui.main.conversation.reception.ConversationReceptionAdapter
import com.subroto.english.hotelmanagement.ui.main.conversation.reception.ConversationReceptionViewModel
import javax.inject.Inject

class ConversationReceptionActivity  : BaseActivity<ConversationReceptionBinding, ConversationReceptionViewModel>(),
    IConversationReceptionNavigator, ConversationReceptionAdapter.ReceptionAdapterListener{


    @Inject
    lateinit var mConversationReceptionViewModel: ConversationReceptionViewModel

    @Inject
    lateinit var mConversationReceptionAdapter: ConversationReceptionAdapter
    lateinit var mConversationReceptionBinding: ConversationReceptionBinding


    override val viewModel: ConversationReceptionViewModel
        get() = mConversationReceptionViewModel



    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.conversation_reception

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        mConversationReceptionAdapter.setListener(this)
        mConversationReceptionViewModel.fetchReception()

        mConversationReceptionBinding = viewDataBinding!!
        setUp()
        subscribeToLiveData()

        val backBtn = findViewById<EditText>(R.id.backbtn) as Button
        val titileName = findViewById<EditText>(R.id.title_name_tv) as TextView
        titileName.text = "Reception"

        backBtn.setOnClickListener() {
            val intent = Intent(this, ConversationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun subscribeToLiveData()
    {
        mConversationReceptionViewModel.getReceptionListLiveData().observe(this, Observer { t ->
            mConversationReceptionViewModel.addReceptionItemToList(t)
            updateReception(t)
        })
    }

    fun setUp()
    {
        mConversationReceptionBinding.receptionRv.itemAnimator = DefaultItemAnimator()
        mConversationReceptionBinding.receptionRv.adapter = mConversationReceptionAdapter

    }

    fun updateReception(ReceptionDataList: List<GeetingCoreData>?)
    {
        mConversationReceptionAdapter.clearItems()
        if(!ReceptionDataList.isNullOrEmpty())
        {
            mConversationReceptionAdapter.addItem(ReceptionDataList)
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ConversationReceptionActivity::class.java)
        }
    }
}