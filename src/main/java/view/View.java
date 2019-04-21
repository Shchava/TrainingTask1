package view;

import model.FoodIngredient;
import model.Salad;
import model.Vegetable;
import model.VegetableType;

import java.util.List;
import java.util.ResourceBundle;

public class View {
    public static final String MESSAGES_BUNDLE_NAME = "messages";
    public static final String VEGETABLE_NAMES_BUNDLE_NAME = "vegetableNames";

    public ResourceBundle messages = ResourceBundle.getBundle(MESSAGES_BUNDLE_NAME);
    public ResourceBundle vegetableNames = ResourceBundle.getBundle(VEGETABLE_NAMES_BUNDLE_NAME);

    public void print(String message){
        System.out.println(message);
    }

    public void printMethodInvitation(){
        print(messages.getString("startOfMethod"));
    };

    public void printVegetableSalad(Salad salad){
        print(messages.getString("saladOutputInvitation"));
        for(FoodIngredient ingredient:salad.getIngredients()){
            if(ingredient instanceof Vegetable){
                Vegetable item = (Vegetable) ingredient;
                print(getStringRepresentationOfVegetable(item));
            }else{
                print(messages.getString("notVegetable"));
            }
        }
    };

    private String getStringRepresentationOfVegetable(Vegetable item){
        String name = getLocalisedVegetableType(item.getType());
        String formatString = messages.getString("formatVegetableOutput");
        return String.format(formatString,name,item.getWeight(),item.getCalories());
    }
    private String getLocalisedVegetableType(VegetableType type){
        return vegetableNames.getString(type.name());
    }

    public void printCalories(int calories){
        String message =  String.format(messages.getString("formatCaloriesOutput"),calories);
        print(message);
    };

    public void printSortedByWeight(){
        print(messages.getString("sortedByWeight"));
    };

    public void printFindingFromRangeOfCalories(int minCalories,int maxCalories){
        String message = String.format(messages.getString("caloriesRangeFormat"),minCalories,maxCalories);
        print(message);
    };

    public void printListOfIngredients(List<FoodIngredient> ingredients){};

    public void printContinueInvitation(){};

}
