package com.example.gameapi;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class Resources {
    private int wood = 100;
    private int stone = 100;
    private int coal = 0;
    private int ore = 0;
    private int fish = 0;
    private int metal = 0;
    private int wheat = 0;
    private int flour = 0;
    private int bread = 0;

    public void changeWood(int woodChange){wood += woodChange;}
    public void changeStone(int stoneChange){stone += stoneChange;}
    public void coalChange(int coalChange){coal += coalChange;}
    public void changeOre(int oreChange){ore += oreChange;}
    public void changeFish(int fishChange){fish += fishChange;}
    public void changeMetal(int metalChange){metal += metalChange;}
    public void changeWheat(int wheatChange){wheat += wheatChange;}
    public void changeFlour(int flourChange){flour += flourChange;}
    public void changeBread(int breadChange){bread += breadChange;}

    public Map<String, Integer> getAllResources() {
    Map<String, Integer> map = new HashMap<>();
        map.put("wood", wood);
        map.put("stone", stone);
        map.put("coal", coal);
        map.put("ore", ore);
        map.put("fish", fish);
        map.put("metal", metal);
        map.put("wheat", wheat);
        map.put("flour", flour);
        map.put("bread", bread);
        return map;
    }
}
