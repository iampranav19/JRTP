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
@Table(name="COURSE_DETAILS")
@Data
public class CourseDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int courseId;
	private String courseName;
	private String location;
	private String courseCategory;
	private String facultyName;
	private Double fees;
	private String adminName;
	private Long adminContact;
	private String trainingMode;
	private LocalDateTime startDate;
	private String courses;
	private String courseStatus;
	@CreationTimestamp
	@Column(insertable = true,updatable = false)
	private LocalDateTime creationDate;
	
	@UpdateTimestamp
	@Column(insertable = false,updatable = true)
	private LocalDateTime updationDate;
	private String createdBy;
	private String updatedBy;
	
}
