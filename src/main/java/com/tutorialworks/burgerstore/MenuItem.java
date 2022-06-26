package com.tutorialworks.burgerstore;

public class MenuItem {

    private String title;
    private int calories;

    public MenuItem(String title, int calories) {
        this.title = title;
        this.calories = calories;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }
}
