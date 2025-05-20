package com.twobrains.employees_api.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class ApiException extends RuntimeException {
    @Getter
    private final HttpStatus status;
    private final String mensaje;

    public ApiException(HttpStatus status, String mensaje) {
        super(mensaje);
        this.status = status;
        this.mensaje = mensaje;
    }

    @Override
    public String getMessage() {
        return mensaje;
    }
}
