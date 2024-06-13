package com.pranav.controllers;

import com.pranav.entities.TravelPlan;
import com.pranav.service.TravelPlanService;

import ch.qos.logback.classic.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/travelPlan/api")
public class TravelPlanController {
	private static final Logger logger = (Logger) LoggerFactory.getLogger(TravelPlanController.class);

	private Map<String,String> props=new HashMap<>();
	@Autowired
	public TravelPlanController(Map<String,String> props) {
		// TODO Auto-generated constructor stub
		this.props=props;
	}

	@Autowired
	private TravelPlanService travelPlanService;

	/**
	 * Registers a new travel plan.
	 *
	 * @param travelPlan the travel plan to be registered
	 * @return ResponseEntity with a message indicating the result of the operation
	 *         and the appropriate status code
	 */
	@PostMapping("/register")
    public ResponseEntity<String> registerTravelPlan(@RequestBody TravelPlan travelPlan) {
        try {
            logger.info("Registering travel plan: {}", travelPlan);
            // Validate travelPlan object here if necessary
            String result = travelPlanService.registerTravelPlan(travelPlan);
            return new ResponseEntity<>(result,HttpStatus.CREATED);
        } catch (Exception e) {
            logger.error("Error registering travel plan", e);
            return new ResponseEntity<>("Error registering travel plan: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

	/**
	 * Retrieves all travel plan categories.
	 *
	 * @return ResponseEntity with a map of category IDs to category names and the
	 *         appropriate status code
	 */
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> getTravelPlanCategory() {
		try {
			Map<Integer, String> categories = travelPlanService.getTravelPlanCategory();
			return new ResponseEntity<>(categories, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Retrieves all travel plans.
	 *
	 * @return ResponseEntity with a list of all travel plans and the appropriate
	 *         status code
	 */
	@GetMapping("/all")
	public ResponseEntity<List<TravelPlan>> showAllTravelPlan() {
		try {
			List<TravelPlan> travelPlans = travelPlanService.showAllTravelPlan();
			return new ResponseEntity<>(travelPlans, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Deletes a travel plan by its ID.
	 *
	 * @param id the ID of the travel plan to be deleted
	 * @return ResponseEntity with a message indicating the result of the operation
	 *         and the appropriate status code
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTravelPlan(@PathVariable Integer id) {
		try {
			String result = travelPlanService.deleteTravelPlan(id);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Error deleting travel plan", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Retrieves a travel plan by its ID.
	 *
	 * @param id the ID of the travel plan to be retrieved
	 * @return ResponseEntity with the travel plan and the appropriate status code
	 */
	@GetMapping("/{id}")
	public ResponseEntity<TravelPlan> showTravelPlanById(@PathVariable Integer id) {
		try {
			TravelPlan travelPlan = travelPlanService.showTravelPlanById(id);
			return new ResponseEntity<>(travelPlan, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Updates an existing travel plan.
	 *
	 * @param travelPlan the travel plan with updated details
	 * @return ResponseEntity with a message indicating the result of the operation
	 *         and the appropriate status code
	 */
	@PutMapping("/update")
	public ResponseEntity<String> updateTravelPlan(@RequestBody TravelPlan travelPlan) {
		try {
			String result = travelPlanService.updateTravelPlan(travelPlan);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>("Travel Plan not found", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>("Error updating travel plan", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Changes the status of a travel plan (for soft deletion).
	 *
	 * @param id     the ID of the travel plan whose status is to be changed
	 * @param status the new status of the travel plan
	 * @return ResponseEntity with a message indicating the result of the operation
	 *         and the appropriate status code
	 */
	@PatchMapping("/status/{id}")
	public ResponseEntity<String> changeTravelPlanStatus(@PathVariable Integer id, @RequestParam String status) {
		try {
			String result = travelPlanService.changeTravelPlanStatus(id, status);
			return new ResponseEntity<>(result, HttpStatus.OK);
		} catch (IllegalArgumentException e) {
			return new ResponseEntity<>("Travel Plan not found", HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<>("Error updating travel plan status", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
