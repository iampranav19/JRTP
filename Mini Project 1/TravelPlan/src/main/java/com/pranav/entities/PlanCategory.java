package com.pranav.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.Collate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "PLAN_CATEGORY")
@Data
public class PlanCategory {
	
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "category_seq",initialValue = 1,allocationSize = 1)
	@Column(name = "CATEGORY_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer categoryId;
	
	@Column(name = "CATOGORT_NAME",length = 30)
	private String categoryName;
	
	@Column(name = "ACTIVE_SW",length = 15)
	private String activeSw="active";
	
	@Column(name = "CREATED_DATE",updatable = false) // by default it is true
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	
	@Column(name = "UPDATED_DATE", insertable = false,updatable = true)
	@UpdateTimestamp
	private LocalDateTime updatedDate;
	
	@Column(name = "CREATED_BY",length = 30)
	private String createdBy;
	
	@Column(name = "UPDATED_BY",length = 30)
	private String updatedBy;
	
	
	

}
