package com.eflores.StreamingPlatform.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eflores.StreamingPlatform.model.Plan;

public interface PlanRepo extends JpaRepository<Plan, Long>{
    
}
