package com.izharuddin1997.trinitywizard.ui.splashscreen

import android.os.Handler
import com.izharuddin1997.trinitywizard.R
import com.izharuddin1997.trinitywizard.core.base.BaseFragment
import com.izharuddin1997.trinitywizard.databinding.FragmentSplashscreenBinding
import com.izharuddin1997.trinitywizard.utils.navigateToUri
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashScreenFragment :
    BaseFragment<FragmentSplashscreenBinding>(FragmentSplashscreenBinding::inflate) {

    override fun onCreated() {
        Handler().postDelayed({
            navigateToUri(R.string.home_route)
        }, delayMilis)
    }

    companion object {
        const val delayMilis: Long = 3000
    }
}
