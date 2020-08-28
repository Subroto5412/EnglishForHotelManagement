package com.subroto.english.hotelmanagement.ui.main.quiz.level01

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.subroto.english.hotelmanagement.BR
import com.subroto.english.hotelmanagement.R
import com.subroto.english.hotelmanagement.databinding.QuizBinding
import com.subroto.english.hotelmanagement.databinding.QuizLevelOneBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.home.HomeActivity
import com.subroto.english.hotelmanagement.ui.main.quiz.IQuizNavigator
import com.subroto.english.hotelmanagement.ui.main.quiz.QuizActivity
import com.subroto.english.hotelmanagement.ui.main.quiz.QuizViewModel
import javax.inject.Inject

class QuizLevelOneActivity  : BaseActivity<QuizLevelOneBinding, QuizLevelOneViewModel>(), IQuizLevelOneNavigator {

    @Inject
    lateinit var mQuizLevelOneViewModel: QuizLevelOneViewModel

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.quiz_level_one
    override val viewModel: QuizLevelOneViewModel
        get() = mQuizLevelOneViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this

        val backBtn = findViewById<Button>(R.id.backbtn) as Button
        val titleName = findViewById<TextView>(R.id.title_name_tv) as TextView
        titleName.text = "Level 01"
        backBtn.setOnClickListener()
        {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, QuizLevelOneActivity::class.java)
        }
    }
}