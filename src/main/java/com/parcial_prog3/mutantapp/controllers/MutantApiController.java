package com.parcial_prog3.mutantapp.controllers;

import com.parcial_prog3.mutantapp.dto.DnaInput;
import com.parcial_prog3.mutantapp.dto.DnaResult;
import com.parcial_prog3.mutantapp.services.DnaProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mutant")
public class MutantApiController {

    @Autowired
    private DnaProcessingService dnaProcessingService;

    @PostMapping("/")
    public ResponseEntity<DnaResult> checkMutant(@RequestBody DnaInput dnaInput) {
        boolean isMutant = dnaProcessingService.isMutant(dnaInput.getDnaSequence());
        DnaResult result = new DnaResult(isMutant, isMutant ? "Mutant detected" : "Not a mutant");
        return new ResponseEntity<>(result, isMutant ? HttpStatus.OK : HttpStatus.FORBIDDEN);
    }
}
