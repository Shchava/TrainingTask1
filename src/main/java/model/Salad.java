package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Salad implements EatAble{
    private List<FoodIngredient> ingredients;

    public Salad(){
        ingredients = new ArrayList<FoodIngredient>();
    }

    public Salad(FoodIngredient... ingredients){
        this.ingredients = Arrays.asList(ingredients);
    }

    public Salad(List<FoodIngredient> ingredients){
        this.ingredients = ingredients;
    }

    public boolean addIngredient(FoodIngredient ingredient){
        return ingredients.add(ingredient);
    }

    public List<FoodIngredient>getIngredients(){
        return ingredients;
    }

    public void sortByCalories(){};

    public void sortByWeight(){};

    public void getIngredientsMatchesCaloriesRange(int minCalories,int maxCalories){

    }

    public int getCalories() {
        return 0;
    }
}
