package com.subroto.english.hotelmanagement.ui.main.sentence.reception

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
import com.subroto.english.hotelmanagement.databinding.SentenceReceptionBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.SentenceActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.reception.SentenceReceptionAdapter
import com.subroto.english.hotelmanagement.ui.main.sentence.reception.SentenceReceptionViewModel
import com.subroto.english.hotelmanagement.ui.main.sentence.reception.ISentenceReceptionNavigator
import javax.inject.Inject

class SentenceReceptionActivity  : BaseActivity<SentenceReceptionBinding, SentenceReceptionViewModel>(),
    ISentenceReceptionNavigator, SentenceReceptionAdapter.ReceptionAdapterListener{

    @Inject
    lateinit var mSentenceReceptionViewModel: SentenceReceptionViewModel

    @Inject
    lateinit var mSentenceReceptionAdapter: SentenceReceptionAdapter
    lateinit var mSentenceReceptionBinding: SentenceReceptionBinding

    override val viewModel: SentenceReceptionViewModel
        get() = mSentenceReceptionViewModel

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.sentence_reception

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        mSentenceReceptionAdapter.setListener(this)
        mSentenceReceptionViewModel.fetchReception()

        mSentenceReceptionBinding = viewDataBinding!!
        setUp()
        subscribeToLiveData()

        val backBtn = findViewById<EditText>(R.id.backbtn) as Button
        val titileName = findViewById<EditText>(R.id.title_name_tv) as TextView
        titileName.text = "Reception"

        backBtn.setOnClickListener() {
            val intent = Intent(this, SentenceActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun subscribeToLiveData()
    {
        mSentenceReceptionViewModel.getReceptionListLiveData().observe(this, Observer { t ->
            mSentenceReceptionViewModel.addReceptionItemToList(t)
            updateReception(t)
        })
    }

    fun setUp()
    {
        mSentenceReceptionBinding.receptionRv.itemAnimator = DefaultItemAnimator()
        mSentenceReceptionBinding.receptionRv.adapter = mSentenceReceptionAdapter

    }

    fun updateReception(ReceptionDataList: List<GeetingCoreData>?)
    {
        mSentenceReceptionAdapter.clearItems()
        if(!ReceptionDataList.isNullOrEmpty())
        {
            mSentenceReceptionAdapter.addItem(ReceptionDataList)
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SentenceReceptionActivity::class.java)
        }
    }
}