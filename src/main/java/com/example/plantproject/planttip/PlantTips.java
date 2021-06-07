package com.example.plantproject.planttip;

import com.example.plantproject.entity.PlantTip;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlantTips {
     int createPlantTip(String name, int watering, int feeding, int spraying, String notes);
     int updatePlantTip(PlantTip plantTip);
     int deletePlantTip(Integer id);
     PlantTip getPlantTip(String name);
     List<PlantTip> getPlantTips();
    }

