package com.subroto.english.hotelmanagement.ui.main.sentence

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.library.baseAdapters.BR
import com.subroto.english.hotelmanagement.R
import com.subroto.english.hotelmanagement.databinding.SentenceBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.foods.ConversationFoodsActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.geetings.ConversationGeetingsActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.kitchen.ConversationKitchenActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.reception.ConversationReceptionActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.service.ConversationServiceActivity
import com.subroto.english.hotelmanagement.ui.main.home.HomeActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.foods.SentenceFoodsActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.geetings.SentenceGeetingsActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.kitchen.SentenceKitchenActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.reception.SentenceReceptionActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.service.SentenceServiceActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class SentenceActivity : BaseActivity<SentenceBinding, SentenceViewModel>(),
    ISentenceNavigator,
    HasAndroidInjector {

    override val viewModel: SentenceViewModel
        get() = mSentenceViewModel

    @Inject
    lateinit var mSentenceViewModel: SentenceViewModel

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.sentence

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        Log.e("---------","--------"+viewModel.dataManager.quizOneValue)
        val backBtn = findViewById<EditText>(R.id.backbtn) as Button
        val titileName = findViewById<EditText>(R.id.title_name_tv) as TextView
        titileName.text = "Sentence"

        backBtn.setOnClickListener() {
            val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun openGeetingsActivity() {
        var intent = Intent(this, SentenceGeetingsActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun openFoodsActivity() {
        var intent = Intent(this, SentenceFoodsActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun openServiceActivity() {
        var intent = Intent(this, SentenceServiceActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun openReceptionActivity() {
        var intent = Intent(this, SentenceReceptionActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun openKitchenActivity() {
        var intent = Intent(this, SentenceKitchenActivity::class.java)
        startActivity(intent)
        finish()
    }
    override fun androidInjector(): AndroidInjector<Any>? {
        return fragmentDispatchingAndroidInjector
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, SentenceActivity::class.java)
        }
    }
}