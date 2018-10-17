package com.example.vam1994.speedbytedemo;


/**
 * The type Food item.
 */
public class FoodItem {

    private float rating;
    private String name;

    /**
     * Instantiates a new Food item.
     *
     * @param rating the rating
     * @param name   the name
     */
    public FoodItem(float rating, String name){
        this.rating = rating;
        this.name = name;
    }

    /**
     * Gets rating.
     *
     * @return the rating
     */
    public float getRating() {
        return rating;
    }

    /**
     * Sets rating.
     *
     * @param rating the rating
     */
    public void setRating(float rating) {
        this.rating = rating;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }
}