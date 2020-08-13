package com.subroto.english.hotelmanagement.ui.main.splash

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.databinding.library.baseAdapters.BR
import com.subroto.english.hotelmanagement.R
import com.subroto.english.hotelmanagement.databinding.SplashBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
import com.subroto.english.hotelmanagement.ui.main.slider.MainActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject


class SplashActivity : BaseActivity<SplashBinding, SplashViewModel>(), ISplashNavigator,
    HasAndroidInjector {

    override val viewModel: SplashViewModel
        get() = mSplashViewModel

    @Inject
    lateinit var mSplashViewModel: SplashViewModel

    @Inject
    lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.splash

    override fun openMainActivity() {
        // val intent = MainActivity.newIntent(this@SplashActivity)
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.navigator = this

        Handler().postDelayed(
            Runnable
            // Using handler with postDelayed called runnable run method
            {
                mSplashViewModel.startSeeding();

                // close this activity
                finish()
            }, 3 * 1000
        ) // wait for 3 seconds
//        viewModel.startSeeding() // After Login
    }

    override fun androidInjector(): AndroidInjector<Any>? {
        return fragmentDispatchingAndroidInjector
    }

    companion object {

        fun newIntent(context: Context): Intent {
            return Intent(context, SplashActivity::class.java)
        }
    }

}