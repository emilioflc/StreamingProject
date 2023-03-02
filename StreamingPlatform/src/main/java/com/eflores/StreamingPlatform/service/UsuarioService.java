package com.eflores.StreamingPlatform.service;

import com.eflores.StreamingPlatform.model.Usuario;

public interface UsuarioService {
    Usuario crear(Usuario usuario);
    Usuario modificar(Usuario usuario);
    Usuario get(Long id);
    Boolean eliminar(Long id);
}
