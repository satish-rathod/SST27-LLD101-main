package com.atm.hardware.impl;

import com.atm.hardware.Printer;

public class SimplePrinter implements Printer {
    @Override
    public void printReceipt(String message) {
        System.out.println("===============================");
        System.out.println("          RECEIPT");
        System.out.println("===============================");
        System.out.println(message);
        System.out.println("===============================");
    }
}