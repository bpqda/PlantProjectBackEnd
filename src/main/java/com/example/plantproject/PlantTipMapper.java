package com.example.plantproject;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.plantproject.entity.PlantTip;
import org.springframework.jdbc.core.RowMapper;

public class PlantTipMapper implements RowMapper<PlantTip> {

    public PlantTip mapRow(ResultSet rs, int rowNum) throws SQLException {
        PlantTip plantTip = new PlantTip();
        plantTip.setId(rs.getInt("id"));
        plantTip.setName(rs.getString("name"));
        plantTip.setWatering(rs.getInt("watering"));
        plantTip.setFeeding(rs.getInt("feeding"));
        plantTip.setSpraying(rs.getInt("spraying"));
        plantTip.setNotes(rs.getString("notes"));

        return plantTip;
    }
}
