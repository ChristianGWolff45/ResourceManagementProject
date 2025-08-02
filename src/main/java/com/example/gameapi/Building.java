package com.example.gameapi;

import java.util.HashMap;
import java.util.Map;

abstract class Building {
    private int buildingCount;
    private final int workersPerBuilding;
    private Map<String, Integer> production = new HashMap<>();
    private Map<String, Integer> workerCount = new HashMap<>();
    private final int buildTime;
    private Map<String, Integer> buildingCost = new HashMap<>();
    private String buildingName;

    public Building(int newBuildingCount, int newWorkersPerBuilding, 
                    Map<String, Integer> newProduction, Map<String, Integer> newWorkerCount,
                    int newBuildTime, Map<String, Integer> newBuildingCost, String newBuildingName){
        buildingCount = newBuildingCount;
        workersPerBuilding = newWorkersPerBuilding;
        production = newProduction;
        workerCount = newWorkerCount;
        buildTime = newBuildTime;
        buildingCost = newBuildingCost;
        buildingName = newBuildingName;
    }

    public int getBuildingCount(){
        return buildingCount;
    }
    public void setBuildingCount(int num){
        if (num > 0){
            buildingCount = num;
        }
    }
    public void addBuilding(){
        buildingCount += 1;
    }
    public void subtractBuilding(){
        buildingCount -= 1;
    }

    public int getMaxWorkers(){
        return workersPerBuilding * buildingCount;
    }
    

    public Map<String, Integer> getProduction(){
        return production;
    }

    public Map<String, Integer> getWorkerCount(){
        return workerCount;
    }
    public void addWorker(String workerType){
        if(workerCount.containsKey(workerType)){
            if(workerCount.get(workerType) + 1 <= workersPerBuilding * buildingCount){
                
                workerCount.put(workerType, workerCount.get(workerType) + 1);
            }
        }
    }
    public void subtractWorker(String workerType){
        if(workerCount.containsKey(workerType)){
            if(workerCount.get(workerType) - 1 >= 0){
                
                workerCount.put(workerType, workerCount.get(workerType) - 1);
            }
        }
    }
    public Map<String, Integer> getBuildingCost(){
        return buildingCost;
    }
    public int getBuildTime(){
        return buildTime;
    }
    public String getBuildingName(){
        return buildingName;
    }
}   
