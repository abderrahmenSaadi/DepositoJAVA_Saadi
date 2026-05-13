package com.example.mohamed.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import com.example.mohamed.service.PrezzoService;
@Service
public class ProdottoService {
    private final PrezzoService prezzoService;

    List<String> prodotti ;
    Map<String, Double> prezzi ;

    public ProdottoService(PrezzoService prezzoService) {
        this.prezzoService = prezzoService;
    }

     @PostConstruct
    public void init() {
        prodotti = List.of("Prodotto1", "Prodotto2", "Prodotto3");
        prezzi = Map.of("Prodotto1", 10.0, "Prodotto2", 20.0, "Prodotto3", 30.0);

    }
    public void stampaCatalogo(int percentualeSconto) { 
        
        for (String prodotto : prodotti) {
            double prezzoOriginale = prezzi.get(prodotto);
            double prezzoScontato = prezzoService.calcolaPrezzoScontato(prezzoOriginale, percentualeSconto);
            System.out.println(prodotto + ": " + prezzoOriginale + " euro");
            System.out.println(prodotto + ": " + prezzoScontato + " euro");
        }
    }

}
