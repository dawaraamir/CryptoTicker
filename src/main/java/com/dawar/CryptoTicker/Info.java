package com.dawar.CryptoTicker;

import java.util.Arrays;

public class Info {
    private Ticker ticker;

    public Ticker getTicker() {
        return ticker;
    }

    public void setTicker(Ticker ticker) {
        this.ticker = ticker;
    }

    @Override
    public String toString() {
        return "Info{" +
                "ticker=" + ticker +
                '}';
    }
}
