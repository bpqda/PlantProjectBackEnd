package com.example.plantproject.planttip;

import com.example.plantproject.PlantTipMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlantTipsRepositoryImpl implements PlantTips {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public int createPlantTip(String name, int watering, int feeding, int spraying, String notes) {
        return jdbcTemplate.update("INSERT INTO \"plant_tips\" (\"name\", \"watering\", \"feeding\", \"spraying\", \"notes\") VALUES(?, ?, ?, ?, ?)", name, watering, feeding, spraying, notes);
    }

    @Override
    public int updatePlantTip(com.example.plantproject.entity.PlantTip plantTip) {
        return jdbcTemplate.update("UPDATE \"plant_tips\" SET \"name\" = ? WHERE \"id\" = ?", plantTip.getName(), plantTip.getId());
    }

    @Override
    public int deletePlantTip(Integer id) {
        return jdbcTemplate.update("DELETE FROM \"plant_tips\" WHERE \"id\" = ?",id);
    }

    @Override
    public com.example.plantproject.entity.PlantTip getPlantTip(String name) {
        return jdbcTemplate.queryForObject("SELECT * FROM \"plant_tips\" WHERE \"name\"=?", new PlantTipMapper(), name);
    }

    @Override
    public List<com.example.plantproject.entity.PlantTip> getPlantTips() {
        return jdbcTemplate.query("SELECT * FROM \"plant_tips\"", new PlantTipMapper());
    }
}
