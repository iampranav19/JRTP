package com.pranav.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchResults {

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

	
}
