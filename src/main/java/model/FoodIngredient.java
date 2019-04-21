package model;

public abstract class FoodIngredient implements EatAble{
    int calories;
    double weight;
    public int getCalories(){
        return calories;
    }
    public double getWeight(){
        return weight;
    }
}
