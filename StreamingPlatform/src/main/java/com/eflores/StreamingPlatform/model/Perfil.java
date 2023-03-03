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
public class Perfil {
    @Id @GeneratedValue(strategy = AUTO)
    private Long id;

    private String usuarioCreador;
    private String alias;
    private Boolean mayorEdad;
    private LocalDateTime fechaCreacion;
    private String usuarioModificador;
    private LocalDateTime fechaModificacion;
}
