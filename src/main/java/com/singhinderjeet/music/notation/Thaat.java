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
package com.singhinderjeet.music.notation;

import com.google.gson.annotations.SerializedName;

/**
 * The 10 Thaats of Hindustani classical music
 *
 * @author Inderjeet Singh
 */
public enum Thaat {
    @SerializedName("bilawal") BILAWAL("s r g m p d n su", "ionian"),
    @SerializedName("khammaj") KHAMMAJ("s r g m p d N su", "mixolydian"),
    @SerializedName("kafi") KAFI("s r G m p d N su", "dorian"), 
    @SerializedName("asawari") ASAWARI("s r G m p D N su", "aeolian"),
    @SerializedName("bhairavi") BHAIRAVI("s R G m p D N su", "phrygian"),
    @SerializedName("bhairav") BHAIRAV("s R g m p D n su", null),
    @SerializedName("kalyan") KALYAN("s r g M p d n su", "lydian"),
    @SerializedName("marwa") MARWA("s R g M p d n su", null),
    @SerializedName("purvi") PURVI("s R g M p D n su", null),
    @SerializedName("todi") TODI("s R G M p D n su", null);

    private final String scale;

    Thaat(String scale, String otherNames) {
        this.scale = scale;
    }

    public NoteSequence getScaleNotes() {
        return Utils.toNoteSequence(scale);
    }
}
