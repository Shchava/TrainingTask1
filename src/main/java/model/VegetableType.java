package model;

public enum VegetableType {
    Cabbage(290000),Eggplant(180000),Beet(370000),Squash(230000),Potato(80000),
    Corn(970000),Cucumber(150000),Tomato(190000),Radish(140000);

    public final int caloriesPerKg;

    VegetableType(int caloriesPerKg){
        this.caloriesPerKg = caloriesPerKg;
    }
}
