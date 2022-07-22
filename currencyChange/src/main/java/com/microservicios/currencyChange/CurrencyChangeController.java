package com.microservicios.currencyChange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class CurrencyChangeController {
    @Autowired
    private CurrencyExchangeProxy ExchangeProxy;
    @GetMapping("/change/{amount}/{from}/{to}")
    public CurrencyChange changeCurrency(
            @PathVariable int amount,
            @PathVariable String from,
            @PathVariable String to)
    {
        int exchangeRate = ExchangeProxy.getExchange(from, to);

        CurrencyChange res = new CurrencyChange(amount, exchangeRate);

        return res;
    }
}
