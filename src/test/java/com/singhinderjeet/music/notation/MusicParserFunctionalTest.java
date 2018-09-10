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

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

import org.junit.Test;

/**
 * Functional tests for {@link MusicParser}
 *
 * @author Inderjeet Singh
 */
public class MusicParserFunctionalTest {
    @Test
    public void testChangeSpeedWithinSection() {
        Reader reader = new BufferedReader(new InputStreamReader(MusicParserFunctionalTest.class.getResourceAsStream("/jaitsree.json")));
        MusicParser parser = new MusicParser();
        Raga raga = parser.parseRaga(reader);

        assertEquals("Jaitsree", raga.getName());
        assertEquals(60, raga.getBpm());
        assertEquals(MusicNote.SA_UPPER, raga.getAaroha().get(0).notes().get(7));
        assertEquals(MusicNote.DHA_KOMAL, raga.getAvroha().get(0).notes().get(4));
        assertEquals(MusicNote.SA, raga.getTheme().get(0).notes().get(1));
        assertEquals(MusicNote.SA, raga.getAlaap().get(5).notes().get(3));
    }

    @Test
    public void testMultiSequenceAarohaAvroha() {
        Reader reader = new BufferedReader(new InputStreamReader(MusicParserFunctionalTest.class.getResourceAsStream("/bairari.json")));
        MusicParser parser = new MusicParser();
        Raga raga = parser.parseRaga(reader);

        assertEquals("Bairari", raga.getName());
        assertEquals(Thaat.MARWA, raga.getThaat());
        assertEquals(60, raga.getBpm());
        assertEquals(MusicNote.GA, raga.getAaroha().get(0).notes().get(5));
        assertEquals(MusicNote.MA_TEEVRA, raga.getAvroha().get(2).notes().get(2));
        assertEquals(MusicNote.MA_TEEVRA, raga.getTheme().get(1).notes().get(1));
        assertEquals(MusicNote.RE_KOMAL_UPPER, raga.getAlaap().get(11).notes().get(1));
    }
}
