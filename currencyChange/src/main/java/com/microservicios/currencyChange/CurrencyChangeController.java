package com.microservicios.currencyChange;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
public class CurrencyChangeController {

    @GetMapping("/change/{amount}/{from}/{to}")
    public CurrencyChange changeCurrency(
            @PathVariable int amount,
            @PathVariable String from,
            @PathVariable String to
    ){
        HashMap<String, String> reqVariables = new HashMap<>();
        reqVariables.put("from", from);
        reqVariables.put("to", to);
        ResponseEntity<Integer> exchangeRate = new RestTemplate().getForEntity(
                                            "http://localhost:8000/exchange/{from}/{to}", Integer.class, reqVariables);
        if(exchangeRate.getBody() == null){
            throw new RuntimeException("Unrecorded exchange rate or invalid currencies");
        }

        CurrencyChange res = new CurrencyChange(amount, exchangeRate.getBody());

        return res;
    }
}
