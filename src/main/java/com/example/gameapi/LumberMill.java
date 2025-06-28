package com.example.gameapi;

import org.springframework.stereotype.Service;

@Service
public class LumberMill {
    private int buildingCount = 0;
    private int workersPerBuilding = 4;
    private int woodProduction = 3;
    private int woodWorkers = 0;

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

    public void addBuilding(){
        buildingCount += 1;
    }

    public void addWoodWorker() {
        if(woodWorkers < this.getMaxWorkers())
            woodWorkers += 1;
    }

    public void removeWoodWorker() {
        if(woodWorkers > 1)
            woodWorkers -= 1;
    }

}
