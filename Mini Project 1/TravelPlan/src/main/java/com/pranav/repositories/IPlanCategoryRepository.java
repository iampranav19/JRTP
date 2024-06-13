package com.pranav.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pranav.entities.PlanCategory;

public interface IPlanCategoryRepository extends JpaRepository<PlanCategory, Integer> {

}
