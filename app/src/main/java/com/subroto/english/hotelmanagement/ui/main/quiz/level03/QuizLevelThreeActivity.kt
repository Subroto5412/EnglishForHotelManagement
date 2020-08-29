package com.subroto.english.hotelmanagement.ui.main.quiz.level03

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.core.content.ContextCompat
import com.subroto.english.hotelmanagement.BR
import com.subroto.english.hotelmanagement.R
import com.subroto.english.hotelmanagement.databinding.QuizLevelThreeBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.quiz.QuizActivity
import javax.inject.Inject

class QuizLevelThreeActivity : BaseActivity<QuizLevelThreeBinding, QuizLevelThreeViewModel>(),
    IQuizLevelThreeNavigator {

    @Inject
    lateinit var mQuizLevelThreeViewModel: QuizLevelThreeViewModel

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.quiz_level_three
    override val viewModel: QuizLevelThreeViewModel
        get() = mQuizLevelThreeViewModel

    lateinit var ansImgBtn1: ImageView
    lateinit var ansImgBtn2: ImageView
    lateinit var ansImgBtn3: ImageView
    lateinit var ansImgBtn4: ImageView
    lateinit var questionTv: TextView
    lateinit var scoreTv: TextView
    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this
        viewModel.fetchQuizLevelThree()
        setUp()
        val backBtn = findViewById<Button>(R.id.backbtn) as Button
        val titleName = findViewById<TextView>(R.id.title_name_tv) as TextView
        titleName.text = "Quiz Level 03"
        backBtn.setOnClickListener()
        {
            val intent = Intent(this, QuizActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, QuizLevelThreeActivity::class.java)
        }
    }

    @SuppressLint("NewApi")
    fun setUp() {
        ansImgBtn1 = findViewById(R.id.ans_img1)
        ansImgBtn2 = findViewById(R.id.ans_img2)
        ansImgBtn3 = findViewById(R.id.ans_img3)
        ansImgBtn4 = findViewById(R.id.ans_img4)
        questionTv = findViewById(R.id.question_tv)
        scoreTv = findViewById(R.id.score_tv)
        var progressBar = findViewById<ProgressBar>(R.id.progressBar) as ProgressBar

        var totalQuestion = viewModel.getQuizLevelThreeListLiveData().value!!.size
        scoreTv.setText("" + i + " out of " + totalQuestion)
        progressBar.setMax(100)
        progressBar.setProgress(i * 10, true)


        // val img = findViewById<ImageView>(R.id.question_img) as ImageView


        if (i < mQuizLevelThreeViewModel.getQuizLevelThreeListLiveData().value!!.get(totalQuestion - 1).id) {

            var correctAns =
                mQuizLevelThreeViewModel.getQuizLevelThreeListLiveData().value!!.get(i).correct_answer
            var id = mQuizLevelThreeViewModel.getQuizLevelThreeListLiveData().value!!.get(i).id

            ansImgBtn1.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    mQuizLevelThreeViewModel.getQuizLevelThreeListLiveData().value!!.get(i).answer1
                )
            );
            ansImgBtn2.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    mQuizLevelThreeViewModel.getQuizLevelThreeListLiveData().value!!.get(i).answer2
                )
            );
            ansImgBtn3.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    mQuizLevelThreeViewModel.getQuizLevelThreeListLiveData().value!!.get(i).answer3
                )
            );
            ansImgBtn4.setImageDrawable(
                ContextCompat.getDrawable(
                    this,
                    mQuizLevelThreeViewModel.getQuizLevelThreeListLiveData().value!!.get(i).answer4
                )
            );

            ansImgBtn1.setOnClickListener() {
                if (correctAns == "1") {
                    Toast.makeText(this, "Answer is Correct", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Answer is not Correct", Toast.LENGTH_LONG).show()
                }
                i = i + 1
                setUp()
            }

            ansImgBtn2.setOnClickListener() {
                if (correctAns == "2") {
                    Toast.makeText(this, "Answer is Correct", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Answer is not Correct", Toast.LENGTH_LONG).show()
                }
                i = i + 1
                setUp()
            }

            ansImgBtn3.setOnClickListener() {
                if (correctAns == "3") {
                    Toast.makeText(this, "Answer is Correct", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Answer is not Correct", Toast.LENGTH_LONG).show()
                }
                i = i + 1
                setUp()
            }
            ansImgBtn4.setOnClickListener() {
                if (correctAns == "4") {
                    Toast.makeText(this, "Answer is Correct", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Answer is not Correct", Toast.LENGTH_LONG).show()
                }
                i = i + 1
                setUp()
            }
            mQuizLevelThreeViewModel.dataManager.quizThreeValue = id.toString()
        } else {
            ansImgBtn1.isEnabled = false
            ansImgBtn2.isEnabled = false
            ansImgBtn3.isEnabled = false
            ansImgBtn4.isEnabled = false
        }
    }
}