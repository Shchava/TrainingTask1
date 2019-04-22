import model.*;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class TestModel {
    private Model testModel = new Model();

    @Test
    void testMakeRandomSalad(){
        for(int i = 0; i < 1000; i++){
            HashSet<VegetableType> unique = new HashSet<>();

            Salad testSalad = testModel.makeRandomVegetableSalad();

            for(FoodIngredient ingredient : testSalad.getIngredients()){
                //check uniqueness of created ingredients
                assertTrue(unique.add(((Vegetable)ingredient).getType()));

                //check if weights of created salad is in range
                assertTrue(ingredient.getWeight() > testModel.MIN_INGREDIENT_WEIGHT);
                assertTrue(ingredient.getWeight() < testModel.MAX_INGREDIENT_WEIGHT);
            }

        }
    }
}
