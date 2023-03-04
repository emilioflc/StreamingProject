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

import static org.springframework.http.HttpStatus.OK;

import static org.springframework.http.HttpStatus.CREATED;



import com.eflores.StreamingPlatform.model.Respuesta;
import com.eflores.StreamingPlatform.model.Pago;
import com.eflores.StreamingPlatform.service.implementation.PagoServiceImplementation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/pago")
@RequiredArgsConstructor
public class PagoController {
    private final PagoServiceImplementation pagoService;

    @GetMapping("/reporte")
    public ResponseEntity<Respuesta> getPagos(){
        return ResponseEntity.ok(
            Respuesta.builder()
                    .timeStamp(now())
                    .data(of("pagos",pagoService.listAll(30)))
                    .mensaje("Pagos exitosamente obtenidos")
                    .status(OK)
                    .codigoStatus(OK.value())
                    .build()
        );
    }

    @PostMapping("/crear")
    public ResponseEntity<Respuesta> crearPago(@RequestBody @Valid Pago pago){
        return ResponseEntity.ok(
            Respuesta.builder()
                    .timeStamp(now())
                    .data(of("pago",pagoService.crear(pago)))
                    .mensaje("Pago exitosamente creado")
                    .status(CREATED)
                    .codigoStatus(CREATED.value())
                    .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Respuesta> getPago(@PathVariable("id") Long id){
        return ResponseEntity.ok(
            Respuesta.builder()
                    .timeStamp(now())
                    .data(of("pago",pagoService.get(id)))
                    .mensaje("Pago exitosamente obtenido")
                    .status(OK)
                    .codigoStatus(OK.value())
                    .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Respuesta> eliminarPago(@PathVariable("id") Long id){
        return ResponseEntity.ok(
            Respuesta.builder()
                    .timeStamp(now())
                    .data(of("eliminados",pagoService.eliminar(id)))
                    .mensaje("Pago exitosamente eliminado")
                    .status(OK)
                    .codigoStatus(OK.value())
                    .build()
        );
    }
}
