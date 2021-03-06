package com.elkhamitech.tasksolving.data.model;

import org.simpleframework.xml.ElementList;

import java.util.List;

public class FoodResponse {

    @ElementList(inline = true)
    private List<Food> foodList;

    public FoodResponse() {

    }

    public List<Food> getFoodList() {

        return foodList;
    }

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }
}
