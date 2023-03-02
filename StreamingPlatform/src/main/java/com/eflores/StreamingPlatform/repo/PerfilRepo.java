package com.eflores.StreamingPlatform.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eflores.StreamingPlatform.model.Perfil;
import com.eflores.StreamingPlatform.model.Usuario;

public interface PerfilRepo extends JpaRepository<Perfil, Long>{
    Perfil findByUsuarioCreador(Usuario usuarioCreador);
}
