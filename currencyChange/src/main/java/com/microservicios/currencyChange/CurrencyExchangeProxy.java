package com.microservicios.currencyChange;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="currency-exchange", url = "http://localhost:8000")
public interface CurrencyExchangeProxy {
    @GetMapping("/exchange/{from}/{to}")
    public int getExchange(@PathVariable String from, @PathVariable String to);

}
