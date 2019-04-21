import model.FoodIngredient;
import model.Salad;
import model.Vegetable;
import model.VegetableType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestSalad {
    FoodIngredient[] testVegetablesArray = {new Vegetable(VegetableType.Cucumber, 0.1),
            new Vegetable(VegetableType.Potato, 0.2), new Vegetable(VegetableType.Tomato, 0.15),
            new Vegetable(VegetableType.Radish, 0.05)};

    List<FoodIngredient> testIngredients = Arrays.asList(testVegetablesArray);
    Salad testSalad = new Salad(testIngredients);

    @Test
    void testAddIngredient() {
        Salad test = new Salad();
        for (FoodIngredient vegetable : testVegetablesArray) {
            test.addIngredient(vegetable);
        }
        assertIterableEquals(testIngredients, test.getIngredients());
    }

    @Test
    void testVarArgsConstructor() {
        Salad test = new Salad(testVegetablesArray);
        assertIterableEquals(testIngredients, test.getIngredients());
    }

    @Test
    void testCollectionConstructor() {
        Salad test = new Salad(testIngredients);
        assertIterableEquals(testIngredients, test.getIngredients());
    }

    @Test
    void testGetCalories(){
        int calories = 0;
        for(FoodIngredient ing: testIngredients){
            calories += ing.getCalories();
        }
        assertEquals(calories,testSalad.getCalories());
    }

    @Test
    void testSortByCalories(){
        FoodIngredient[] testingArr = Arrays.copyOf(testVegetablesArray,testVegetablesArray.length);
        Arrays.sort(testingArr, Comparator.comparingInt(FoodIngredient::getCalories));
        testSalad.sortByCalories();
        assertIterableEquals(Arrays.asList(testingArr),testSalad.getIngredients());
    }

    @Test
    void  testSortByWeight(){
        FoodIngredient[] testingArr = Arrays.copyOf(testVegetablesArray,testVegetablesArray.length);
        Arrays.sort(testingArr, Comparator.comparingDouble(FoodIngredient::getWeight));
        testSalad.sortByWeight();
        assertIterableEquals(Arrays.asList(testingArr),testSalad.getIngredients());
    }

    @Test
    void testGetIngredientsMatchesCaloriesRange(){
        List<FoodIngredient> ingredientsInRange =  testSalad.getIngredientsMatchesCaloriesRange(5000,15500);

        FoodIngredient[] expectedIngredients = {new Vegetable(VegetableType.Cucumber, 0.1),
                new Vegetable(VegetableType.Radish, 0.05)};

        assertIterableEquals(Arrays.asList(expectedIngredients),ingredientsInRange);
    }
}
