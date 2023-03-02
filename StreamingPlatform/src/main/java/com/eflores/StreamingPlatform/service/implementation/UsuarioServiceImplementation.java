package com.eflores.StreamingPlatform.service.implementation;

import java.util.Collection;

import static org.springframework.data.domain.PageRequest.of;
import org.springframework.stereotype.Service;

import com.eflores.StreamingPlatform.model.Usuario;
import com.eflores.StreamingPlatform.repo.UsuarioRepo;
import com.eflores.StreamingPlatform.service.UsuarioService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class UsuarioServiceImplementation implements UsuarioService{

    private final UsuarioRepo usuarioRepo;

    /**
     * Crea un usuario en la Base de Datos.
     * 
     * @param usuario el usuario a agregar
     * @return el usuario agregado
     */
    @Override
    public Usuario crear(Usuario usuario) {
        log.info("Creando nuevo usuario: {}",usuario.getCorreo());
        usuario.setPathFotoPerfil(setUsuarioPathFotoPerfil());
        return usuarioRepo.save(usuario);
    }


    /**
     * Lista todos los usuarios de la Base de Datos.
     * 
     * @return todos los usuarios de la Base de Datos
     */
    @Override
    public Collection<Usuario> listAll(int limit) {
        log.info("Obteniendo todos los usuarios...");
        return usuarioRepo.findAll(of(0, limit)).toList();
    }

    /**
     * Modifica un usuario en la Base de Datos.
     * 
     * @param usuario el usuario a modificar
     * @return el usuario modificado
     */
    @Override
    public Usuario modificar(Usuario usuario) {
        log.info("Modificando usuario: {}",usuario.getCorreo());
        usuario.setPathFotoPerfil(setUsuarioPathFotoPerfil());
        return usuarioRepo.save(usuario);
    }


    /**
     * Consulta un usuario de la Base de Datos.
     * 
     * @param id el id del usuario deseado
     * @return el usuario consultado
     */
    @Override
    public Usuario get(Long id) {
        log.info("Consultando usuario por id: {}",id);
        return usuarioRepo.findById(id).get();
    }

    /**
     * Elimina un usuario en la Base de Datos.
     * 
     * @param id el id del usuario a eliminar
     * @return verdadero si la funcion fue exitosa, falso si hubo un error
     */
    @Override
    public Boolean eliminar(Long id) {
        log.info("Eliminando usuario por id: {}",id);
        usuarioRepo.deleteById(id);
        return Boolean.TRUE;
    }

    private String setUsuarioPathFotoPerfil() {
        return null;
    }
    
}
