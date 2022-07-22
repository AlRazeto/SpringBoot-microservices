package com.microservicios.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private CurrencyExchangeRepository repository;

    @GetMapping("/exchange/{from}/{to}")
    public int getExchange (
            @PathVariable String from,
            @PathVariable String to)
    {
        CurrencyExchange res = repository.findByFromAndTo(from, to);
        if (res == null){
            throw new RuntimeException("No Data");
        }
        return res.getExchangeRate();
    }
}
