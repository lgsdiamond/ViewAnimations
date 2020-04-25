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
package com.daimajia.androidanimations.library

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ValueAnimator
import android.view.View
import android.view.animation.Interpolator
import androidx.core.view.ViewCompat

abstract class BaseViewAnimator {
    var animatorAgent: AnimatorSet
    var duration = DURATION
    private var mRepeatTimes = 0
    private var mRepeatMode = ValueAnimator.RESTART
    protected abstract fun prepare(target: View)
    fun setTarget(target: View): BaseViewAnimator {
        reset(target)
        prepare(target)
        return this
    }

    fun animate() {
        start()
    }

    fun restart() {
        animatorAgent = animatorAgent.clone()
        start()
    }

    /**
     * reset the view to default status
     *
     * @param target
     */
    fun reset(target: View?) {
        ViewCompat.setAlpha(target, 1f)
        ViewCompat.setScaleX(target, 1f)
        ViewCompat.setScaleY(target, 1f)
        ViewCompat.setTranslationX(target, 0f)
        ViewCompat.setTranslationY(target, 0f)
        ViewCompat.setRotation(target, 0f)
        ViewCompat.setRotationY(target, 0f)
        ViewCompat.setRotationX(target, 0f)
    }

    /**
     * start to animate
     */
    fun start() {
        for (animator in animatorAgent.childAnimations) {
            if (animator is ValueAnimator) {
                animator.repeatCount = mRepeatTimes
                animator.repeatMode = mRepeatMode
            }
        }
        animatorAgent.duration = duration
        animatorAgent.start()
    }

    var startDelay: Long
        get() = animatorAgent.startDelay
        set(value) {
            animatorAgent.startDelay = value
        }

    fun setStartDelay(delay: Long): BaseViewAnimator {
        animatorAgent.startDelay = delay
        return this
    }

    fun addAnimatorListener(l: Animator.AnimatorListener?): BaseViewAnimator {
        animatorAgent.addListener(l)
        return this
    }

    fun cancel() {
        animatorAgent.cancel()
    }

    val isRunning: Boolean
        get() = animatorAgent.isRunning

    val isStarted: Boolean
        get() = animatorAgent.isStarted

    fun removeAnimatorListener(l: Animator.AnimatorListener?) {
        animatorAgent.removeListener(l)
    }

    fun removeAllListener() {
        animatorAgent.removeAllListeners()
    }

    fun setInterpolator(interpolator: Interpolator?): BaseViewAnimator {
        animatorAgent.interpolator = interpolator
        return this
    }

    fun setDuration(duration: Long): BaseViewAnimator {
        this.duration = duration
        return this
    }

    fun setRepeatTimes(repeatTimes: Int): BaseViewAnimator {
        mRepeatTimes = repeatTimes
        return this
    }

    fun setRepeatMode(repeatMode: Int): BaseViewAnimator {
        mRepeatMode = repeatMode
        return this
    }

    companion object {
        const val DURATION: Long = 1000
    }

    init {
        animatorAgent = AnimatorSet()
    }
}