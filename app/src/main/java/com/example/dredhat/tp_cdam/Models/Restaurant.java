package com.example.dredhat.tp_cdam.Models;

/**
 * Created by lhadj on 10/21/2017.
 */

public class Restaurant {
    private String restaurantName;
    private String restaurantAddress;

    public Restaurant(String restaurantName, String restaurantAddress) {
        this.restaurantName = restaurantName;
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }
}
