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

import com.eflores.StreamingPlatform.model.Plan;
import com.eflores.StreamingPlatform.model.Respuesta;
import com.eflores.StreamingPlatform.service.implementation.PlanServiceImplementation;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor
public class PlanController {
    private final PlanServiceImplementation planService;

    @PostMapping("/crear")
    public ResponseEntity<Respuesta> crearPlan(@RequestBody @Valid Plan plan){
        return ResponseEntity.ok(
            Respuesta.builder()
                    .timeStamp(now())
                    .data(of("plan",planService.crear(plan)))
                    .mensaje("Plan exitosamente creado")
                    .status(CREATED)
                    .codigoStatus(CREATED.value())
                    .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Respuesta> getPlan(@PathVariable("id") Long id){
        return ResponseEntity.ok(
            Respuesta.builder()
                    .timeStamp(now())
                    .data(of("plan",planService.get(id)))
                    .mensaje("Plan exitosamente obtenido")
                    .status(OK)
                    .codigoStatus(OK.value())
                    .build()
        );
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Respuesta> eliminarPlan(@PathVariable("id") Long id){
        return ResponseEntity.ok(
            Respuesta.builder()
                    .timeStamp(now())
                    .data(of("eliminados",planService.eliminar(id)))
                    .mensaje("Plan exitosamente eliminado")
                    .status(OK)
                    .codigoStatus(OK.value())
                    .build()
        );
    }

    @PostMapping("/modificar")
    public ResponseEntity<Respuesta> modificarPlan(@RequestBody @Valid Plan plan){
        return ResponseEntity.ok(
            Respuesta.builder()
                    .timeStamp(now())
                    .data(of("plan",planService.modificar(plan)))
                    .mensaje("Plan exitosamente modificado")
                    .status(CREATED)
                    .codigoStatus(CREATED.value())
                    .build()
        );
    }
}
