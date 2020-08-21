package com.subroto.english.hotelmanagement.ui.main.conversation.foods

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
import com.subroto.english.hotelmanagement.databinding.ConversationFoodBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.ConversationActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.foods.IConversationFoodsNavigator
import com.subroto.english.hotelmanagement.ui.main.conversation.foods.ConversationFoodsAdapter
import com.subroto.english.hotelmanagement.ui.main.conversation.foods.ConversationFoodsViewModel
import javax.inject.Inject

class ConversationFoodsActivity  : BaseActivity<ConversationFoodBinding, ConversationFoodsViewModel>(),
    IConversationFoodsNavigator, ConversationFoodsAdapter.FoodsAdapterListener{


    @Inject
    lateinit var mConversationFoodsViewModel: ConversationFoodsViewModel

    @Inject
    lateinit var mConversationFoodsAdapter: ConversationFoodsAdapter
    lateinit var mConversationFoodBinding: ConversationFoodBinding


    override val viewModel: ConversationFoodsViewModel
        get() = mConversationFoodsViewModel



    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.conversation_food

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        mConversationFoodsAdapter.setListener(this)
        mConversationFoodsViewModel.fetchFoods()

        mConversationFoodBinding = viewDataBinding!!
        setUp()
        subscribeToLiveData()

        val backBtn = findViewById<EditText>(R.id.backbtn) as Button
        val titileName = findViewById<EditText>(R.id.title_name_tv) as TextView
        titileName.text = "Foods"

        backBtn.setOnClickListener() {
            val intent = Intent(this, ConversationActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun subscribeToLiveData()
    {
        mConversationFoodsViewModel.getFoodsListLiveData().observe(this, Observer { t ->
            mConversationFoodsViewModel.addFoodsItemToList(t)
            updateFoods(t)
        })
    }

    fun setUp()
    {
        mConversationFoodBinding.foodRv.itemAnimator = DefaultItemAnimator()
        mConversationFoodBinding.foodRv.adapter = mConversationFoodsAdapter
    }

    fun updateFoods(FoodsDataList: List<GeetingCoreData>?)
    {
        mConversationFoodsAdapter.clearItems()
        if(!FoodsDataList.isNullOrEmpty())
        {
            mConversationFoodsAdapter.addItem(FoodsDataList)
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ConversationFoodsActivity::class.java)
        }
    }
}