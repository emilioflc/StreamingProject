package com.eflores.StreamingPlatform.service;

import java.util.Collection;

import com.eflores.StreamingPlatform.model.Plan;

public interface PlanService {
    Plan crear(Plan plan);
    Plan modificar(Plan plan);
    Collection<Plan> listAll(int limit);
    Plan get(Long id);
    Boolean eliminar(Long id);
}
