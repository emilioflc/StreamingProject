package com.eflores.StreamingPlatform.service;

import java.io.IOException;
import java.util.Collection;

import com.eflores.StreamingPlatform.model.Usuario;

public interface UsuarioService {
    Usuario crear(Usuario usuario);
    Usuario modificar(Usuario usuario);
    Collection<Usuario> listAll(int limit);
    Usuario get(Long id);
    Boolean eliminar(Long id) throws IOException;
}
