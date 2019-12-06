package com.example.turkcell

import android.content.Intent
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.animation.doOnEnd
import androidx.core.view.doOnPreDraw
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.turkcell.databinding.ActivitySplashBinding
import com.example.turkcell.util.animateBackgroundColorChange
import com.example.turkcell.util.getColorFromAttr
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {

    private var fadeIn = false
    lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash)

        if (savedInstanceState == null) {
            fadeIn = true
        }
        binding.root.doOnPreDraw {
            lifecycleScope.launchWhenResumed {
                beginAnimation()
            }
        }
        binding.root.systemUiVisibility =
            (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
    }

    private fun beginAnimation() {
        animateBackgroundColorChange(
            binding.view,
            getColorFromAttr(R.attr.colorOnPrimary),
            getColorFromAttr(R.attr.myBackgroundColor),
            DURATION_ANIMATION
        )?.doOnEnd {
            TransitionManager.beginDelayedTransition(binding.root as ViewGroup)
            binding.tvLogo.visibility = View.VISIBLE
        }

        lifecycleScope.launch {
            delay(DELAY_BEFORE_FINISH_ACTIVITY)
            finish()
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
        }
    }

    override fun onPostResume() {
        super.onPostResume()
        if (fadeIn) {
            window.decorView.run {
                alpha = 0f
                animate().cancel()
                animate().alpha(1f).duration = DURATION_ANIMATION
            }
            fadeIn = false
        }
    }

    companion object {
        const val DELAY_BEFORE_FINISH_ACTIVITY = 2000L
        const val DURATION_ANIMATION = DELAY_BEFORE_FINISH_ACTIVITY / 2
    }
}
