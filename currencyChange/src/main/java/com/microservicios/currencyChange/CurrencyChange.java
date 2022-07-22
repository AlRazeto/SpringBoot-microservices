package com.microservicios.currencyChange;

import org.springframework.stereotype.Component;

@Component
public class CurrencyChange {
    private int moneyIn;
    private int moneyOut;
    private int exchangeRate;

    public CurrencyChange(){

    }
    public CurrencyChange(int moneyIn, int exchangeRate) {
        this.moneyIn = moneyIn;
        this.exchangeRate = exchangeRate;
        this.moneyOut = moneyIn * exchangeRate;
    }

    public int getMoneyIn() {
        return moneyIn;
    }

    public void setMoneyIn(int moneyIn) {
        this.moneyIn = moneyIn;
    }

    public int getMoneyOut() {
        return moneyOut;
    }

    public void setMoneyOut(int moneyOut) {
        this.moneyOut = moneyOut;
    }

    public int getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(int exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
