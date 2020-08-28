package com.subroto.english.hotelmanagement.ui.main.quiz.about_quiz

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.databinding.library.baseAdapters.BR
import com.subroto.english.hotelmanagement.R
import com.subroto.english.hotelmanagement.databinding.DialogAboutQuizBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.quiz.QuizActivity
import javax.inject.Inject

class AboutQuizDialog : BaseActivity<DialogAboutQuizBinding, AboutQuizDialogViewModel>(),IAboutQuizCallback {
    @Inject
    lateinit var mAboutQuizDialogViewModel : AboutQuizDialogViewModel

    override val bindingVariable: Int
        get() = BR.viewModel
    override val layoutId: Int
        get() = R.layout.dialog_about_quiz
    override val viewModel: AboutQuizDialogViewModel
        get() = mAboutQuizDialogViewModel

    override fun onCreate(saveInstanceState : Bundle?)
    {
        super.onCreate(saveInstanceState)
        viewModel.navigator  = this

        val closeBtn = findViewById<Button>(R.id.dialog_close_button)

        closeBtn.setOnClickListener() {
            finish()
        }

    }

    companion object{
        fun newInent(context: Context) : Intent
        {
            return Intent(context,AboutQuizDialog::class.java)
        }
    }
}