package com.daimajia.androidanimations.library.specials.`in`

import android.animation.ObjectAnimator
import android.view.View
import com.daimajia.androidanimations.library.BaseViewAnimator
import com.daimajia.easing.Glider
import com.daimajia.easing.Skill

class LandingAnimator : BaseViewAnimator() {
    override fun prepare(target: View?) {
        animatorAgent.playTogether(
            Glider.glide(Skill.QuintEaseOut, duration.toFloat(), ObjectAnimator.ofFloat(target, "scaleX", 1.5f, 1f)),
            Glider.glide(Skill.QuintEaseOut, duration.toFloat(), ObjectAnimator.ofFloat(target, "scaleY", 1.5f, 1f)),
            Glider.glide(Skill.QuintEaseOut, duration.toFloat(), ObjectAnimator.ofFloat(target, "alpha", 0f, 1f))
        )
    }
}