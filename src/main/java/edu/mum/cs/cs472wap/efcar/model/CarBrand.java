package edu.mum.cs.cs472wap.efcar.model;

import java.util.ArrayList;
import java.util.List;

public class CarBrand {

    private Long id;
    private String name;
    private List<CarModel> models;

    public CarBrand() {
        this.models = new ArrayList<CarModel>();
    }

    public CarBrand(Long id, String name) {
        this.id = id;
        this.name = name;
        this.models = new ArrayList<CarModel>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<CarModel> getModels() {
        return models;
    }

    public void setModels(List<CarModel> models) {
        this.models = models;
    }
}
