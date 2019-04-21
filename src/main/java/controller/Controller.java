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
        view.printStartMessage();
        do{
            view.printMethodInvitation();
            Salad salad = model.makeRandomVegetableSalad();
            view.printSalad(salad);
            view.printCalories(salad.getCalories());
            salad.sortByWeight();
            view.printSortedByWeight();
            view.printSalad(salad);
            int minCalories = 1000;
            int maxCalories = 9000;
            view.printFindingFromRangeOfCalories(minCalories,maxCalories);
            List<FoodIngredient> matchesCalories =  salad.getIngredientsMatchesCaloriesRange(minCalories,maxCalories);
            view.printListOfIngredients(matchesCalories);
            view.printContinueInvitation();
        }while(sc.nextLine().equals(view.Messages.getString("continue")));
    }

}
