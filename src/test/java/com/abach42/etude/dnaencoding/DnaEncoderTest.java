package com.abach42.etude.dnaencoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DnaEncoderTest {

    @Test
    @DisplayName("dna encoder inflates compression of a String of nucleotides.")
    public void testInflateCompressed() {
        String expected = "ACCGT";
        assertEquals(
                expected,
                DnaEncoder.inflate(DnaEncoder.compress(expected)));
    }

    @Test
    @DisplayName("dna encoder compresses inflation of a Byte array representation of nucleotides.")
    public void testCompressInflated() {
        Byte[] expected = new Byte[] { (byte) 0b00, (byte) 0b01, (byte) 0b01, (byte) 0b10, (byte) 0b11 };
        assertArrayEquals(
                expected,
                DnaEncoder.compress(DnaEncoder.inflate(expected))
        );
    }
}
