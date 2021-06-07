package com.example.plantproject;

import java.util.List;

import com.example.plantproject.entity.PlantTip;
import com.example.plantproject.planttip.PlantTips;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("database")
public class PlantTipController {

    @Autowired
    private PlantTips repository;

    @RequestMapping(value = "/create", method=RequestMethod.PUT, consumes="text/plain")
    public int createPlantTip(@RequestBody String param){

        String name;
        int watering;
        int feeding;
        int spraying;
        String notes;

        try{
            JSONObject json = new JSONObject(param);
            name = json.getString("name");
            watering = json.getInt("watering");
            feeding = json.getInt("feeding");
            spraying = json.getInt("spraying");
            notes = json.getString("notes");

        }catch (JSONException e){
            e.getLocalizedMessage();
            return 0;
        }
        return repository.createPlantTip(name, watering, feeding, spraying, notes);
    }

    @RequestMapping(value = "update", method=RequestMethod.POST,consumes="text/plain")
    public int updatePlantTip(@RequestBody String param){
        PlantTip p = new PlantTip();
        try{
            JSONObject json = new JSONObject(param);
            p.setId(json.getInt("id"));
            p.setName(json.getString("name"));
            p.setWatering(json.getInt("watering"));
            p.setFeeding(json.getInt("watering"));
            p.setWatering(json.getInt("watering"));
            p.setNotes(json.getString("notes"));
        }catch(JSONException e){
            e.getLocalizedMessage();
            return 0;
        }
        return repository.updatePlantTip(p);
    }

    @RequestMapping(value="{id}", method=RequestMethod.DELETE)
    public int deletePlantTip(@PathVariable Integer id){
        return repository.deletePlantTip(id);
    }

    @RequestMapping(value = "/getplant", method=RequestMethod.GET)
    public PlantTip getPlantTip(@RequestParam("name") String name){
        return repository.getPlantTip(name);
    }

    @RequestMapping(value = "/getallplants", method=RequestMethod.GET)
    public List<PlantTip> getPlantTips(){
        return repository.getPlantTips();
    }
}
