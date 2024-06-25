package com.abach42.etude.dnaencoding;

import java.util.Arrays;
import java.util.stream.Collectors;

public class DnaEncoder {

    public enum Nucleotide {
        A((byte) 0b00),
        C((byte) 0b01),
        G((byte) 0b10),
        T((byte) 0b11);

        private final byte value;

        Nucleotide(byte value) {
            this.value = value;
        }

        public byte getValue() {
            return value;
        }

        public static Nucleotide tryFromValue(byte valueByte) {
            for (Nucleotide nucleotide : Nucleotide.values()) {
                if (nucleotide.getValue() == valueByte) {
                    return nucleotide;
                }
            }
            throw new IllegalArgumentException("Invalid nucleotide byte value: " + valueByte);
        }

        public static Nucleotide tryFromChar(char nucleotideChar) {
            try {
                return Nucleotide.valueOf(String.valueOf(nucleotideChar));
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid nucleotide character: " + nucleotideChar);
            }
        }
    }

    public static Byte[] compress(String nucleoideString) {
        return nucleoideString
                .chars()
                .mapToObj(nucleotideChar -> Nucleotide.tryFromChar((char) nucleotideChar).value)
                .toArray(Byte[]::new);
    }

    public static String inflate(Byte[] compressedBytes) {
       return Arrays.stream(compressedBytes)
               .map(valueByte -> Nucleotide.tryFromValue(valueByte).toString())
               .collect(Collectors.joining());
    }
}