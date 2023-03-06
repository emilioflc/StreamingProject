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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.HttpStatus.OK;

import java.io.File;
import java.io.IOException;

import static org.springframework.http.HttpStatus.CREATED;



import com.eflores.StreamingPlatform.model.Respuesta;
import com.eflores.StreamingPlatform.model.Usuario;
import com.eflores.StreamingPlatform.service.implementation.UsuarioServiceImplementation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioController {
    private final UsuarioServiceImplementation usuarioService;

    @GetMapping("/reporte")
    public ResponseEntity<Respuesta> getUsuarios(){
        return ResponseEntity.ok(
            Respuesta.builder()
                    .timeStamp(now())
                    .data(of("usuarios",usuarioService.listAll(30)))
                    .mensaje("Usuarios exitosamente obtenidos")
                    .status(OK)
                    .codigoStatus(OK.value())
                    .build()
        );
    }

    @PostMapping("/crear")
    public ResponseEntity<Respuesta> crearUsuario(@RequestBody @Valid Usuario usuario, @RequestParam("file") MultipartFile fotoPerfil) throws IOException{
        if (!fotoPerfil.isEmpty()) {
            String pathImagen = getClass().getResource("/resources/userImages").getPath();
            fotoPerfil.transferTo(new File(pathImagen + fotoPerfil.getOriginalFilename()));
            usuario.setPathFotoPerfil(pathImagen + fotoPerfil.getOriginalFilename());
        }
        return ResponseEntity.ok(
            Respuesta.builder()
                    .timeStamp(now())
                    .data(of("usuario",usuarioService.crear(usuario)))
                    .mensaje("Usuario exitosamente creado")
                    .status(CREATED)
                    .codigoStatus(CREATED.value())
                    .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Respuesta> getUsuario(@PathVariable("id") Long id){
        return ResponseEntity.ok(
            Respuesta.builder()
                    .timeStamp(now())
                    .data(of("usuario",usuarioService.get(id)))
                    .mensaje("Usuario exitosamente obtenido")
                    .status(OK)
                    .codigoStatus(OK.value())
                    .build()
        );
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Respuesta> eliminarUsuario(@PathVariable("id") Long id) throws IOException{
        return ResponseEntity.ok(
            Respuesta.builder()
                    .timeStamp(now())
                    .data(of("eliminados",usuarioService.eliminar(id)))
                    .mensaje("Usuario exitosamente eliminado")
                    .status(OK)
                    .codigoStatus(OK.value())
                    .build()
        );
    }

    @PostMapping("/modificar")
    public ResponseEntity<Respuesta> modificarUsuario(@RequestBody @Valid Usuario usuario, @RequestParam("file") MultipartFile fotoPerfil) throws IOException{
        if (!fotoPerfil.isEmpty()) {
            String pathImagen = getClass().getResource("/resources/userImages").getPath();
            fotoPerfil.transferTo(new File(pathImagen + fotoPerfil.getOriginalFilename()));
            usuario.setPathFotoPerfil(pathImagen + fotoPerfil.getOriginalFilename());
        }
        return ResponseEntity.ok(
            Respuesta.builder()
                    .timeStamp(now())
                    .data(of("usuario",usuarioService.modificar(usuario)))
                    .mensaje("Usuario exitosamente creado")
                    .status(CREATED)
                    .codigoStatus(CREATED.value())
                    .build()
        );
    }
}
