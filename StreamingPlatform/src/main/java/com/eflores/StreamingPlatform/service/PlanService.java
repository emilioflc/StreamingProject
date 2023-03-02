package com.eflores.StreamingPlatform.service;

import com.eflores.StreamingPlatform.model.Plan;

public interface PlanService {
    Plan crear(Plan plan);
    Plan modificar(Plan plan);
    Plan get(Long id);
    Boolean eliminar(Long id);
}
