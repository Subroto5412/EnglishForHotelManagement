package com.subroto.english.hotelmanagement.ui.main.quiz.level02

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.core.content.ContextCompat
import com.subroto.english.hotelmanagement.BR
import com.subroto.english.hotelmanagement.R
import com.subroto.english.hotelmanagement.databinding.QuizLevelTwoBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.quiz.QuizActivity
import javax.inject.Inject

class QuizLevelTwoActivity : BaseActivity<QuizLevelTwoBinding, QuizLevelTwoViewModel>(),
    IQuizLevelTwoNavigator {

    @Inject
    lateinit var mQuizLevelTwoViewModel: QuizLevelTwoViewModel

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.quiz_level_two
    override val viewModel: QuizLevelTwoViewModel
        get() = mQuizLevelTwoViewModel

    lateinit var ansBtn1: Button
    lateinit var ansBtn2: Button
    lateinit var ansBtn3: Button
    lateinit var ansBtn4: Button
    lateinit var questionTv: TextView
    lateinit var scoreTv: TextView
    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        viewModel.fetchQuizLevelTwo()
        setUp()
        val backBtn = findViewById<Button>(R.id.backbtn) as Button
        val titleName = findViewById<TextView>(R.id.title_name_tv) as TextView
        titleName.text = "Quiz Level 02"
        backBtn.setOnClickListener()
        {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, QuizLevelTwoActivity::class.java)
        }
    }

    @SuppressLint("NewApi")
    fun setUp() {
        ansBtn1 = findViewById(R.id.button1)
        ansBtn2 = findViewById(R.id.button2)
        ansBtn3 = findViewById(R.id.button3)
        ansBtn4 = findViewById(R.id.button4)
        questionTv = findViewById(R.id.question_tv)
        scoreTv = findViewById(R.id.score_tv)
        var progressBar = findViewById<ProgressBar>(R.id.progressBar) as ProgressBar
        val img = findViewById<ImageView>(R.id.question_im) as ImageView

        var totalQuestion = viewModel.getQuizLevelTwoListLiveData().value!!.size
        scoreTv.setText("" + i + " out of " + totalQuestion)
        progressBar.setMax(100)
        progressBar.setProgress(i * 10, true)

        if (i < mQuizLevelTwoViewModel.getQuizLevelTwoListLiveData().value!!.get(totalQuestion - 1).id) {

            ansBtn1.setText(mQuizLevelTwoViewModel.getQuizLevelTwoListLiveData().value!!.get(i).answer1)
            ansBtn2.setText(mQuizLevelTwoViewModel.getQuizLevelTwoListLiveData().value!!.get(i).answer2)
            ansBtn3.setText(mQuizLevelTwoViewModel.getQuizLevelTwoListLiveData().value!!.get(i).answer3)
            ansBtn4.setText(mQuizLevelTwoViewModel.getQuizLevelTwoListLiveData().value!!.get(i).answer4)
            questionTv.setText(mQuizLevelTwoViewModel.getQuizLevelTwoListLiveData().value!!.get(i).question)
            img.setImageDrawable(ContextCompat.getDrawable(this, mQuizLevelTwoViewModel.getQuizLevelTwoListLiveData().value!!.get(i).photo));

            var correctAns =
                mQuizLevelTwoViewModel.getQuizLevelTwoListLiveData().value!!.get(i).correct_answer
            var id = mQuizLevelTwoViewModel.getQuizLevelTwoListLiveData().value!!.get(i).id

            ansBtn1.setOnClickListener() {
                if (correctAns == "1") {
                    Toast.makeText(this, "Answer is Correct", Toast.LENGTH_LONG).show()
                    mQuizLevelTwoViewModel.dataManager.quizTwoValue = id.toString()
                } else {
                    Toast.makeText(this, "Answer is not Correct", Toast.LENGTH_LONG).show()
                }
                i = i + 1
                setUp()
            }

            ansBtn2.setOnClickListener() {
                if (correctAns == "2") {
                    Toast.makeText(this, "Answer is Correct", Toast.LENGTH_LONG).show()
                    mQuizLevelTwoViewModel.dataManager.quizTwoValue = id.toString()
                } else {
                    Toast.makeText(this, "Answer is not Correct", Toast.LENGTH_LONG).show()
                }
                i = i + 1
                setUp()
            }

            ansBtn3.setOnClickListener() {
                if (correctAns == "3") {
                    Toast.makeText(this, "Answer is Correct", Toast.LENGTH_LONG).show()
                    mQuizLevelTwoViewModel.dataManager.quizTwoValue = id.toString()
                } else {
                    Toast.makeText(this, "Answer is not Correct", Toast.LENGTH_LONG).show()
                }
                i = i + 1
                setUp()
            }
            ansBtn4.setOnClickListener() {
                if (correctAns == "4") {
                    Toast.makeText(this, "Answer is Correct", Toast.LENGTH_LONG).show()
                    mQuizLevelTwoViewModel.dataManager.quizTwoValue = id.toString()
                } else {
                    Toast.makeText(this, "Answer is not Correct", Toast.LENGTH_LONG).show()
                }
                i = i + 1
                setUp()
            }

        } else {
            ansBtn1.isEnabled = false
            ansBtn2.isEnabled = false
            ansBtn3.isEnabled = false
            ansBtn4.isEnabled = false
        }
    }
}