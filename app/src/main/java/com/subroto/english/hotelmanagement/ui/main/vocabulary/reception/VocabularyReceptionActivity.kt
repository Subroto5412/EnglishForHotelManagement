package com.subroto.english.hotelmanagement.ui.main.vocabulary.reception

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
import com.subroto.english.hotelmanagement.databinding.VocabularyReceptionBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.vocabulary.VocabularyActivity
import javax.inject.Inject

class VocabularyReceptionActivity  : BaseActivity<VocabularyReceptionBinding, VocabularyReceptionViewModel>(),
    IVocabularyReceptionNavigator, VocabularyReceptionAdapter.ReceptionAdapterListener{


    @Inject
    lateinit var mVocabularyReceptionViewModel: VocabularyReceptionViewModel

    @Inject
    lateinit var mVocabularyReceptionAdapter: VocabularyReceptionAdapter
    lateinit var mVocabularyReceptionBinding: VocabularyReceptionBinding


    override val viewModel: VocabularyReceptionViewModel
        get() = mVocabularyReceptionViewModel



    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.vocabulary_reception

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        mVocabularyReceptionAdapter.setListener(this)
        mVocabularyReceptionViewModel.fetchReception()

        mVocabularyReceptionBinding = viewDataBinding!!
        setUp()
        subscribeToLiveData()

        val backBtn = findViewById<EditText>(R.id.backbtn) as Button
        val titileName = findViewById<EditText>(R.id.title_name_tv) as TextView
        titileName.text = "Reception"

        backBtn.setOnClickListener() {
            val intent = Intent(this, VocabularyActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun subscribeToLiveData()
    {
        mVocabularyReceptionViewModel.getReceptionListLiveData().observe(this, Observer { t ->
            mVocabularyReceptionViewModel.addReceptionItemToList(t)
            updateReception(t)
        })
    }

    fun setUp()
    {
        mVocabularyReceptionBinding.receptionRv.itemAnimator = DefaultItemAnimator()
        mVocabularyReceptionBinding.receptionRv.adapter = mVocabularyReceptionAdapter

    }

    fun updateReception(ReceptionDataList: List<GeetingCoreData>?)
    {
        mVocabularyReceptionAdapter.clearItems()
        if(!ReceptionDataList.isNullOrEmpty())
        {
            mVocabularyReceptionAdapter.addItem(ReceptionDataList)
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, VocabularyReceptionActivity::class.java)
        }
    }
}