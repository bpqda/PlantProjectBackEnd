package com.example.plantproject;

import java.util.List;

import com.example.plantproject.entity.PlantTip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class PlantTipRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createPlantTip(String name, int watering, int feeding, int spraying, String notes){
        return jdbcTemplate.update("INSERT INTO \"plant_tips\" (\"name\", \"watering\", \"feeding\", \"spraying\", \"notes\") VALUES(?, ?, ?, ?, ?)", name, watering, feeding, spraying, notes);
    }

    public int updatePlantTip(PlantTip plantTip){
        return jdbcTemplate.update("UPDATE \"plant_tips\" SET \"name\" = ? WHERE \"id\" = ?", plantTip.getName(), plantTip.getId());
    }

    public int deletePlantTip(Integer id){
        return jdbcTemplate.update("DELETE FROM \"plant_tips\" WHERE \"id\" = ?",id);
    }

    public PlantTip getPlantTip(String name){
        return jdbcTemplate.queryForObject("SELECT * FROM \"plant_tips\" WHERE \"name\"=?", new PlantTipMapper(), name);
    }

    public List<PlantTip> getPlantTips(){
        return jdbcTemplate.query("SELECT * FROM \"plant_tips\"", new PlantTipMapper());
    }
}
