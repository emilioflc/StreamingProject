package com.eflores.StreamingPlatform.service;

import com.eflores.StreamingPlatform.model.Pago;

public interface PagoService {
    Pago crear(Pago pago);
    Pago get(Long id);
    Boolean eliminar(Long id);
}
