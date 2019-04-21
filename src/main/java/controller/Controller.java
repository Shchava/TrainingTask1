package controller;

import model.FoodIngredient;
import model.Model;
import model.Salad;
import view.View;

import java.util.List;
import java.util.Scanner;

public class Controller {
    private View view;
    private Model model;
    private Scanner sc;

    public Controller(View view,Model model){
        this.view = view;
        this.model = model;
        sc = new Scanner(System.in);
    }

    public void process(){
        do{
            view.printMethodInvitation();
            Salad salad = model.makeRandomVegetableSalad();
            view.printVegetableSalad(salad);
            view.printCalories(salad.getCalories());
            salad.sortByWeight();
            view.printSortedByWeight();
            view.printVegetableSalad(salad);
            int minCalories = 10000;
            int maxCalories = 35000;
            view.printFindingFromRangeOfCalories(minCalories,maxCalories);
            List<FoodIngredient> matchesCalories =  salad.getIngredientsMatchesCaloriesRange(minCalories,maxCalories);
            view.printListOfIngredients(matchesCalories);
            view.printContinueInvitation();
        }while(sc.nextLine().equals(view.messages.getString("continue")));
    }

}
