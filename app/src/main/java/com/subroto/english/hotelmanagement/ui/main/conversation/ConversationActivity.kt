package com.subroto.english.hotelmanagement.ui.main.conversation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.library.baseAdapters.BR
import com.subroto.english.hotelmanagement.R
import com.subroto.english.hotelmanagement.databinding.ConversationBinding
import com.subroto.english.hotelmanagement.databinding.SentenceBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.foods.ConversationFoodsActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.geetings.ConversationGeetingsActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.kitchen.ConversationKitchenActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.reception.ConversationReceptionActivity
import com.subroto.english.hotelmanagement.ui.main.conversation.service.ConversationServiceActivity
import com.subroto.english.hotelmanagement.ui.main.home.HomeActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.ISentenceNavigator
import com.subroto.english.hotelmanagement.ui.main.sentence.SentenceActivity
import com.subroto.english.hotelmanagement.ui.main.sentence.SentenceViewModel
import com.subroto.english.hotelmanagement.ui.main.vocabulary.geeting.GeetingActivity
import com.subroto.english.hotelmanagement.ui.main.vocabulary.kitchen.VocabularyKitchenActivity
import com.subroto.english.hotelmanagement.ui.main.vocabulary.reception.VocabularyReceptionActivity
import com.subroto.english.hotelmanagement.ui.main.vocabulary.service.VocabularyServiceActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class ConversationActivity : BaseActivity<ConversationBinding, ConversationViewModel>(),
    IConversationNavigator,
    HasAndroidInjector {

    override val viewModel: ConversationViewModel
        get() = mConversationViewModel

    @Inject
    lateinit var mConversationViewModel: ConversationViewModel

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.conversation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this

        val backBtn = findViewById<EditText>(R.id.backbtn) as Button
        val titileName = findViewById<EditText>(R.id.title_name_tv) as TextView
        titileName.text = "Conversation"

        backBtn.setOnClickListener() {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun openGeetingsActivity() {
        var intent = Intent(this, ConversationGeetingsActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun openFoodsActivity() {
        var intent = Intent(this, ConversationFoodsActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun openServiceActivity() {
        var intent = Intent(this, ConversationServiceActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun openReceptionActivity() {
        var intent = Intent(this, ConversationReceptionActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun openKitchenActivity() {
        var intent = Intent(this, ConversationKitchenActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun androidInjector(): AndroidInjector<Any>? {
        return fragmentDispatchingAndroidInjector
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ConversationActivity::class.java)
        }
    }
}