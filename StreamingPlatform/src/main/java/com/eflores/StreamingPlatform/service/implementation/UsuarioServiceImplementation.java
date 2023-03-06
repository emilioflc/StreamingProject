package com.eflores.StreamingPlatform.service.implementation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
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
     * Consulta un usuario de la Base de Datos.
     * 
     * @param correo el correo del usuario deseado
     * @return el usuario consultado
     */
    @Override
    public Usuario getByCorreo(String correo) {
        log.info("Consultando usuario por correo: {}",correo);
        return usuarioRepo.findByCorreo(correo);
    }

    /**
     * Elimina un usuario en la Base de Datos.
     * 
     * @param id el id del usuario a eliminar
     * @return verdadero si la funcion fue exitosa, falso si hubo un error
     * @throws IOException
     */
    @Override
    public Boolean eliminar(Long id) throws IOException {
        log.info("Eliminando usuario por id: {}",id);
        Usuario usuario = get(id);
        Files.delete(Paths.get(usuario.getPathFotoPerfil()));
        usuarioRepo.deleteById(id);
        return Boolean.TRUE;
    }
}
