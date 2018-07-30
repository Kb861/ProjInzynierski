package com.example.ketri.korektawadpostawy.Exercises.model;

/**
 * Created by ketri on 29.07.2018.
 */

public class ExerciseModel {
    private String name ;

    private String description;

    private String rating ;


    private String categorie;
    public ExerciseModel(){};

    public ExerciseModel(String name, String description, String rating, String categorie) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.categorie = categorie;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
}
