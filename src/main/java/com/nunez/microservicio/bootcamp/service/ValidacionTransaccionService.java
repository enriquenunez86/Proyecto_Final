package com.nunez.microservicio.bootcamp.service;

import com.nunez.microservicio.bootcamp.domain.Transaccion;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ValidacionTransaccionService {

    private String mensajeError;

    public boolean validarDeposito(Transaccion transaccion) {
        return transaccion.getMonto() > 0;
    }

    public HttpStatus validarRetiro(Transaccion transaccion) {
        if (transaccion.getMonto() <= 0) {
            mensajeError = "El monto debe ser mayor a cero";
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.CREATED;
    }

    public HttpStatus validarTransferencia(Transaccion transaccion) {
        if (transaccion.getMonto() <= 0) {
            mensajeError = "El monto debe ser mayor a cero";
            return HttpStatus.BAD_REQUEST;
        }
        return HttpStatus.CREATED;
    }

    public String getMensajeError() {
        return mensajeError;
    }
}
