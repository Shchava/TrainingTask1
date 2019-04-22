package model;

import java.util.HashSet;
import java.util.Set;
/**
 * The {@code Model} provides creating of random salads, each
 * ingredient of created salads have weight on range of
 * {@link #MIN_INGREDIENT_WEIGHT} and {@link #MAX_INGREDIENT_WEIGHT}
 * */
public class Model {
    public final double MAX_INGREDIENT_WEIGHT = 0.5;
    public final double MIN_INGREDIENT_WEIGHT = 0.01;

    /**
     * Creates salad with random unique ingredients, that have weight that
     * bigger then {@link #MIN_INGREDIENT_WEIGHT} and lesser then {@link #MAX_INGREDIENT_WEIGHT}
     * @return created salad
     * */
    public Salad makeRandomVegetableSalad(){
        Salad salad = new Salad();
        HashSet<Integer> used = new HashSet<>();
        for(int i = 0; i < 5; i++){
            VegetableType newIngredientType = generateRandomVegetable(used);
            double newIngredientWeight = generateRandomWeight();

            Vegetable newIngredient = new Vegetable(newIngredientType,newIngredientWeight);
            salad.addIngredient(newIngredient);
        }
        return salad;
    }

    private VegetableType generateRandomVegetable(Set<Integer> used){
        int generated;
        do{
            generated = (int)(VegetableType.values().length * Math.random());
        }while(used.contains(generated));
        used.add(generated);
        return VegetableType.values()[generated];
    }

    private double generateRandomWeight(){
        return (MAX_INGREDIENT_WEIGHT - MIN_INGREDIENT_WEIGHT) * Math.random() + MIN_INGREDIENT_WEIGHT;
    }
}
