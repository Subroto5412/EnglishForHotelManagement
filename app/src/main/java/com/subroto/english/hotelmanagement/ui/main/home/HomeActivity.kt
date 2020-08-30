package com.subroto.english.hotelmanagement.ui.main.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.library.baseAdapters.BR
import com.subroto.english.hotelmanagement.R
import com.subroto.english.hotelmanagement.databinding.HomeBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.ConversationActivity
import com.subroto.english.hotelmanagement.ui.main.quiz.QuizActivity
import com.subroto.english.hotelmanagement.ui.main.quiz.quiz_progress.ProgressResultActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.SentenceActivity
import com.subroto.english.hotelmanagement.ui.main.vocabulary.VocabularyActivity
import com.subroto.english.hotelmanagement.ui.main.vocabulary.geeting.GeetingActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class HomeActivity  : BaseActivity<HomeBinding, HomeViewModel>(), IHomeNavigator,
    HasAndroidInjector {

    override val viewModel: HomeViewModel
        get() = mHomeViewModel

    @Inject
    lateinit var mHomeViewModel: HomeViewModel

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.home

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
    }

    override fun androidInjector(): AndroidInjector<Any>? {
        return fragmentDispatchingAndroidInjector
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }
    override fun openVocabularyActivity() {
        val intent = Intent(this, VocabularyActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun openSentenceActivity() {
        val intent = Intent(this, SentenceActivity::class.java)
        startActivity(intent)
        finish()
    }
    override fun openConversationActivity() {
        val intent = Intent(this, ConversationActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun openQuizActivity() {
        val intent = Intent(this, QuizActivity::class.java)
        startActivity(intent)
        finish()
    }
    override fun openProgressActivity() {
        val intent = Intent(this, ProgressResultActivity::class.java)
        startActivity(intent)
        finish()
    }}