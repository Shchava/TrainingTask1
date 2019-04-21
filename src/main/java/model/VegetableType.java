package model;

public enum VegetableType {
    Cabbage(4)  ;

    public final int caloriesPerKg;

    VegetableType(int caloriesPerKg){
        this.caloriesPerKg = caloriesPerKg;
    }
}
