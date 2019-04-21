package model;

public class Vegetable extends FoodIngredient{
    private VegetableType type;

        public Vegetable(VegetableType type,double weight){
        this.type = type;
        this.weight = weight;
        calories = (int)(type.caloriesPerKg * weight);
    }

    public VegetableType getType(){
        return type;
    }
}
