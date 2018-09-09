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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

/**
 * Base class of a Music or Speed change note
 *
 * @author Inderjeet Singh
 */
@JsonAdapter(Note.GsonAdapter.class)
public abstract class Note {
    protected final String value;
    public Note(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    static final class GsonAdapter extends TypeAdapter<Note> {
        @Override public Note read(JsonReader in) throws IOException {
            String value = in.nextString();
            return valueOf(value);
        }
        @Override public void write(JsonWriter out, Note note) throws IOException {
            out.value(note.value);
        }
    }

    public static Note valueOf(String value) {
        Note note = MusicNote.valueOf(value);
        if (note == null) {
            note = SpeedNote.valueOf(value);
        }
        return note;
    }
}
