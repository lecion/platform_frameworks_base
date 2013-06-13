/*
 * Copyright (C) 2013 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.android.transitiontests;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.transition.Scene;
import android.widget.Button;
import android.view.transition.Fade;
import android.view.transition.Move;
import android.view.transition.TextChange;
import android.view.transition.TransitionGroup;
import android.view.transition.TransitionManager;

public class ClippingText extends Activity {

    Button mRemovingButton, mInvisibleButton, mGoneButton;
    Scene mScene1, mScene2;
    ViewGroup mSceneRoot;
    //    static Fade sFade = new Fade(R.id.removingButton, R.id.invisibleButton, R.id.goneButton);
    Fade fader;
    TransitionGroup mChanger;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clipping_text_1);

        View container = (View) findViewById(R.id.container);
        mSceneRoot = (ViewGroup) container.getParent();

        mScene1 = new Scene(mSceneRoot, R.layout.clipping_text_1, this);
        mScene2 = new Scene(mSceneRoot, R.layout.clipping_text_2, this);

        mChanger = new TransitionGroup(TransitionGroup.TOGETHER);
        Move move = new Move();
        move.setResizeClip(true);
        mChanger.addTransitions(move, new TextChange());

        mSceneRoot.setCurrentScene(mScene1);
    }

    public void sendMessage(View view) {
        if (mSceneRoot.getCurrentScene() == mScene1) {
            TransitionManager.go(mScene2, mChanger);
        } else {
            TransitionManager.go(mScene1, mChanger);
        }
    }
}