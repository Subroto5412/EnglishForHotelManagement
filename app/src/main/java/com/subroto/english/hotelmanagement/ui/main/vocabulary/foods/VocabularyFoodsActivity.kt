package com.subroto.english.hotelmanagement.ui.main.vocabulary.foods

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.library.baseAdapters.BR
import androidx.recyclerview.widget.DefaultItemAnimator
import com.subroto.english.hotelmanagement.R
import com.subroto.english.hotelmanagement.data.domainModel.GeetingCoreData
import com.subroto.english.hotelmanagement.databinding.VocabularyFoodBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.vocabulary.VocabularyActivity
import androidx.lifecycle.Observer
import javax.inject.Inject


class VocabularyFoodsActivity  : BaseActivity<VocabularyFoodBinding, VocabularyFoodsViewModel>(),
    IVocabularyFoodsNavigator, VocabularyFoodsAdapter.FoodsAdapterListener{


    @Inject
    lateinit var mVocabularyFoodsViewModel: VocabularyFoodsViewModel

    @Inject
    lateinit var mVocabularyFoodsAdapter: VocabularyFoodsAdapter
    lateinit var mVocabularyFoodBinding: VocabularyFoodBinding


    override val viewModel: VocabularyFoodsViewModel
        get() = mVocabularyFoodsViewModel



    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.vocabulary_food

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        mVocabularyFoodsAdapter.setListener(this)
        mVocabularyFoodsViewModel.fetchFoods()

        mVocabularyFoodBinding = viewDataBinding!!
        setUp()
        subscribeToLiveData()

        val backBtn = findViewById<EditText>(R.id.backbtn) as Button
        val titileName = findViewById<EditText>(R.id.title_name_tv) as TextView
        titileName.text = "Foods"

        backBtn.setOnClickListener() {
            val intent = Intent(this, VocabularyActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun subscribeToLiveData()
    {
        mVocabularyFoodsViewModel.getFoodsListLiveData().observe(this, Observer { t ->
            mVocabularyFoodsViewModel.addFoodsItemToList(t)
            updateFoods(t)
        })
    }

    fun setUp()
    {
        mVocabularyFoodBinding.foodsRv.itemAnimator = DefaultItemAnimator()
        mVocabularyFoodBinding.foodsRv.adapter = mVocabularyFoodsAdapter
    }

    fun updateFoods(FoodsDataList: List<GeetingCoreData>?)
    {
        mVocabularyFoodsAdapter.clearItems()
        if(!FoodsDataList.isNullOrEmpty())
        {
            mVocabularyFoodsAdapter.addItem(FoodsDataList)
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, VocabularyFoodsActivity::class.java)
        }
    }
}