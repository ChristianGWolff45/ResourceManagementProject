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

    private final LumberMill lumbermill;
    private final Resources resourceData;

    public ResourceController(LumberMill newLM, Resources newResourceData) {
        this.lumbermill = newLM;
        this.resourceData = newResourceData;
    }
    @GetMapping("/resourceData")
    public Map<String, Integer> getResources() {
        return resourceData.getAllResources();
    }
    @GetMapping("/lumbermill")
    public Map<String, Integer> getLumbermillStatsMap() {
        Map<String, Integer> response = new HashMap<>();
        response.put("MaxWorker", lumbermill.getMaxWorkers());
        response.put("buildingCount", lumbermill.getBuildingCount());
        
        return response;
    }

    @GetMapping("/lumbermill/getProduction")
    public int getWoodOutput(){
        return lumbermill.getWoodProduction();
    }

    @PostMapping("/lumbermill/addWorker/woodWorker")
    public int addWoodWorker(){
        lumbermill.addWoodWorker();
        return lumbermill.getWoodWorkers();
    }

    @PostMapping("/lumbermill/subtractWorker/woodWorker")
    public int removeWoodWorker(){
        lumbermill.removeWoodWorker();
        return lumbermill.getWoodWorkers();
    }

    @PostMapping("/lumbermill/buildStart")
    public int buildLumbermill(){
        if(lumbermill.canBuildLumbermill(resourceData.getWood(), resourceData.getStone())){
            Map<String, Integer> cost = lumbermill.getBuildingCost();
            resourceData.changeWood(-(cost.get("wood")));
            resourceData.changeStone(-(cost.get("stone")));
            return lumbermill.getBuildTime();
        }
        return 0;
    }
    @PostMapping("/lumbermill/buildFinish")
    public void addLumbermill(){
        lumbermill.addLumbermill();
    }

    @PostMapping("/production")
    public void produceAll(){
        resourceData.changeWood(lumbermill.getWoodProduction());
    }
}