package com.bilgeadam.mobileonlinefoodapp.data;

public class Meal {
    private String name;
    private String description;
    private String image;

    public Meal(String name, String description, String image) {
        this.image = image;
        this.name = name;
        this.description = description;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
