package com.gamasoft.markets;

import com.gamasoft.commons.Utils;

public class Trade {
    public final String stock;
    public final double price;
    public final int qty;

    public Trade(String stock, double price, int qty) {
        Utils.notBlank(stock, "stock");

        this.stock = stock;
        this.price = price;
        this.qty = qty;
    }
}
