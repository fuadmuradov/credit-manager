package org.example.creditmanager.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
public enum ErrorConstants {
    UNEXPECTED_EXCEPTION("Unexpected Exception", "UNEXPECTED_EXCEPTION"),
    CUSTOMER_NOT_FOUND_EXCEPTION("Customer Not Found Exception", "NOT_FOUND_EXCEPTION"),
    CLIENT_ERROR("Client Error", "CLIENT_ERROR"),
    CREDIT_NOT_FOUND_EXCEPTION("Credit Not Found Exception", "NOT_FOUND_EXCEPTION");
    private final String message;
    private final String code;
}
