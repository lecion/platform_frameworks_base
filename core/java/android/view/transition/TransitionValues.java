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
package android.view.transition;

import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;

/**
 * Data structure which holds cached values for the transition.
 * The view field is the target which all of the values pertain to.
 * The values field is a hashmap which holds information for fields
 * according to names selected by the transitions. These names should
 * be unique to avoid clobbering values stored by other transitions,
 * such as the convention project:transition_name:property_name. For
 * example, the platform might store a property "alpha" in a transition
 * "Fader" as "android:fader:alpha".
 *
 * <p>These values are cached during the
 * {@link Transition#captureValues(TransitionValues, boolean)}
 * capture} phases of a scene change, once when the start values are captured
 * and again when the end values are captured. These start/end values are then
 * passed into the transitions during the play phase of the scene change,
 * for {@link Transition#prePlay(ViewGroup, TransitionValues, TransitionValues)} and
 * for {@link Transition#play(ViewGroup, TransitionValues, TransitionValues)}.</p>
 */
public class TransitionValues {

    /**
     * The View with these values
     */
    public View view;

    /**
     * The set of values tracked by transitions for this scene
     */
    public final HashMap<String, Object> values = new HashMap<String, Object>();

    @Override
    public String toString() {
        String returnValue = "TransitionValues@" + Integer.toHexString(hashCode()) + ":\n";
        returnValue += "    view = " + view + "\n";
        returnValue += "    values = " + values + "\n";
        return returnValue;
    }
}