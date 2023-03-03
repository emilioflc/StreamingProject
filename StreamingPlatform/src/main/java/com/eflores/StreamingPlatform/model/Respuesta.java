package com.eflores.StreamingPlatform.model;

import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@JsonInclude(NON_NULL)
public class Respuesta {
    protected LocalDateTime timeStamp;
    protected int codigoStatus;
    protected HttpStatus status;
    protected String razon;
    protected String mensaje;
    protected String mensajeDesarrollador;
    protected Map<?,?> data;
}
