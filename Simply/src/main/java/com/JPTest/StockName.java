package com.JPTest;

public enum StockName {
    TEA("TEA"), POP("POP"), ALE("ALE"), GIN("GIN"), JOE("JOE");

    private final String text;

    StockName(final String str){text = str;}

    @Override
    public String toString() {
        return text;
    }
}
