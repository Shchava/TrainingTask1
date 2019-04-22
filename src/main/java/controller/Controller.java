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

    private int minCalories = 10000;
    private int maxCalories = 35000;

    public Controller(View view,Model model){
        this.view = view;
        this.model = model;
        sc = new Scanner(System.in);
    }

    public void process(){
        do{
            doMainActions();
            view.printContinueInvitation();
        }while(sc.nextLine().equals(view.messages.getString("continue")));
    }
    private void doMainActions(){
        Salad salad = saladCreating();
        countCalories(salad);
        saladSorting(salad);
        getIngredientsFromCaloriesRange(salad);
    }
    private Salad saladCreating(){
        view.printMethodInvitation();
        Salad salad = model.makeRandomVegetableSalad();
        view.printVegetableSalad(salad);
        return salad;
    }

    private void countCalories(Salad salad){
        int calories = salad.getCalories();
        view.printCalories(calories);
    }

    private void saladSorting(Salad salad){
        salad.sortByWeight();
        view.printSortedByWeight();
        view.printVegetableSalad(salad);
    }

    private void getIngredientsFromCaloriesRange(Salad salad){
        view.printFindingFromRangeOfCalories(minCalories,maxCalories);
        List<FoodIngredient> matchesCalories =  salad.getIngredientsMatchesCaloriesRange(minCalories,maxCalories);
        view.printListOfIngredients(matchesCalories);
    }

}
