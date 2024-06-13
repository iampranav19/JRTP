package com.pranav.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranav.entities.TravelPlan;

public interface ITravelPlanRepository extends JpaRepository<TravelPlan, Integer>{

}
