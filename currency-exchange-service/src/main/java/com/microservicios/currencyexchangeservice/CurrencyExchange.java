package com.microservicios.currencyexchangeservice;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CurrencyExchange {
    @Id
    private int id;
    @Column(name = "FromCurrency")
    private String from;
    @Column(name = "ToCurrency")
    private String to;
    private int exchangeRate;

    public CurrencyExchange() {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(int exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
