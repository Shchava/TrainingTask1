package view;

import model.FoodIngredient;
import model.Salad;

import java.util.List;
import java.util.ResourceBundle;

public class View {
    public static final String MESSAGES_BUNDLE_NAME = "messages";

    public ResourceBundle messages = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME);

    public void print(String message){
        System.out.println(message);
    }

    public void printMethodInvitation(){
        print(messages.getString("startOfMethod"));
    };

    public void printVegetableSalad(Salad salad){
        for(FoodIngredient ingredient:salad.getIngredients()){

        }
    };

    public void printCalories(int calories){};

    public void printSortedByWeight(){};

    public void printFindingFromRangeOfCalories(int minCalories,int maxCalories){};

    public void printListOfIngredients(List<FoodIngredient> ingredients){};

    public void printContinueInvitation(){};

}
