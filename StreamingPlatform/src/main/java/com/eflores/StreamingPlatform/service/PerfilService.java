package com.eflores.StreamingPlatform.service;

import com.eflores.StreamingPlatform.model.Perfil;

public interface PerfilService {
    Perfil crear(Perfil perfil);
    Perfil modificar(Perfil perfil);
    Perfil get(Long id);
    Boolean eliminar(Long id);
}
