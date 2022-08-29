package com.itranswarp.exchange.enums;

public enum Direction {
    BUY(1),
    SELL(0);

    public final int value;

    private Direction(int value) {
        this.value = value;
    }

}
