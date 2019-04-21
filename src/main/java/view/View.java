package view;

import model.FoodIngredient;
import model.Salad;

import java.util.List;
import java.util.ResourceBundle;

public class View {
    public static final String MESSAGES_BUNDLE_NAME = "Messages";

    public ResourceBundle Messages = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME);

    public void print(String message){
        System.out.println(message);
    }

    public void printStartMessage(){};

    public void printMethodInvitation(){};

    public void printSalad(Salad salad){};

    public void printCalories(int calories){};

    public void printSortedByWeight(){};

    public void printFindingFromRangeOfCalories(int minCalories,int maxCalories){};

    public void printListOfIngredients(List<FoodIngredient> ingredients){};

    public void printContinueInvitation(){};

}
