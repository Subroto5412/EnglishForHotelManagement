package com.subroto.english.hotelmanagement.ui.main.quiz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.subroto.english.hotelmanagement.BR
import com.subroto.english.hotelmanagement.R
import com.subroto.english.hotelmanagement.databinding.QuizBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.home.HomeActivity
import javax.inject.Inject

class QuizActivity : BaseActivity<QuizBinding, QuizViewModel>(), IQuizNavigator{

    @Inject
    lateinit var mQuizViewModel : QuizViewModel

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.quiz
    override val viewModel: QuizViewModel
        get() = mQuizViewModel


    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this

        val backBtn = findViewById<Button>(R.id.backbtn) as Button
        val titleName = findViewById<TextView>(R.id.title_name_tv) as TextView
        titleName.text = "Quiz"
        backBtn.setOnClickListener()
        {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
    override fun openQuizRules() {
    }

    override fun openQuizLevel01() {
    }

    override fun openQuizLevel02() {
    }

    override fun openQuizLevel03() {
    }

    override fun openQuizLevel04() {
    }

    companion object{
        fun  newIntent(context: Context) : Intent
        {
            return Intent(context,QuizActivity::class.java)
        }
    }
}