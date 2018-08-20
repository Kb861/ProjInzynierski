package com.example.ketri.korektawadpostawy.Exercises.model;

/**
 * Created by ketri on 29.07.2018.
 */

public class Defect {
    private String name;
    private int image;

    public Defect(String name, int image) {
        this.name = name;
        this.image = image;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }
}
