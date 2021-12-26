package com.itisravi.springbootbackend.model;

import javax.persistence.*;

@Entity
@Table(name = "foods")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "food_name")
    private String food_name;

    @Column(name = "protein")
    private String protein;

    @Column(name = "carbs")
    private String carbs;

    @Column(name = "fats")
    private String fats;

    @Column(name = "size")
    private String size;

    public Food() {
    }

    public Food(String food_name, String protein, String carbs, String fats, String size) {
        this.food_name = food_name;
        this.protein = protein;
        this.carbs = carbs;
        this.fats = fats;
        this.size = size;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFoodName() {
        return food_name;
    }

    public void setFoodName(String food_name) {
        this.food_name = food_name;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public String getCarbs() {
        return carbs;
    }

    public void setCarbs(String carbs) {
        this.carbs = carbs;
    }

    public String getFats() {
        return fats;
    }

    public void setFats(String fats) {
        this.fats = fats;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
