package com.parcial_prog3.mutantapp.repositories;

import com.parcial_prog3.mutantapp.models.DnaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DnaRepository extends JpaRepository<DnaEntity, Long> {
    boolean existsByDnaSequence(String[] dnaSequence);
    long countByIsMutant(boolean isMutant);
}

