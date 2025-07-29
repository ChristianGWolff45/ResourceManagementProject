package com.example.gameapi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service
public class FishingHut extends Building{
    // buildingCount = 1;
    // workersPerBuilding = 4;
    // lumbermillProduction = wood: 3;
    // lumbermillWorkers woodWorkers: 0;
    // private int buildTime = 30000;
    // buildingCost = wood: 10, stone: 5;
    // name = "fishingHut"
    public FishingHut(){
        super(
            1,
            4,
            new HashMap<>(Map.of("fish", 3)),
            new HashMap<>(Map.of("fishWorker", 0)),
            30000,
            new HashMap<>(Map.of("wood", 10, "stone", 5)),
            "fishingHut"
        );
    }

}
