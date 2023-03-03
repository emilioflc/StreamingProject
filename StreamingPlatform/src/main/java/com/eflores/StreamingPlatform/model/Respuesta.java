package com.eflores.StreamingPlatform.model;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

public class Respuesta {
    protected LocalDateTime timeStamp;
    protected int codigoStatus;
    protected HttpStatus status;
    protected String razon;
    protected String mensaje;
    protected String mensajeDesarrollador;
    protected Map<?,?> data;
}
