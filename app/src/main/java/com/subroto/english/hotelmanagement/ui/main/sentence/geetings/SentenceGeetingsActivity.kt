package com.subroto.english.hotelmanagement.ui.main.sentence.geetings

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
import com.subroto.english.hotelmanagement.databinding.SentenceGeetingsBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.SentenceActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.geetings.SentenceGeetingsAdapter
import com.subroto.english.hotelmanagement.ui.main.sentence.geetings.SentenceGeetingsViewModel
import com.subroto.english.hotelmanagement.ui.main.sentence.geetings.ISentenceGeetingsNavigator
import javax.inject.Inject

class SentenceGeetingsActivity  : BaseActivity<SentenceGeetingsBinding, SentenceGeetingsViewModel>(),
    ISentenceGeetingsNavigator, SentenceGeetingsAdapter.GeetingsAdapterListener{


    @Inject
    lateinit var mSentenceGeetingsViewModel: SentenceGeetingsViewModel

    @Inject
    lateinit var mSentenceGeetingsAdapter: SentenceGeetingsAdapter
    lateinit var mSentenceFoodBinding: SentenceGeetingsBinding

    override val viewModel: SentenceGeetingsViewModel
        get() = mSentenceGeetingsViewModel

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.sentence_geetings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        mSentenceGeetingsAdapter.setListener(this)
        mSentenceGeetingsViewModel.fetchGeetings()

        mSentenceFoodBinding = viewDataBinding!!
        setUp()
        subscribeToLiveData()

        val backBtn = findViewById<EditText>(R.id.backbtn) as Button
        val titileName = findViewById<EditText>(R.id.title_name_tv) as TextView
        titileName.text = "Geetings"

        backBtn.setOnClickListener() {
            val intent = Intent(this, SentenceActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun subscribeToLiveData()
    {
        mSentenceGeetingsViewModel.getGeetingsListLiveData().observe(this, Observer { t ->
            mSentenceGeetingsViewModel.addGeetingsItemToList(t)
            updateGeetings(t)
        })
    }

    fun setUp()
    {
        mSentenceFoodBinding.geetingsRv.itemAnimator = DefaultItemAnimator()
        mSentenceFoodBinding.geetingsRv.adapter = mSentenceGeetingsAdapter
    }

    fun updateGeetings(GeetingsDataList: List<GeetingCoreData>?)
    {
        mSentenceGeetingsAdapter.clearItems()
        if(!GeetingsDataList.isNullOrEmpty())
        {
            mSentenceGeetingsAdapter.addItem(GeetingsDataList)
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SentenceGeetingsActivity::class.java)
        }
    }
}