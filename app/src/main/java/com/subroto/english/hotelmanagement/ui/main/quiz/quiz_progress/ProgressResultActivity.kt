package com.subroto.english.hotelmanagement.ui.main.quiz.quiz_progress

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.subroto.english.hotelmanagement.BR
import com.subroto.english.hotelmanagement.R
import com.subroto.english.hotelmanagement.databinding.ProgressBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.quiz.QuizActivity
import javax.inject.Inject

class ProgressResultActivity : BaseActivity<ProgressBinding, ProgressResultViewModel>(),
    IProgressResultNavigator {

    @Inject
    lateinit var mProgressResultViewModel: ProgressResultViewModel

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.progress
    override val viewModel: ProgressResultViewModel
        get() = mProgressResultViewModel


    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        var vocabularyProgressBar =
            findViewById<ProgressBar>(R.id.vocabulary_progressBar) as ProgressBar
        var vocabularyPercent = findViewById<TextView>(R.id.vocabulary_percent_tv) as TextView

        var sentenceProgressBar =
            findViewById<ProgressBar>(R.id.sentence_progressBar) as ProgressBar
        var sentencePercent = findViewById<TextView>(R.id.sentence_percent_tv) as TextView

        var conversationProgressBar =
            findViewById<ProgressBar>(R.id.conversation_progressBar) as ProgressBar
        var conversationPercent = findViewById<TextView>(R.id.conversation_percent_tv) as TextView

        vocabularyProgressBar.setMax(100)
        sentenceProgressBar.setMax(100)
        conversationProgressBar.setMax(100)

        vocabularyProgressBar.setProgress((viewModel.dataManager.quizOneValue).toInt() * 10, true)
        sentenceProgressBar.setProgress((viewModel.dataManager.quizTwoValue).toInt() * 10, true)
        conversationProgressBar.setProgress(
            (viewModel.dataManager.quizThreeValue).toInt() * 10,
            true
        )

        vocabularyPercent.setText(viewModel.dataManager.quizOneValue + "%")
        sentencePercent.setText(viewModel.dataManager.quizTwoValue + "%")
        conversationPercent.setText(viewModel.dataManager.quizThreeValue + "%")

        val backBtn = findViewById<Button>(R.id.backbtn) as Button
        val titleName = findViewById<TextView>(R.id.title_name_tv) as TextView
        titleName.text = "Progress"
        backBtn.setOnClickListener()
        {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, ProgressResultActivity::class.java)
        }
    }
}