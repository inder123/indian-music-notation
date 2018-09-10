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

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Model class to represent a group of notes in a raga
 *
 * @author Inderjeet Singh
 */
@JsonAdapter(NoteSequence.JsonTypeAdapterFactory.class)
public final class NoteSequence {
    public static final class Builder {
        private final List<Note> notes = new ArrayList<>();
        public Builder add(Note note) {
            if (note == null) throw new IllegalArgumentException("null note can't be added");
            notes.add(note);
            return this;
        }
        public NoteSequence build() {
            return new NoteSequence(notes);
        }
    }

    private final List<Note> notes;

    public NoteSequence(Note... notes) {
        this(Arrays.asList(notes));
    }
    public NoteSequence(List<Note> notes) {
        this.notes = notes;
    }

    public List<Note> notes() {
        return notes;
    }

    public boolean isEmpty() {
        return notes.isEmpty();
    }

    static final class JsonTypeAdapterFactory implements TypeAdapterFactory {
        @SuppressWarnings("unchecked")
        @Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            if (type.getRawType() != NoteSequence.class) return null;
            final TypeAdapter<List<Note>> adapter = gson.getAdapter(new TypeToken<List<Note>>(){});
            return (TypeAdapter<T>) new TypeAdapter<NoteSequence>() {
                @Override
                public void write(JsonWriter out, NoteSequence sequence) throws IOException {
                    adapter.write(out, sequence.notes);
                }
                @Override
                public NoteSequence read(JsonReader in) throws IOException {
                    List<Note> notes = adapter.read(in);
                    return new NoteSequence(notes);
                }
            };
        }
    }
}
