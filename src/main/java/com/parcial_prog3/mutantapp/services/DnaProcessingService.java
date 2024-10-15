package com.parcial_prog3.mutantapp.services;

import com.parcial_prog3.mutantapp.models.DnaEntity;
import com.parcial_prog3.mutantapp.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DnaProcessingService {

    @Autowired
    private DnaRepository dnaRepository;

    public boolean isMutant(String[] dna) {
        // Lógica de detección de mutantes a través de MutantEvaluator
        boolean mutantFound = MutantEvaluator.detectMutant(dna);

        // Guardar la secuencia de ADN si no está registrada
        if (!dnaRepository.existsByDnaSequence(dna)) {
            DnaEntity dnaRecord = new DnaEntity();
            dnaRecord.setDnaSequence(dna);
            dnaRecord.setMutant(mutantFound);
            dnaRepository.save(dnaRecord);
        }

        return mutantFound;
    }
}

