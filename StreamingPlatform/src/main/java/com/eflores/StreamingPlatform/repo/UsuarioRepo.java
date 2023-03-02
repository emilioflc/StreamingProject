package com.eflores.StreamingPlatform.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eflores.StreamingPlatform.model.Usuario;

public interface UsuarioRepo extends JpaRepository<Usuario, Long>{
    Usuario findByCorreo(String correo);
}
