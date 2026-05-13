package com.example.mohamed.service;

import org.springframework.stereotype.Service;

@Service
public class PrezzoService {
    public double calcolaPrezzoScontato(double prezzoOriginale, int percentualeSconto) {
        return prezzoOriginale - (prezzoOriginale * percentualeSconto / 100);
    }
    
}
