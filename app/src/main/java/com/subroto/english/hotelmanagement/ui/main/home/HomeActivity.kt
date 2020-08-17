package com.subroto.english.hotelmanagement.ui.main.home

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.databinding.library.baseAdapters.BR
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.subroto.english.hotelmanagement.R
import com.subroto.english.hotelmanagement.databinding.HomeBinding
import com.subroto.english.hotelmanagement.ui.base.BaseActivity
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
}