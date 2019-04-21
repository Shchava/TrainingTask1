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

    @Override
    public boolean equals(Object eq){
            if(eq instanceof Vegetable){
                Vegetable veg = (Vegetable)eq;
                return veg.type == type && Double.compare(veg.weight,weight) == 0 && veg.calories == calories;
            }
            return false;
    }
}
