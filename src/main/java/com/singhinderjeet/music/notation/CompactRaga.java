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

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.singhinderjeet.music.notation.model.Note;
import com.singhinderjeet.music.notation.model.NoteSequence;
import com.singhinderjeet.music.notation.model.Raga;

/**
 * Representation of the serialized form of a Raga
 *
 * @author Inderjeet Singh
 */
final class CompactRaga {
    @SerializedName("name") final String name;
    @SerializedName("bpm") final int bpm;
    @SerializedName("aaroha") final String aaroha;
    @SerializedName("avroha") final String avroha;
    @SerializedName("theme") final String theme;
    @SerializedName("alaap") final String alaap;

    public CompactRaga(String name, int bpm, String aaroha, String avroha, String theme, String alaap) {
        this.name = name;
        this.bpm = bpm;
        this.aaroha = aaroha;
        this.avroha = avroha;
        this.theme = theme;
        this.alaap = alaap;
    }

    public Raga toRaga() {
        return new Raga(name, toNoteSequence(aaroha), toNoteSequence(avroha), toNoteSequenceList(theme), toNoteSequenceList(alaap));
    }

    private NoteSequence toNoteSequence(String notes) {
        if (notes == null || notes.isEmpty()) return null;
        NoteSequence.Builder builder = new NoteSequence.Builder();
        for (String part : notes.split(" ")) {
            Note note = Note.valueOf(part);
            if (note != null) builder.add(note);
        }
        return builder.build();
    }

    private List<NoteSequence> toNoteSequenceList(String notesList) {
        List<NoteSequence> list = new ArrayList<>();
        for (String notes : notesList.split(",")) {
            NoteSequence sequence = toNoteSequence(notes);
            if (sequence != null && !sequence.isEmpty()) list.add(sequence);
        }
        return list;
    }
}