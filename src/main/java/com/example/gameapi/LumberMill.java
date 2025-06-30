package com.example.gameapi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service
public class LumberMill {
    private int buildingCount = 1;
    private int workersPerBuilding = 4;
    private int woodProduction = 3;
    private int woodWorkers = 0;
    private int buildTime = 30000;
    private Map<String, Integer> buildingCost = new HashMap<>();
    
    public LumberMill(){
        buildingCost.put("wood", 30);
        buildingCost.put("stone", 15);
    }

    public Map<String, Integer> getBuildingCost(){
        return buildingCost;
    }

    public int getMaxWorkers(){
        return buildingCount * workersPerBuilding;
    }

    public int getBuildingCount(){
        return buildingCount;
    }

    public int getWoodProduction(){

        return woodProduction * woodWorkers;
    }

    public int getWoodWorkers(){
        return woodWorkers;
    }

    public void addWoodWorker() {
        if(woodWorkers < this.getMaxWorkers())
            woodWorkers += 1;
    }

    public void removeWoodWorker() {
        if(woodWorkers > 0)
            woodWorkers -= 1;
    }

    public int getBuildTime(){
        return buildTime;
    }

    public boolean canBuildLumbermill(int lumber, int stone) {
        if (lumber >= buildingCost.get("wood") && stone >= buildingCost.get("stone")) {
            return true;
        } else {
            return false;
        }
    }

    public void addLumbermill(){
        buildingCount++;
    }


}
