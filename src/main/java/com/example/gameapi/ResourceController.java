package com.example.gameapi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ResourceController {

    private final LumberMill LM;
    private final Resources resourceData;

    public ResourceController(LumberMill newLM, Resources newResourceData) {
        this.LM = newLM;
        this.resourceData = newResourceData;
    }
    @GetMapping("/resourceData")
    public Map<String, Integer> getResources() {
        return resourceData.getAllResources();
    }
    @GetMapping("/LM")
    public Map<String, Integer> getLumbermillStatsMap() {
        Map<String, Integer> response = new HashMap<>();
        response.put("MaxWorker", LM.getMaxWorkers());
        response.put("buildingCount", LM.getBuildingCount());
        
        return response;
    }

    @GetMapping("/LM/getProduction")
    public int getWoodOutput(){
        return LM.getWoodProduction();
    }

    @PostMapping("/LM/build")
    public int buildLumberMill(){
        LM.addBuilding();
        return LM.getBuildingCount();
    }

    @PostMapping("/LM/addWoodWorker")
    public Map<String, Integer> addWoodWorker(){
        LM.addWoodWorker();
        Map<String, Integer> response = new HashMap<>();
        response.put("woodWorkerCount", LM.getWoodWorkers());
        response.put("woodProduction", LM.getWoodProduction());
        return response;
    }

    @PostMapping("/LM/removeWoodWorker")
    public Map<String, Integer> removeWoodWorker(){
        LM.removeWoodWorker();
        Map<String, Integer> response = new HashMap<>();
        response.put("woodWorkerCount", LM.getWoodWorkers());
        response.put("woodProduction", LM.getWoodProduction());
        return response;
    }
}