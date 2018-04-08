package com.gamasoft.markets;

import com.gamasoft.commons.Utils;

public class StockExchange {
    private String exchangeName;

    public StockExchange(String exchangeName) {
        Utils.notBlank(exchangeName, "exchangeName");

        this.exchangeName = exchangeName;
    }

    public String getCurrency() {
        return "GBP";
    }

    public String getExchangeName() {
        return exchangeName;
    }
}
