package com.example.karnika.dto;

import static com.example.karnika.constants.constants.ACCOUNT_NUMBER_PATTERN_STRING;
import static com.example.karnika.constants.constants.SORT_CODE_PATTERN_STRING;

import com.mifmif.common.regex.Generex;

public class CodeGenerator {
    Generex passCodeGenerex = new Generex(SORT_CODE_PATTERN_STRING);
    Generex accountNumberGenerex = new Generex(ACCOUNT_NUMBER_PATTERN_STRING);

    public CodeGenerator(){}

    public String generatepassCode() {
        return passCodeGenerex.random();
    }

    public String generateAccountNumber() {
        return accountNumberGenerex.random();
    }
}
