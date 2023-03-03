package com.eflores.StreamingPlatform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

import static jakarta.persistence.GenerationType.AUTO;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id @GeneratedValue(strategy = AUTO)
    private Long id;

    private String nombres;
    private String apellidos;
    private LocalDate fechaNacimiento;

    @Column(unique=true)
    @NotEmpty(message = "Se debe proporcionar un correo para continuar.")
    private String correo;
    
    private String password;
    private Long plan;
    private String pathFotoPerfil;
    private LocalDateTime vencimientoPlan;
    private String usuarioCreador;
    private LocalDateTime fechaCreacion;
    private String usuarioModificador;
    private LocalDateTime fechaModificacion;

}
