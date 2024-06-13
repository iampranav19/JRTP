package com.pranav.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pranav.config.AppConfigProperties;
import com.pranav.constants.TravelPlanConstants;
import com.pranav.entities.PlanCategory;
import com.pranav.entities.TravelPlan;
import com.pranav.repositories.IPlanCategoryRepository;
import com.pranav.repositories.ITravelPlanRepository;

@Service
public class TravelPlanService {

    @Autowired
    private ITravelPlanRepository travelPlanRepository;

    @Autowired
    private IPlanCategoryRepository iPlanCategoryRepository;
    
    private final AppConfigProperties appConfigProperties;

    @Autowired
    public TravelPlanService(AppConfigProperties appConfigProperties) {
        this.appConfigProperties = appConfigProperties;
    }
   

    /**
     * Registers a new travel plan.
     *
     * @param travelPlan the travel plan to be registered
     * @return a message indicating the result of the operation
     */
    public String registerTravelPlan(TravelPlan travelPlan) {
        TravelPlan savedPlan = travelPlanRepository.save(travelPlan);
        return savedPlan.getPlanId() != null ? appConfigProperties.getMessages().get(TravelPlanConstants.SAVE_SUCCESS) : appConfigProperties.getMessages().get(TravelPlanConstants.SAVE_SUCCESS);
    }

    /**
     * Retrieves all travel plan categories.
     *
     * @return a map of category IDs to category names
     */
    public Map<Integer, String> getTravelPlanCategory() {
        List<PlanCategory> list = iPlanCategoryRepository.findAll();
        Map<Integer, String> categoryMap = new HashMap<>();
        list.forEach(c -> categoryMap.put(c.getCategoryId(), c.getCategoryName()));
        return categoryMap;
    }

    /**
     * Retrieves all travel plans.
     *
     * @return a list of all travel plans
     */
    public List<TravelPlan> showAllTravelPlan() {
        return travelPlanRepository.findAll();
    }

    /**
     * Deletes a travel plan by its ID.
     *
     * @param id the ID of the travel plan to be deleted
     * @return a message indicating the result of the operation
     */
    public String deleteTravelPlan(Integer id) {
        travelPlanRepository.deleteById(id);
        return "Deleted Successfully";
    }

    /**
     * Retrieves a travel plan by its ID.
     *
     * @param planId the ID of the travel plan to be retrieved
     * @return the travel plan with the specified ID
     * @throws IllegalArgumentException if no travel plan with the specified ID is found
     */
    public TravelPlan showTravelPlanById(Integer planId) {
        return travelPlanRepository.findById(planId)
            .orElseThrow(() -> new IllegalArgumentException("Travel Plan not found"));
    }

    /**
     * Updates an existing travel plan.
     *
     * @param travelPlan the travel plan with updated details
     * @return a message indicating the result of the operation
     * @throws IllegalArgumentException if no travel plan with the specified ID is found
     */
    public String updateTravelPlan(TravelPlan travelPlan) {
        travelPlanRepository.findById(travelPlan.getPlanId())
            .orElseThrow(() -> new IllegalArgumentException("Travel Plan not found"));
        travelPlanRepository.save(travelPlan);
        return "Updated Successfully";
    }

    /**
     * Changes the status of a travel plan (for soft deletion).
     *
     * @param planId the ID of the travel plan whose status is to be changed
     * @param status the new status of the travel plan
     * @return a message indicating the result of the operation
     * @throws IllegalArgumentException if no travel plan with the specified ID is found
     */
    public String changeTravelPlanStatus(Integer planId, String status) {
        TravelPlan plan = travelPlanRepository.findById(planId)
            .orElseThrow(() -> new IllegalArgumentException("Travel Plan not found"));
        plan.setActiveSW(status);
        travelPlanRepository.save(plan);
        return "Travel Plan status updated";
    }
}
