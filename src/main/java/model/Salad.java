package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
/**
 * Object that represents salad form FoodIngredients.
 * Saves ingredients in list, that can be accessed by {@link #getIngredients()},
 * provides methods to sort them {@link #sortByWeight()},{@link #sortByCalories()}
 * count full calories {@link #getCalories()}, get ingredients from range
 * of calories {@link #getIngredientsMatchesCaloriesRange(int, int)}
 * @author Yaroslav Shchavinskyy
 * @since JDK 8.0
 **/
public class Salad implements EatAble{
    private List<FoodIngredient> ingredients;

    public Salad(){
        ingredients = new ArrayList<>();
    }

    public Salad(FoodIngredient... ingredients){
        this.ingredients = Arrays.asList(ingredients);
    }

    public Salad(List<FoodIngredient> ingredients){
        this.ingredients = ingredients;
    }

    /**
     * Adds new ingredient to existing salad.
     * @param ingredient ingredient to add
     * */
    public boolean addIngredient(FoodIngredient ingredient){
        return ingredients.add(ingredient);
    }

    /**
     * Returns list of ingredients that this salad contains.
     * */
    public List<FoodIngredient>getIngredients(){
        return ingredients;
    }

    /**
     * Sorts ingredients in ingredient list by calories
     * */
    public void sortByCalories(){
        ingredients.sort(Comparator.comparingInt(FoodIngredient::getCalories));
    }

    /**
     * Sorts ingredients in ingredient list by weight
     * */
    public void sortByWeight(){
        ingredients.sort(Comparator.comparingDouble(FoodIngredient::getWeight));
    }

    /**
     * Get list of ingredients from that salad, which are in range of {@code [minCalories,maxCalories]}
     * @param minCalories minimal value of ingredient calories to be included in returning list
     * @param maxCalories maximal value of ingredient calories to be included in returning list
     * @return list of {@see model.FoodIngredient}  that includes ingredients of that salad, which matches requirements
     */
    public List<FoodIngredient> getIngredientsMatchesCaloriesRange(int minCalories,int maxCalories){
        return ingredients.stream()
                .filter(ingredient -> ingredient.getCalories() >= minCalories && ingredient.getCalories() <= maxCalories)
                .collect(Collectors.toList());
    }

    /**
     * Counts full calories of that salad.
     * @return returns sum of calories of each ingredient of that salad
     * */
    public int getCalories() {
        return ingredients.stream().mapToInt(FoodIngredient::getCalories).sum();
    }
}
