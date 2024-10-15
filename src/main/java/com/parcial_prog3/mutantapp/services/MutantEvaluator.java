package com.parcial_prog3.mutantapp.services;

public class MutantEvaluator {

    private static final int REQUIRED_SEQUENCE_LENGTH = 4;
    private static final char[] VALID_BASES = {'A', 'T', 'C', 'G'};

    public static boolean detectMutant(String[] dna) {
        if (dna == null) {
            throw new IllegalArgumentException("ADN no puede ser null.");
        }
        int size = dna.length;
        if (size == 0) {
            throw new IllegalArgumentException("El arreglo de ADN está vacío.");
        }
        for (String strand : dna) {
            if (strand == null) {
                throw new IllegalArgumentException("Una secuencia en ADN es null.");
            }
            if (strand.length() != size) {
                throw new IllegalArgumentException("Las secuencias de ADN deben ser cuadradas NxN.");
            }
            if (!strand.matches("[ATCG]+")) {
                throw new IllegalArgumentException("El ADN contiene caracteres no válidos.");
            }
        }

        int sequenceCount = 0;

        // Revisión de filas, columnas y diagonales
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j <= size - REQUIRED_SEQUENCE_LENGTH && isMutantSequence(dna, i, j, 0, 1)) sequenceCount++;
                if (i <= size - REQUIRED_SEQUENCE_LENGTH && isMutantSequence(dna, i, j, 1, 0)) sequenceCount++;
                if (i <= size - REQUIRED_SEQUENCE_LENGTH && j <= size - REQUIRED_SEQUENCE_LENGTH && isMutantSequence(dna, i, j, 1, 1)) sequenceCount++;
                if (i <= size - REQUIRED_SEQUENCE_LENGTH && j >= REQUIRED_SEQUENCE_LENGTH - 1 && isMutantSequence(dna, i, j, 1, -1)) sequenceCount++;
                if (sequenceCount > 1) return true; // Sale temprano si encuentra más de una secuencia
            }
        }
        return false;
    }

    private static boolean isMutantSequence(String[] dna, int row, int col, int rowInc, int colInc) {
        char base = dna[row].charAt(col);
        for (int k = 1; k < REQUIRED_SEQUENCE_LENGTH; k++) {
            if (dna[row + k * rowInc].charAt(col + k * colInc) != base) {
                return false;
            }
        }
        return true;
    }
}

