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

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * All the notes within a Musical Scale
 * Mandra, Madhya and Tar saptak
 *
 * @author Inderjeet Singh
 */
@JsonAdapter(MusicNote.GsonAdapter.class)
public final class MusicNote extends Note {
    public static final MusicNote SA_LOWER = new MusicNote("C2", "sl", -12);
    public static final MusicNote RE_KOMAL_LOWER = new MusicNote("C#2", "Rl", -11);
    public static final MusicNote RE_LOWER = new MusicNote("D2", "rl", -10);
    public static final MusicNote GA_KOMAL_LOWER = new MusicNote("D#2", "Gl", -9);
    public static final MusicNote GA_LOWER = new MusicNote("E2", "gl", -8);
    public static final MusicNote MA_LOWER = new MusicNote("F2", "ml", -7);
    public static final MusicNote MA_TEEVRA_LOWER = new MusicNote("F#2", "Ml", -6);
    public static final MusicNote PA_LOWER = new MusicNote("G2", "g2.ogg", -5);
    public static final MusicNote DHA_KOMAL_LOWER = new MusicNote("G#2", "Dl", -4);
    public static final MusicNote DHA_LOWER = new MusicNote("A2", "dl", -3);
    public static final MusicNote NI_KOMAL_LOWER = new MusicNote("A#2", "Nl", -2);
    public static final MusicNote NI_LOWER = new MusicNote("B2", "nl", -1);

    public static final MusicNote SA = new MusicNote("C3", "s", 0);
    public static final MusicNote RE_KOMAL = new MusicNote("C#3", "R", 1);
    public static final MusicNote RE = new MusicNote("D3", "r", 2);
    public static final MusicNote GA_KOMAL = new MusicNote("D#3", "G", 3);
    public static final MusicNote GA = new MusicNote("E3", "g", 4);
    public static final MusicNote MA = new MusicNote("F3", "m", 5);
    public static final MusicNote MA_TEEVRA = new MusicNote("F#3", "M", 6);
    public static final MusicNote PA = new MusicNote("G3", "p", 7);
    public static final MusicNote DHA_KOMAL = new MusicNote("G#3", "D", 8);
    public static final MusicNote DHA = new MusicNote("A3", "d", 9);
    public static final MusicNote NI_KOMAL = new MusicNote("A#3", "N", 10);
    public static final MusicNote NI = new MusicNote("B3", "n", 11);

    public static final MusicNote SA_UPPER = new MusicNote("C4", "su", 12);
    public static final MusicNote RE_KOMAL_UPPER = new MusicNote("C#4", "Ru", 13);
    public static final MusicNote RE_UPPER = new MusicNote("D4", "ru", 14);
    public static final MusicNote GA_KOMAL_UPPER = new MusicNote("D#4", "Gu", 15);
    public static final MusicNote GA_UPPER = new MusicNote("E4", "gu", 16);
    public static final MusicNote MA_UPPER = new MusicNote("F4", "mu", 17);
    public static final MusicNote MA_TEEVRA_UPPER = new MusicNote("F#4", "Mu", 18);
    public static final MusicNote PA_UPPER = new MusicNote("G4", "pu", 19);
    public static final MusicNote DHA_KOMAL_UPPER = new MusicNote("G#4", "Du", 20);
    public static final MusicNote DHA_UPPER = new MusicNote("A4", "du", 21);
    public static final MusicNote NI_KOMAL_UPPER = new MusicNote("A#4", "Nu", 22);
    public static final MusicNote NI_UPPER = new MusicNote("B4", "nu", 23);

    private static final List<MusicNote> all = Arrays.asList(
            SA_LOWER, RE_KOMAL_LOWER, RE_LOWER, GA_KOMAL_LOWER , GA_LOWER, MA_LOWER, MA_TEEVRA_LOWER, PA_LOWER, DHA_KOMAL_LOWER, DHA_LOWER, NI_KOMAL_LOWER, NI_LOWER,
            SA, RE_KOMAL, RE, GA_KOMAL, GA, MA, MA_TEEVRA, PA, DHA_KOMAL, DHA, NI_KOMAL, NI,
            SA_UPPER, RE_KOMAL_UPPER, RE_UPPER, GA_KOMAL_UPPER, GA_UPPER, MA_UPPER, MA_TEEVRA_UPPER, PA_UPPER, DHA_KOMAL_UPPER, DHA_UPPER, NI_KOMAL_UPPER, NI_UPPER);

    public static MusicNote valueOf(String bhatkahnde) {
        for (MusicNote note : all) {
            if (note.getValue().equals(bhatkahnde)) return note;
        }
        return null;
    }

    private final String note;
    private final String value;
    private final int scaleOffset;

    private MusicNote(String note, String bhatkhande, int scaleOffset) {
        super(bhatkhande);
        this.note = note;
        this.value = bhatkhande;
        this.scaleOffset = scaleOffset;
    }

    public String getNote() {
        return note;
    }

    public String getValue() {
        return value;
    }

    public int getScaleOffset() {
        return scaleOffset;
    }

    static final class GsonAdapter extends TypeAdapter<MusicNote> {
        @Override public MusicNote read(JsonReader in) throws IOException {
            return valueOf(in.nextString());
        }
        @Override public void write(JsonWriter out, MusicNote note) throws IOException {
            out.value(note.getValue());
        }
    }
}
