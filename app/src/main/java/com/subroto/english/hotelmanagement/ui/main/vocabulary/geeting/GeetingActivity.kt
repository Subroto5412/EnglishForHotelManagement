package com.subroto.english.hotelmanagement.ui.main.vocabulary.geeting

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
import com.subroto.english.hotelmanagement.databinding.GeetingBinding
import com.subroto.english.hotelmanagement.databinding.VocabularyBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.home.HomeActivity
import com.subroto.english.hotelmanagement.ui.main.vocabulary.IVocabularyNavigator
import com.subroto.english.hotelmanagement.ui.main.vocabulary.VocabularyActivity
import com.subroto.english.hotelmanagement.ui.main.vocabulary.VocabularyViewModel
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class GeetingActivity : BaseActivity<GeetingBinding, GeetingViewModel>(),
    IGeetingNavigator, GeetingAdapter.GeetingAdapterListener{


    @Inject
    lateinit var mGeetingViewModel: GeetingViewModel

  //  @Inject
   // lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var mGeetingAdapter: GeetingAdapter
    lateinit var mGeetingBinding: GeetingBinding


    override val viewModel: GeetingViewModel
        get() = mGeetingViewModel



    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.geeting

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        mGeetingAdapter.setListener(this)
        mGeetingViewModel.fetchGeetingData()

        mGeetingBinding = viewDataBinding!!
        setUp()
        subscribeToLiveData()

        val backBtn = findViewById<EditText>(R.id.backbtn) as Button
        val titileName = findViewById<EditText>(R.id.title_name_tv) as TextView
        titileName.text = "Geetings"

        backBtn.setOnClickListener() {
            val intent = Intent(this, VocabularyActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun subscribeToLiveData()
    {
        mGeetingViewModel.getGeetingListLiveData().observe(this, Observer { t ->
            mGeetingViewModel.addGeetingItemToList(t)
            updateGeeting(t)
        })
    }

    fun setUp()
    {
        mGeetingBinding.geetingsRv.itemAnimator = DefaultItemAnimator()
        mGeetingBinding.geetingsRv.adapter = mGeetingAdapter
    }

    fun updateGeeting(geetingDataList: List<GeetingCoreData>?)
    {
        mGeetingAdapter.clearItems()
        if(!geetingDataList.isNullOrEmpty())
        {
            mGeetingAdapter.addItems(geetingDataList)
        }
    }

    // fun androidInjector(): AndroidInjector<Any>? {
     //   return dispatchingAndroidInjector
   // }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, VocabularyActivity::class.java)
        }
    }
}