package com.nogumalabs.jjjson;

public class JJJSONDouble extends JJJSON {
    private double rawValue;
    public JJJSONDouble(double rawValue) {
        this.rawValue = rawValue;
    }
    public double getValue() {
        return rawValue;
    }
}
