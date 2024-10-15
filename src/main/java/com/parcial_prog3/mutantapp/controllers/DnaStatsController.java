package com.parcial_prog3.mutantapp.controllers;

import com.parcial_prog3.mutantapp.repositories.DnaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/dna-stats")
public class DnaStatsController {

    @Autowired
    private DnaRepository dnaRepository;

    @GetMapping("/")
    public Map<String, Object> fetchStats() {
        long mutantDnaCount = dnaRepository.countByIsMutant(true);
        long humanDnaCount = dnaRepository.countByIsMutant(false);
        double ratio = humanDnaCount == 0 ? 0 : (double) mutantDnaCount / humanDnaCount;

        Map<String, Object> stats = new HashMap<>();
        stats.put("mutant_dna_count", mutantDnaCount);
        stats.put("human_dna_count", humanDnaCount);
        stats.put("mutant_human_ratio", ratio);

        return stats;
    }
}
