package com.example.plantproject.planttip;

import java.util.List;

public interface PlantTips {
     int createPlantTip(String name, int watering, int feeding, int spraying, String notes);
     int updatePlantTip(com.example.plantproject.entity.PlantTip plantTip);
     int deletePlantTip(Integer id);
     com.example.plantproject.entity.PlantTip getPlantTip(String name);
    public List<com.example.plantproject.entity.PlantTip> getPlantTips();
    }

