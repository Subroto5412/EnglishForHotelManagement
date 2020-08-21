package com.subroto.english.hotelmanagement.ui.main.vocabulary.kitchen

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
import com.subroto.english.hotelmanagement.databinding.VocabularyKitchenBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.vocabulary.VocabularyActivity
import com.subroto.english.hotelmanagement.ui.main.vocabulary.kitchen.IVocabularyKitchenNavigator
import com.subroto.english.hotelmanagement.ui.main.vocabulary.kitchen.VocabularyKitchenAdapter
import com.subroto.english.hotelmanagement.ui.main.vocabulary.kitchen.VocabularyKitchenViewModel
import javax.inject.Inject

class VocabularyKitchenActivity  : BaseActivity<VocabularyKitchenBinding, VocabularyKitchenViewModel>(),
    IVocabularyKitchenNavigator, VocabularyKitchenAdapter.KitchenAdapterListener{


    @Inject
    lateinit var mVocabularyKitchenViewModel: VocabularyKitchenViewModel

    @Inject
    lateinit var mVocabularyKitchenAdapter: VocabularyKitchenAdapter
    lateinit var mVocabularyKitchenBinding: VocabularyKitchenBinding


    override val viewModel: VocabularyKitchenViewModel
        get() = mVocabularyKitchenViewModel



    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.vocabulary_kitchen

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        mVocabularyKitchenAdapter.setListener(this)
        mVocabularyKitchenViewModel.fetchKitchen()

        mVocabularyKitchenBinding = viewDataBinding!!
        setUp()
        subscribeToLiveData()

        val backBtn = findViewById<EditText>(R.id.backbtn) as Button
        val titileName = findViewById<EditText>(R.id.title_name_tv) as TextView
        titileName.text = "Kitchen"

        backBtn.setOnClickListener() {
            val intent = Intent(this, VocabularyActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun subscribeToLiveData()
    {
        mVocabularyKitchenViewModel.getKitchenListLiveData().observe(this, Observer { t ->
            mVocabularyKitchenViewModel.addKitchenItemToList(t)
            updateKitchen(t)
        })
    }

    fun setUp()
    {
        mVocabularyKitchenBinding.kitchenRv.itemAnimator = DefaultItemAnimator()
        mVocabularyKitchenBinding.kitchenRv.adapter = mVocabularyKitchenAdapter

    }

    fun updateKitchen(KitchenDataList: List<GeetingCoreData>?)
    {
        mVocabularyKitchenAdapter.clearItems()
        if(!KitchenDataList.isNullOrEmpty())
        {
            mVocabularyKitchenAdapter.addItem(KitchenDataList)
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, VocabularyKitchenActivity::class.java)
        }
    }
}