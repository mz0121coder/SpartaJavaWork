package com.sparta.mz.enums;

public enum Size {
    SMALL("Small pizza", 800),
    MEDIUM("Medium pizza", 1200),
    LARGE("Large pizza", 1800);

    private String description;
    private int calories;

    Size(String description, int calories) {
        this.description = description;
        this.calories = calories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
