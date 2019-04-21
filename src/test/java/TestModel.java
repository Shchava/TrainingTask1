import model.*;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

public class TestModel {
    Model testModel = new Model();

    @Test
    public void testMakeRandomSalad(){
        for(int i = 0; i < 1000; i++){
            HashSet<VegetableType> unique = new HashSet<>();

            Salad testSalad = testModel.makeRandomSalad();

            for(FoodIngredient ingredient : testSalad.getIngredients()){
                assertTrue(unique.add(((Vegetable)ingredient).getType()));

                assertTrue(ingredient.getWeight() > testModel.MIN_INGREDIENT_WEIGHT);
                assertTrue(ingredient.getWeight() < testModel.MAX_INGREDIENT_WEIGHT);
            }

        }
    }
}
