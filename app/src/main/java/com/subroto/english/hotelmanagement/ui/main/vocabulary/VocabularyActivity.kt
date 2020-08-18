package com.subroto.english.hotelmanagement.ui.main.vocabulary

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.databinding.library.baseAdapters.BR
import com.subroto.english.hotelmanagement.R
import com.subroto.english.hotelmanagement.databinding.VocabularyBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.home.HomeActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class VocabularyActivity  : BaseActivity<VocabularyBinding, VocabularyViewModel>(), IVocabularyNavigator,
    HasAndroidInjector {

    override val viewModel: VocabularyViewModel
        get() = mVocabularyViewModel

    @Inject
    lateinit var mVocabularyViewModel: VocabularyViewModel

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.vocabulary

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this

        val backBtn = findViewById<EditText>(R.id.backbtn) as Button
        backBtn.setOnClickListener() {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun androidInjector(): AndroidInjector<Any>? {
        return fragmentDispatchingAndroidInjector
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, VocabularyActivity::class.java)
        }
    }
}