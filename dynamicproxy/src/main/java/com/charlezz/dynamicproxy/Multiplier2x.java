package com.charlezz.dynamicproxy;

public class Multiplier2x implements Multiplier {
    @Override
    public int multiply(int value, int multiple) {
        return value * multiple;
    }
}
