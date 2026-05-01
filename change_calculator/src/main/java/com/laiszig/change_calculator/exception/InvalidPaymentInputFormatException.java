package com.laiszig.change_calculator.exception;

public class InvalidPaymentInputFormatException extends Exception {
    public InvalidPaymentInputFormatException(String customMessage) {
        super(customMessage);
    }
}
