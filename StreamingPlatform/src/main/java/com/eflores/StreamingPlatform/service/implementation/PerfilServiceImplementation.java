package com.eflores.StreamingPlatform.service.implementation;

import org.springframework.stereotype.Service;

import com.eflores.StreamingPlatform.model.Perfil;
import com.eflores.StreamingPlatform.repo.PerfilRepo;
import com.eflores.StreamingPlatform.service.PerfilService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class PerfilServiceImplementation implements PerfilService{

    private final PerfilRepo perfilRepo;

    /**
     * Crea un perfil en la Base de Datos.
     * 
     * @param perfil el perfil a agregar
     * @return el perfil agregado
     */
    @Override
    public Perfil crear(Perfil perfil) {
        log.info("Creando nuevo perfil: {}",perfil.getAlias());
        return perfilRepo.save(perfil);
    }

    /**
     * Modifica un perfil en la Base de Datos.
     * 
     * @param perfil el perfil a modificar
     * @return el perfil modificado
     */
    @Override
    public Perfil modificar(Perfil perfil) {
        log.info("Modificando perfil: {}",perfil.getAlias());
        return perfilRepo.save(perfil);
    }


    /**
     * Consulta un perfil de la Base de Datos.
     * 
     * @param id el id del perfil deseado
     * @return el perfil consultado
     */
    @Override
    public Perfil get(Long id) {
        log.info("Consultando perfil por id: {}",id);
        return perfilRepo.findById(id).get();
    }

    /**
     * Elimina un perfil en la Base de Datos.
     * 
     * @param id el id del perfil a eliminar
     * @return verdadero si la funcion fue exitosa, falso si hubo un error
     */
    @Override
    public Boolean eliminar(Long id) {
        log.info("Eliminando perfil por id: {}",id);
        perfilRepo.deleteById(id);
        return Boolean.TRUE;
    }
}