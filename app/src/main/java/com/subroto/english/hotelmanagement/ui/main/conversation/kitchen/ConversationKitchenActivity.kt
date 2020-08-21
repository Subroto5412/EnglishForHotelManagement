package com.subroto.english.hotelmanagement.ui.main.conversation.kitchen

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
import com.subroto.english.hotelmanagement.databinding.ConversationKitchenBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.ConversationActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.kitchen.IConversationKitchenNavigator
import com.subroto.english.hotelmanagement.ui.main.conversation.kitchen.ConversationKitchenAdapter
import com.subroto.english.hotelmanagement.ui.main.conversation.kitchen.ConversationKitchenViewModel
import javax.inject.Inject

class ConversationKitchenActivity  : BaseActivity<ConversationKitchenBinding, ConversationKitchenViewModel>(),
    IConversationKitchenNavigator, ConversationKitchenAdapter.KitchenAdapterListener{


    @Inject
    lateinit var mConversationKitchenViewModel: ConversationKitchenViewModel

    @Inject
    lateinit var mConversationKitchenAdapter: ConversationKitchenAdapter
    lateinit var mConversationKitchenBinding: ConversationKitchenBinding


    override val viewModel: ConversationKitchenViewModel
        get() = mConversationKitchenViewModel



    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.conversation_kitchen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        mConversationKitchenAdapter.setListener(this)
        mConversationKitchenViewModel.fetchKitchen()

        mConversationKitchenBinding = viewDataBinding!!
        setUp()
        subscribeToLiveData()

        val backBtn = findViewById<EditText>(R.id.backbtn) as Button
        val titileName = findViewById<EditText>(R.id.title_name_tv) as TextView
        titileName.text = "Kitchen"

        backBtn.setOnClickListener() {
            val intent = Intent(this, ConversationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun subscribeToLiveData()
    {
        mConversationKitchenViewModel.getKitchenListLiveData().observe(this, Observer { t ->
            mConversationKitchenViewModel.addKitchenItemToList(t)
            updateKitchen(t)
        })
    }

    fun setUp()
    {
        mConversationKitchenBinding.kitchenRv.itemAnimator = DefaultItemAnimator()
        mConversationKitchenBinding.kitchenRv.adapter = mConversationKitchenAdapter

    }

    fun updateKitchen(KitchenDataList: List<GeetingCoreData>?)
    {
        mConversationKitchenAdapter.clearItems()
        if(!KitchenDataList.isNullOrEmpty())
        {
            mConversationKitchenAdapter.addItem(KitchenDataList)
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ConversationKitchenActivity::class.java)
        }
    }
}