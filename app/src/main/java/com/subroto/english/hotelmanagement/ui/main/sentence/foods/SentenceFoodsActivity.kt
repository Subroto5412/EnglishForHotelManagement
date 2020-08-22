package com.subroto.english.hotelmanagement.ui.main.sentence.foods

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
import com.subroto.english.hotelmanagement.databinding.SentenceFoodBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.SentenceActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.foods.SentenceFoodsAdapter
import com.subroto.english.hotelmanagement.ui.main.sentence.foods.SentenceFoodsViewModel
import com.subroto.english.hotelmanagement.ui.main.sentence.foods.ISentenceFoodsNavigator
import javax.inject.Inject

class SentenceFoodsActivity  : BaseActivity<SentenceFoodBinding, SentenceFoodsViewModel>(),
    ISentenceFoodsNavigator, SentenceFoodsAdapter.FoodsAdapterListener{


    @Inject
    lateinit var mSentenceFoodsViewModel: SentenceFoodsViewModel

    @Inject
    lateinit var mSentenceFoodsAdapter: SentenceFoodsAdapter
    lateinit var mSentenceFoodBinding: SentenceFoodBinding


    override val viewModel: SentenceFoodsViewModel
        get() = mSentenceFoodsViewModel



    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.sentence_food

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        mSentenceFoodsAdapter.setListener(this)
        mSentenceFoodsViewModel.fetchFoods()

        mSentenceFoodBinding = viewDataBinding!!
        setUp()
        subscribeToLiveData()

        val backBtn = findViewById<EditText>(R.id.backbtn) as Button
        val titileName = findViewById<EditText>(R.id.title_name_tv) as TextView
        titileName.text = "Foods"

        backBtn.setOnClickListener() {
            val intent = Intent(this, SentenceActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun subscribeToLiveData()
    {
        mSentenceFoodsViewModel.getFoodsListLiveData().observe(this, Observer { t ->
            mSentenceFoodsViewModel.addFoodsItemToList(t)
            updateFoods(t)
        })
    }

    fun setUp()
    {
        mSentenceFoodBinding.foodRv.itemAnimator = DefaultItemAnimator()
        mSentenceFoodBinding.foodRv.adapter = mSentenceFoodsAdapter
    }

    fun updateFoods(FoodsDataList: List<GeetingCoreData>?)
    {
        mSentenceFoodsAdapter.clearItems()
        if(!FoodsDataList.isNullOrEmpty())
        {
            mSentenceFoodsAdapter.addItem(FoodsDataList)
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SentenceFoodsActivity::class.java)
        }
    }
}