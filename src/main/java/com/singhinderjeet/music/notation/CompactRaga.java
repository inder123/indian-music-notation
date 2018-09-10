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
 * Representation of the serialized form of a Raga
 *
 * @author Inderjeet Singh
 */
final class CompactRaga {
    @SerializedName("name") final String name;
    @SerializedName("thaat") final Thaat thaat;
    @SerializedName("bpm") final int bpm;
    @SerializedName("aaroha") final String aaroha;
    @SerializedName("avroha") final String avroha;
    @SerializedName("theme") final String theme;
    @SerializedName("alaap") final String alaap;

    public CompactRaga(String name, Thaat thaat, int bpm, String aaroha, String avroha, String theme, String alaap) {
        this.name = name;
        this.thaat = thaat;
        this.bpm = bpm;
        this.aaroha = aaroha;
        this.avroha = avroha;
        this.theme = theme;
        this.alaap = alaap;
    }

    public Raga toRaga() {
        return new Raga(name, thaat, bpm, Utils.toNoteSequenceList(aaroha), Utils.toNoteSequenceList(avroha), Utils.toNoteSequenceList(theme), Utils.toNoteSequenceList(alaap));
    }
}