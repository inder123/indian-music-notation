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

import java.io.Reader;

import com.google.gson.Gson;
import com.singhinderjeet.music.notation.model.Raga;

/**
 * A class to serialize or deserialize Hindustani ragas
 *
 * @author Inderjeet Singh
 */
public class MusicParser {
    private final Gson gson;

    public MusicParser() {
        this(new Gson());
    }

    public MusicParser(Gson gson) {
        this.gson = gson;
    }

    public Raga parseRaga(Reader reader) {
        CompactRaga raga = gson.fromJson(reader, CompactRaga.class);
        return raga.toRaga();
    }
}
