package com.pranav.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "TRAVEL_PLAN")
@Data
public class TravelPlan {
	
	/*
	 Auto is also one of the generator that internally uses Seqence in Oracle
	 Always start with 1 and increment by 1
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer planId;
	
	@Column(name = "PLANT_NAME",length = 40)
	private String planName;
	
	@Column(name = "PLANT_DESCRIPTION",length = 100)
	private String planDescription;
	
	@Column(name = "MIN_BUDGET")
	private Double minBudget;
	
	@Column(name = "ACTIVE_SW")
	private String activeSW="active";
	
	// common columns
	@Column(name = "CREATED_DATE",updatable = false) // by default it is true
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name = "CATEGOTY_ID")
	private Integer planCategoryId;
	
	
	@Column(name = "UPDATED_DATE", insertable = false,updatable = true)
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
	@Column(name = "CREATED_BY",length = 30)
	private String createdBy;
	
	@Column(name = "UPDATED_BY",length = 30)
	private String updatedBy;
	
	

}
