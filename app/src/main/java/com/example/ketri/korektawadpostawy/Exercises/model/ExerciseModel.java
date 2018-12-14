package com.example.ketri.korektawadpostawy.Exercises.model;

/**
 * Created by ketri on 29.07.2018.
 */

public class ExerciseModel {

    private String name ;
    private String description;
    private String rating ;
    private String image_url;
    private String video;
    private String categorie;


    public ExerciseModel(){}

    public ExerciseModel(String name, String description, String rating, String image_url, String categorie, String video) {
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.image_url = image_url;
        this.categorie = categorie;
        this.video = video;
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
    public String getImage_url() {
        return image_url;
    }
    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public String getVideo() {
        return video;
    }
    public void setVideo(String video) {
        this.video = video;
    }
}
