package com.eflores.StreamingPlatform.service;

import java.util.Collection;

import com.eflores.StreamingPlatform.model.Pago;

public interface PagoService {
    Pago crear(Pago pago);
    Collection<Pago> listAll(int limit);
    Pago get(Long id);
    Boolean eliminar(Long id);
}
