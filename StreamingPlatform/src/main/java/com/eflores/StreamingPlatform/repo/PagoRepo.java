package com.eflores.StreamingPlatform.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eflores.StreamingPlatform.model.Pago;
import com.eflores.StreamingPlatform.model.Usuario;

public interface PagoRepo extends JpaRepository<Pago, Long>{
    Pago findByUsuarioCreador(Usuario usuarioCreador);
}
