package org.example.stream.model;

public record Dish(String name, boolean vegetarian, int calories, Type type) {
    public enum Type {
        MEAT, FISH, OTHER
    }

    public enum CaloricLevel {
        DIET, NORMAL, FAT
    }

    public CaloricLevel caloricLevel() {
        return calories < 400 ? CaloricLevel.DIET
                : calories < 700 ? CaloricLevel.NORMAL
                : CaloricLevel.FAT;
    }
}
