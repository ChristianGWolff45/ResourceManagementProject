package com.example.gameapi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ResourceController {
    
    private final Lumbermill lumbermill;
    private final Resources resourceData;
    private final FishingHut fishingHut;
    private Building[] buildings;

    public ResourceController(FishingHut newFishingHut, Lumbermill newLM, 
                              Resources newResourceData) {
        this.lumbermill = newLM;
        this.resourceData = newResourceData;
        this.fishingHut = newFishingHut;
        this.buildings = new Building[] { lumbermill, fishingHut };

    }
    @GetMapping("/resourceData")
    public Map<String, Integer> getResources() {
        return resourceData.getAllResources();
    }

    @GetMapping("/buildingStats")
    public Map<String, Map<String, Integer>> getBuildingStatsMap() {
        Map<String, Map<String, Integer>> response = new HashMap<>();

        for (Building building : buildings) {
            Map<String, Integer> tempMap = new HashMap<>();
            tempMap.put("MaxWorker", building.getMaxWorkers());
            tempMap.put("buildingCount", building.getBuildingCount());

            response.put(building.getBuildingName(), tempMap);
        }
        return response;
    }

    // @GetMapping("/getProduction")
    // public void production(){
        
    // }

    @PostMapping("/addWorker")
    public Map<String, Integer> addWoodWorker(@RequestBody Map<String, String> request){
        for(Building buildings : buildings){
            
            if(buildings.getBuildingName().equals(request.get("buildingName"))){
                buildings.addWorker(request.get("workerType"));
                return buildings.getWorkerCount();
            }
        }
        throw new IllegalArgumentException("Building not found " + request.get("buildingName"));
        
    }

    // @PostMapping("/lumbermill/subtractWorker/woodWorker")
    // public int removeWoodWorker(){
    //     lumbermill.removeWoodWorker();
    //     return lumbermill.getWoodWorkers();
    // }

    // @PostMapping("/lumbermill/buildStart")
    // public int buildLumbermill(){
    //     if(lumbermill.canBuildLumbermill(resourceData.getWood(), resourceData.getStone())){
    //         Map<String, Integer> cost = lumbermill.getBuildingCost();
    //         resourceData.changeWood(-(cost.get("wood")));
    //         resourceData.changeStone(-(cost.get("stone")));
    //         return lumbermill.getBuildTime();
    //     }
    //     return 0;
    // }
    // @PostMapping("/lumbermill/buildFinish")
    // public void addLumbermill(){
    //     lumbermill.addLumbermill();
    // }

    // @PostMapping("/production")
    // public void produceAll(){
    //     for(int i = 0)
    // }

    // @GetMapping("/workerCount")
    // public Map<String, Integer> updateWorkerCount(){
    //     Map<String, Integer> workerCount = new HashMap<>();
    //     workerCount.put()

    //     return workerCount;
    // }

    // @GetMapping("/buildingCount")
    // public int updateBuildingCount(){
    //     return lumbermill.getBuildingCount();
    // }
}   