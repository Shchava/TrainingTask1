package model;

import java.util.HashSet;
import java.util.Set;

public class Model {
    public final double MAX_INGREDIENT_WEIGHT = 2;
    public final double MIN_INGREDIENT_WEIGHT = 0.01;

    public Salad makeRandomVegetableSalad(){
        Salad salad = new Salad();
        HashSet<Integer> used = new HashSet<Integer>();
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
