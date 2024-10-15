package com.parcial_prog3.mutantapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DnaResult {
    private boolean isMutant;
    private String resultMessage;
}
