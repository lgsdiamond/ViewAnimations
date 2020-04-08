package com.daimajia.androidanimations.library.specials.out

import android.animation.ObjectAnimator
import android.view.View
import com.daimajia.androidanimations.library.BaseViewAnimator
import com.daimajia.easing.Glider
import com.daimajia.easing.Skill

class TakingOffAnimator : BaseViewAnimator() {
    override fun prepare(target: View) {
        animatorAgent.playTogether(
            Glider.glide(Skill.QuintEaseOut, duration.toFloat(), ObjectAnimator.ofFloat(target, "scaleX", 1f, 1.5f)),
            Glider.glide(Skill.QuintEaseOut, duration.toFloat(), ObjectAnimator.ofFloat(target, "scaleY", 1f, 1.5f)),
            Glider.glide(Skill.QuintEaseOut, duration.toFloat(), ObjectAnimator.ofFloat(target, "alpha", 1f, 0f))
        )
    }
}