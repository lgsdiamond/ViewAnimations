/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 daimajia
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.daimajia.androidanimations.library.specials

import android.animation.ObjectAnimator
import android.view.View
import com.daimajia.androidanimations.library.BaseViewAnimator
import com.daimajia.easing.Glider
import com.daimajia.easing.Skill

class HingeAnimator : BaseViewAnimator() {
    override fun prepare(target: View?) {
        val x = target!!.paddingLeft.toFloat()
        val y = target.paddingTop.toFloat()
        animatorAgent.playTogether(
            Glider.glide(Skill.SineEaseInOut, 1300f, ObjectAnimator.ofFloat(target, "rotation", 0f, 80f, 60f, 80f, 60f, 60f)),
            ObjectAnimator.ofFloat(target, "translationY", 0f, 0f, 0f, 0f, 0f, 700f),
            ObjectAnimator.ofFloat(target, "alpha", 1f, 1f, 1f, 1f, 1f, 0f),
            ObjectAnimator.ofFloat(target, "pivotX", x, x, x, x, x, x),
            ObjectAnimator.ofFloat(target, "pivotY", y, y, y, y, y, y)
        )
        duration = 1300
    }
}