package com.eflores.StreamingPlatform.enumeration;

public enum Plan {
    PLAN_BASICO(0),
    PLAN_INTERMEDIO(1),
    PLAN_AVANZADO(2);

    private final Integer plan;

    Plan(Integer plan){
        this.plan = plan;
    }

    public Integer getPlan(){
        return this.plan;
    }
}
