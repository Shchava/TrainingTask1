package model;

public class Vegetable extends FoodIngredient{
    private VegetableType type;

    public Vegetable(VegetableType type,int weight){
        this.type = type;
        this.weight = weight;
        calories = type.caloriesPerKg * weight;
    }

    public VegetableType getType(){
        return type;
    }
}
