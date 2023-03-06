package com.eflores.StreamingPlatform.controller;

import static java.time.LocalDateTime.now;
import static java.util.Map.of;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eflores.StreamingPlatform.model.Perfil;
import com.eflores.StreamingPlatform.model.Respuesta;
import com.eflores.StreamingPlatform.service.implementation.PerfilServiceImplementation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/perfil")
@RequiredArgsConstructor
public class PerfilController {
    private final PerfilServiceImplementation perfilService;

    @PostMapping("/crear")
    public ResponseEntity<Respuesta> crearPerfil(@RequestBody @Valid Perfil perfil){
        return ResponseEntity.ok(
            Respuesta.builder()
                    .timeStamp(now())
                    .data(of("perfil",perfilService.crear(perfil)))
                    .mensaje("Perfil exitosamente creado")
                    .status(CREATED)
                    .codigoStatus(CREATED.value())
                    .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Respuesta> getPerfil(@PathVariable("id") Long id){
        return ResponseEntity.ok(
            Respuesta.builder()
                    .timeStamp(now())
                    .data(of("perfil",perfilService.get(id)))
                    .mensaje("Perfil exitosamente obtenido")
                    .status(OK)
                    .codigoStatus(OK.value())
                    .build()
        );
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Respuesta> eliminarPerfil(@PathVariable("id") Long id){
        return ResponseEntity.ok(
            Respuesta.builder()
                    .timeStamp(now())
                    .data(of("eliminados",perfilService.eliminar(id)))
                    .mensaje("Perfil exitosamente eliminado")
                    .status(OK)
                    .codigoStatus(OK.value())
                    .build()
        );
    }

    @PostMapping("/modificar")
    public ResponseEntity<Respuesta> modificarPerfil(@RequestBody @Valid Perfil perfil){
        return ResponseEntity.ok(
            Respuesta.builder()
                    .timeStamp(now())
                    .data(of("perfil",perfilService.modificar(perfil)))
                    .mensaje("Perfil exitosamente modificado")
                    .status(CREATED)
                    .codigoStatus(CREATED.value())
                    .build()
        );
    }
}
