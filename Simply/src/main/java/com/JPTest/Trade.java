package com.JPTest;

import jdk.nashorn.internal.ir.annotations.Immutable;

import java.time.LocalDateTime;

@Immutable
public final class Trade {
    private final LocalDateTime timeStamp;
    private final int quantity;
    private final boolean buy;
    private final long price;
    private final String stockSymbol;

    public Trade(LocalDateTime time, int quantity, boolean buy, long price, String stock){
        timeStamp = time;
        this.quantity = quantity;
        this.buy = buy;
        this.price = price;
        stockSymbol = stock;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public long getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
