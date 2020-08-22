package com.subroto.english.hotelmanagement.ui.main.sentence.kitchen

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
import com.subroto.english.hotelmanagement.databinding.SentenceKitchenBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.SentenceActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.kitchen.SentenceKitchenAdapter
import com.subroto.english.hotelmanagement.ui.main.sentence.kitchen.SentenceKitchenViewModel
import com.subroto.english.hotelmanagement.ui.main.sentence.kitchen.ISentenceKitchenNavigator
import javax.inject.Inject

class SentenceKitchenActivity  : BaseActivity<SentenceKitchenBinding, SentenceKitchenViewModel>(),
    ISentenceKitchenNavigator, SentenceKitchenAdapter.KitchenAdapterListener{


    @Inject
    lateinit var mSentenceKitchenViewModel: SentenceKitchenViewModel

    @Inject
    lateinit var mSentenceKitchenAdapter: SentenceKitchenAdapter
    lateinit var mSentenceKitchenBinding: SentenceKitchenBinding


    override val viewModel: SentenceKitchenViewModel
        get() = mSentenceKitchenViewModel



    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.sentence_kitchen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        mSentenceKitchenAdapter.setListener(this)
        mSentenceKitchenViewModel.fetchKitchen()

        mSentenceKitchenBinding = viewDataBinding!!
        setUp()
        subscribeToLiveData()

        val backBtn = findViewById<EditText>(R.id.backbtn) as Button
        val titileName = findViewById<EditText>(R.id.title_name_tv) as TextView
        titileName.text = "Kitchen"

        backBtn.setOnClickListener() {
            val intent = Intent(this, SentenceActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun subscribeToLiveData()
    {
        mSentenceKitchenViewModel.getKitchenListLiveData().observe(this, Observer { t ->
            mSentenceKitchenViewModel.addKitchenItemToList(t)
            updateKitchen(t)
        })
    }

    fun setUp()
    {
        mSentenceKitchenBinding.kitchenRv.itemAnimator = DefaultItemAnimator()
        mSentenceKitchenBinding.kitchenRv.adapter = mSentenceKitchenAdapter

    }

    fun updateKitchen(KitchenDataList: List<GeetingCoreData>?)
    {
        mSentenceKitchenAdapter.clearItems()
        if(!KitchenDataList.isNullOrEmpty())
        {
            mSentenceKitchenAdapter.addItem(KitchenDataList)
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SentenceKitchenActivity::class.java)
        }
    }
}