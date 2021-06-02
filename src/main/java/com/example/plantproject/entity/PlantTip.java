package com.example.plantproject.entity;

public class PlantTip {
    private Integer id;
    private String name;
    private int watering;
    private int feeding;
    private int spraying;
    private String notes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWatering() {
        return watering;
    }

    public void setWatering(int watering) {
        this.watering = watering;
    }

    public int getFeeding() {
        return feeding;
    }

    public void setFeeding(int feeding) {
        this.feeding = feeding;
    }

    public int getSpraying() {
        return spraying;
    }

    public void setSpraying(int spraying) {
        this.spraying = spraying;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
