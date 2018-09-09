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

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Model class to represent a Hindustani classical raga
 *
 * @author Inderjeet Singh
 */
public class Raga {
    @SerializedName("name") private final String name;
    @SerializedName("aaroha") private final NoteSequence aaroha;
    @SerializedName("avroha") private final NoteSequence avroha;
    @SerializedName("theme") private final List<NoteSequence> theme;
    @SerializedName("alaap") private final List<NoteSequence> alaap;

    public Raga(String name, NoteSequence aaroha, NoteSequence avroha, List<NoteSequence> theme, List<NoteSequence> alaap) {
        this.name = name;
        this.aaroha = aaroha;
        this.avroha = avroha;
        this.theme = theme;
        this.alaap = alaap;
    }

    public String getName() {
        return name;
    }

    public NoteSequence getAaroha() {
        return aaroha;
    }

    public NoteSequence getAvroha() {
        return avroha;
    }

    public List<NoteSequence> getTheme() {
        return theme;
    }

    public List<NoteSequence> getAlaap() {
        return alaap;
    }
}
