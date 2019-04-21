package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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

    public void sortByCalories(){
        ingredients.sort(Comparator.comparingInt(FoodIngredient::getCalories));
    };

    public void sortByWeight(){
        ingredients.sort(Comparator.comparingDouble(FoodIngredient::getWeight));
    };

    public List<FoodIngredient> getIngredientsMatchesCaloriesRange(int minCalories,int maxCalories){
        return null;
    }

    public int getCalories() {
        return 0;
    }
}
