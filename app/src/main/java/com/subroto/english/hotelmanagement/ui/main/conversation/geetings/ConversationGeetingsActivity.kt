package com.subroto.english.hotelmanagement.ui.main.conversation.geetings

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
import com.subroto.english.hotelmanagement.databinding.ConversationGeetingsBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.ConversationActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.geetings.ConversationGeetingsAdapter
import com.subroto.english.hotelmanagement.ui.main.conversation.geetings.ConversationGeetingsViewModel
import com.subroto.english.hotelmanagement.ui.main.conversation.geetings.IConversationGeetingsNavigator
import javax.inject.Inject

class ConversationGeetingsActivity  : BaseActivity<ConversationGeetingsBinding, ConversationGeetingsViewModel>(),
    IConversationGeetingsNavigator, ConversationGeetingsAdapter.GeetingsAdapterListener{


    @Inject
    lateinit var mConversationGeetingsViewModel: ConversationGeetingsViewModel

    @Inject
    lateinit var mConversationGeetingsAdapter: ConversationGeetingsAdapter
    lateinit var mConversationFoodBinding: ConversationGeetingsBinding


    override val viewModel: ConversationGeetingsViewModel
        get() = mConversationGeetingsViewModel



    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.conversation_geetings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        mConversationGeetingsAdapter.setListener(this)
        mConversationGeetingsViewModel.fetchGeetings()

        mConversationFoodBinding = viewDataBinding!!
        setUp()
        subscribeToLiveData()

        val backBtn = findViewById<EditText>(R.id.backbtn) as Button
        val titileName = findViewById<EditText>(R.id.title_name_tv) as TextView
        titileName.text = "Geetings"

        backBtn.setOnClickListener() {
            val intent = Intent(this, ConversationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun subscribeToLiveData()
    {
        mConversationGeetingsViewModel.getGeetingsListLiveData().observe(this, Observer { t ->
            mConversationGeetingsViewModel.addGeetingsItemToList(t)
            updateGeetings(t)
        })
    }

    fun setUp()
    {
        mConversationFoodBinding.geetingsRv.itemAnimator = DefaultItemAnimator()
        mConversationFoodBinding.geetingsRv.adapter = mConversationGeetingsAdapter
    }

    fun updateGeetings(GeetingsDataList: List<GeetingCoreData>?)
    {
        mConversationGeetingsAdapter.clearItems()
        if(!GeetingsDataList.isNullOrEmpty())
        {
            mConversationGeetingsAdapter.addItem(GeetingsDataList)
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ConversationGeetingsActivity::class.java)
        }
    }
}