package com.example.turkcell.util

import android.animation.Animator
import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.content.Context
import android.util.TypedValue
import android.view.View
import androidx.annotation.AttrRes

fun animateBackgroundColorChange(
    v: View?,
    toColor: Int,
    fromColor: Int,
    duration: Long
): Animator? {
    val colorFade: ObjectAnimator =
        ObjectAnimator.ofObject(v, "backgroundColor", ArgbEvaluator(), fromColor, toColor)
    colorFade.duration = duration
    colorFade.start()
    return colorFade
}

fun Context.getColorFromAttr(
    @AttrRes attrColor: Int,
    typedValue: TypedValue = TypedValue(),
    resolveRefs: Boolean = true
): Int {
    theme.resolveAttribute(attrColor, typedValue, resolveRefs)
    return typedValue.data
}
