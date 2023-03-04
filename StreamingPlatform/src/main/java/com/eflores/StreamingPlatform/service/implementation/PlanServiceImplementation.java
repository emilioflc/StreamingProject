package com.eflores.StreamingPlatform.service.implementation;

import java.util.Collection;

import static org.springframework.data.domain.PageRequest.of;
import org.springframework.stereotype.Service;

import com.eflores.StreamingPlatform.model.Plan;
import com.eflores.StreamingPlatform.repo.PlanRepo;
import com.eflores.StreamingPlatform.service.PlanService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class PlanServiceImplementation implements PlanService{

    private final PlanRepo planRepo;

    /**
     * Crea un plan en la Base de Datos.
     * 
     * @param plan el plan a agregar
     * @return el plan agregado
     */
    @Override
    public Plan crear(Plan plan) {
        log.info("Creando nuevo plan: {}",plan.getId());
        return planRepo.save(plan);
    }


    /**
     * Lista todos los planes de la Base de Datos.
     * 
     * @return todos los planes de la Base de Datos
     */
    @Override
    public Collection<Plan> listAll(int limit) {
        log.info("Obteniendo todos los ultimos {} planes...", limit);
        return planRepo.findAll(of(0, limit)).toList();
    }

    /**
     * Modifica un plan en la Base de Datos.
     * 
     * @param plan el plan a modificar
     * @return el plan modificado
     */
    @Override
    public Plan modificar(Plan plan) {
        log.info("Modificando plan: {}",plan.getId());
        return planRepo.save(plan);
    }


    /**
     * Consulta un plan de la Base de Datos.
     * 
     * @param id el id del plan deseado
     * @return el plan consultado
     */
    @Override
    public Plan get(Long id) {
        log.info("Consultando plan por id: {}",id);
        return planRepo.findById(id).get();
    }

    /**
     * Elimina un plan en la Base de Datos.
     * 
     * @param id el id del plan a eliminar
     * @return verdadero si la funcion fue exitosa, falso si hubo un error
     */
    @Override
    public Boolean eliminar(Long id) {
        log.info("Eliminando plan por id: {}",id);
        planRepo.deleteById(id);
        return Boolean.TRUE;
    }
}