package com.example.turkcell

import android.content.Intent
import android.graphics.Color
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

    private fun beginAnimation() {
        animateBackgroundColorChange(
            binding.view,
            getColorFromAttr(R.attr.colorOnPrimary),
            getColorFromAttr(R.attr.myBackgroundColor),
            DURATION_ANIMATION
        )?.doOnEnd {
            window.decorView.setBackgroundColor(Color.WHITE)
            TransitionManager.beginDelayedTransition(binding.root as ViewGroup)
            binding.tvLogo.visibility = View.VISIBLE
        }

        lifecycleScope.launch {
            delay(DELAY_BEFORE_FINISH_ACTIVITY)
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        }
    }

    companion object {
        const val DELAY_BEFORE_FINISH_ACTIVITY = 2000L
        const val DURATION_ANIMATION = DELAY_BEFORE_FINISH_ACTIVITY / 2
    }
}
