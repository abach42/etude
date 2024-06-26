package com.abach42.etude.dnaencoding;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DnaEncoderTest {

    @Test
    @DisplayName("dna encoder inflates compression of a String of nucleotides.")
    public void testInflateCompressed() {
        String expected = "ACGT";
        assertEquals(
                expected,
                DnaEncoder.inflate(DnaEncoder.compress(expected)));
    }

    @Test
    @DisplayName("dna encoder compresses inflation of a Byte array representation of nucleotides.")
    public void testCompressInflated() {
        Byte[] expected = new Byte[] { (byte) 0b00, (byte) 0b01, (byte) 0b10, (byte) 0b11 };
        assertArrayEquals(
                expected,
                DnaEncoder.compress(DnaEncoder.inflate(expected))
        );
    }

    @Test
    @DisplayName("dna encoder inflating can handle lower case input")
    public void testInflateLowCase() {
        String inputString = "acgt";
        assertEquals(
                inputString.toUpperCase(),
                DnaEncoder.inflate(DnaEncoder.compress(inputString)));
    }

    @Test
    @DisplayName("dna encoder throws error when unknown character is used")
    public void testInflateUnknownCharacter() {
        String inputString = "Z";
        assertThrows(
                IllegalArgumentException.class,
                () -> DnaEncoder.compress(inputString));
    }

    @Test
    @DisplayName("dna decoder throws error when unknown bit is used")
    public void testInflateUnknownBit() {
        Byte[] inputByte = new Byte[] { (byte) 0b111};
        assertThrows(
                IllegalArgumentException.class,
                () -> DnaEncoder.inflate(inputByte));
    }
}