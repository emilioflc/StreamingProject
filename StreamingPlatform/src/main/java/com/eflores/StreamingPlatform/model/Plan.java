package com.eflores.StreamingPlatform.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import static jakarta.persistence.GenerationType.AUTO;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Plan {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String nombre;
    private String descripcion;
    private Integer maxPerfiles;
    private Usuario usuarioCreador;
    private LocalDateTime fechaCreacion;
    private Usuario usuarioModificador;
    private LocalDateTime fechaModificacion;
}
