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

import com.daimajia.androidanimations.library.attention.*
import com.daimajia.androidanimations.library.bouncing_entrances.*
import com.daimajia.androidanimations.library.fading_entrances.*
import com.daimajia.androidanimations.library.fading_exits.*
import com.daimajia.androidanimations.library.flippers.FlipInXAnimator
import com.daimajia.androidanimations.library.flippers.FlipInYAnimator
import com.daimajia.androidanimations.library.flippers.FlipOutXAnimator
import com.daimajia.androidanimations.library.flippers.FlipOutYAnimator
import com.daimajia.androidanimations.library.rotating_entrances.*
import com.daimajia.androidanimations.library.rotating_exits.*
import com.daimajia.androidanimations.library.sliders.*
import com.daimajia.androidanimations.library.specials.HingeAnimator
import com.daimajia.androidanimations.library.specials.RollInAnimator
import com.daimajia.androidanimations.library.specials.RollOutAnimator
import com.daimajia.androidanimations.library.specials.`in`.DropOutAnimator
import com.daimajia.androidanimations.library.specials.`in`.LandingAnimator
import com.daimajia.androidanimations.library.specials.out.TakingOffAnimator
import com.daimajia.androidanimations.library.zooming_entrances.*
import com.daimajia.androidanimations.library.zooming_exits.*

enum class Techniques(private val animatorClazz: Class<*>) {
    DropOut(DropOutAnimator::class.java), Landing(LandingAnimator::class.java), TakingOff(TakingOffAnimator::class.java), Flash(FlashAnimator::class.java), Pulse(
        PulseAnimator::class.java
    ),
    RubberBand(RubberBandAnimator::class.java), Shake(ShakeAnimator::class.java), Swing(SwingAnimator::class.java), Wobble(
        WobbleAnimator::class.java
    ),
    Bounce(BounceAnimator::class.java), Tada(TadaAnimator::class.java), StandUp(StandUpAnimator::class.java), Wave(
        WaveAnimator::class.java
    ),
    Hinge(HingeAnimator::class.java), RollIn(RollInAnimator::class.java), RollOut(RollOutAnimator::class.java), BounceIn(
        BounceInAnimator::class.java
    ),
    BounceInDown(BounceInDownAnimator::class.java), BounceInLeft(BounceInLeftAnimator::class.java), BounceInRight(
        BounceInRightAnimator::class.java
    ),
    BounceInUp(BounceInUpAnimator::class.java), FadeIn(FadeInAnimator::class.java), FadeInUp(FadeInUpAnimator::class.java), FadeInDown(
        FadeInDownAnimator::class.java
    ),
    FadeInLeft(FadeInLeftAnimator::class.java), FadeInRight(FadeInRightAnimator::class.java), FadeOut(FadeOutAnimator::class.java), FadeOutDown(
        FadeOutDownAnimator::class.java
    ),
    FadeOutLeft(FadeOutLeftAnimator::class.java), FadeOutRight(FadeOutRightAnimator::class.java), FadeOutUp(
        FadeOutUpAnimator::class.java
    ),
    FlipInX(FlipInXAnimator::class.java), FlipOutX(FlipOutXAnimator::class.java), FlipInY(FlipInYAnimator::class.java), FlipOutY(
        FlipOutYAnimator::class.java
    ),
    RotateIn(RotateInAnimator::class.java), RotateInDownLeft(RotateInDownLeftAnimator::class.java), RotateInDownRight(
        RotateInDownRightAnimator::class.java
    ),
    RotateInUpLeft(RotateInUpLeftAnimator::class.java), RotateInUpRight(RotateInUpRightAnimator::class.java), RotateOut(
        RotateOutAnimator::class.java
    ),
    RotateOutDownLeft(RotateOutDownLeftAnimator::class.java), RotateOutDownRight(RotateOutDownRightAnimator::class.java), RotateOutUpLeft(
        RotateOutUpLeftAnimator::class.java
    ),
    RotateOutUpRight(RotateOutUpRightAnimator::class.java), SlideInLeft(SlideInLeftAnimator::class.java), SlideInRight(
        SlideInRightAnimator::class.java
    ),
    SlideInUp(SlideInUpAnimator::class.java), SlideInDown(SlideInDownAnimator::class.java), SlideOutLeft(
        SlideOutLeftAnimator::class.java
    ),
    SlideOutRight(SlideOutRightAnimator::class.java), SlideOutUp(SlideOutUpAnimator::class.java), SlideOutDown(
        SlideOutDownAnimator::class.java
    ),
    ZoomIn(ZoomInAnimator::class.java), ZoomInDown(ZoomInDownAnimator::class.java), ZoomInLeft(ZoomInLeftAnimator::class.java), ZoomInRight(
        ZoomInRightAnimator::class.java
    ),
    ZoomInUp(ZoomInUpAnimator::class.java), ZoomOut(ZoomOutAnimator::class.java), ZoomOutDown(ZoomOutDownAnimator::class.java), ZoomOutLeft(
        ZoomOutLeftAnimator::class.java
    ),
    ZoomOutRight(ZoomOutRightAnimator::class.java), ZoomOutUp(ZoomOutUpAnimator::class.java);

    val animator: BaseViewAnimator
        get() = try {
            animatorClazz.newInstance() as BaseViewAnimator
        } catch (e: Exception) {
            throw Error("Can not init animatorClazz instance")
        }

}