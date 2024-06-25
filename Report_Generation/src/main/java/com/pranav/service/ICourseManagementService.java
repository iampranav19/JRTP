package com.pranav.service;

import java.util.*;

import javax.naming.directory.SearchResult;

import com.pranav.model.SearchInput;

import jakarta.servlet.http.HttpServletResponse;


public interface ICourseManagementService {

	// To avoid the duplicates 
	Set<String> showAllCourseCategories();
	
	Set<String> showAllTrainingModes();
	
	Set<String> showAllFaculties();
	
	public List<SearchResult> showCoursesByFilter(SearchInput input);
	
	// To provide the download functionality
	public void generatePdfReport(SearchInput input, HttpServletResponse response);
	
	public void generateExcelReport(SearchInput input, HttpServletResponse response);
	
	
	
}
