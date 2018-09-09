/*
 * Copyright (C) 2018 Inderjeet Singh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.singhinderjeet.music.notation.model;

import java.util.Arrays;
import java.util.List;

/**
 * A note that indicates tempo changes
 *
 * @author Inderjeet Singh
 */
public final class SpeedNote extends Note {
    /** Reset to the original speed of the score */
    public static final SpeedNote RESET_TO_DEFAULT = new SpeedNote("bb");
    /** 1/8 of the current speed or duration */
    public static final SpeedNote EIGHTH = new SpeedNote("b/8");
    /** 1/4 of the current speed or duration */
    public static final SpeedNote QUARTER = new SpeedNote("b/4");
    /** 1/2 of the current speed or duration */
    public static final SpeedNote HALF = new SpeedNote("b/2");
    /** Same as the current speed or duration */
    public static final SpeedNote SINGLE = new SpeedNote("b");
    /** 2x the current speed or duration */
    public static final SpeedNote DOUBLE = new SpeedNote("bx2");
    /** 4x the current speed or duration */
    public static final SpeedNote QUADRUPLE = new SpeedNote("bx4");
    /** 8x the current speed or duration */
    public static final SpeedNote EIGHT_TIMES = new SpeedNote("bx8");

    private static final List<SpeedNote> all = Arrays.asList(RESET_TO_DEFAULT, EIGHTH, QUARTER, HALF, SINGLE, DOUBLE, QUADRUPLE, EIGHT_TIMES); 
    public static SpeedNote valueOf(String value) {
        for (SpeedNote note : all) {
            if (note.value.equals(value)) return note;
        }
        return null;
    }

    private SpeedNote(String value) {
        super(value);
    }
}
