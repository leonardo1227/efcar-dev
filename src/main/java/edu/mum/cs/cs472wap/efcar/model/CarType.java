package edu.mum.cs.cs472wap.efcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarType {

    private Long id;
    private String description;
    private List<CarModel> models;

    public CarType() {
        this.models = new ArrayList<CarModel>();
    }

    public CarType(Long id, String description) {
        this.id = id;
        this.description = description;
        this.models = new ArrayList<CarModel>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<CarModel> getModels() {
        return models;
    }

    public void setModels(List<CarModel> models) {
        this.models = models;
    }
}
