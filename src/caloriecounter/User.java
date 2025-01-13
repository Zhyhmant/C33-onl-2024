package caloriecounter;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String gender;
    private int Age;
    private List<Meal> meals;

    public User(String name ,String gender,int Age){
      this.name = name;
      this.gender = gender;
      this.Age = Age;
      this.meals = new ArrayList<>();
    }
    public String getName(){
        return name;
    }
    public void addMeal(Meal meal){
        meals.add(meal);
    }
    public double calculateBaseCalories(){
        double baseCalories;
        if (gender.equalsIgnoreCase("male")){
            baseCalories = (10*70) + (6.25*170)-(5* Age)+ 5;
        } else if (gender.equalsIgnoreCase("famale")) {
            baseCalories = (10*60) + (6.25*160) - (5 * Age) - 161;
        }else {
            baseCalories = 2000;
        }
        return baseCalories;
    }
    public double calculateTotalCalories(){
        double totalCalories = 0;
        for (Meal meal: meals){
            totalCalories +=meal.calculateTotalCalories();
        }
        return totalCalories;

    }
    public void viewMealHistory(){
        if(meals.isEmpty()){
            System.out.println("You have is not history food intake.");
        }else {
            System.out.println("---History food intake---");
            for (int i = 0;i < meals.size();i++){
                System.out.println("Food intake #" + (i +1));
                System.out.println(meals.get(i));
            }
            System.out.println("Total calories: " + calculateTotalCalories() + "--base calories: "
                    + calculateBaseCalories());
            if(calculateTotalCalories()>calculateBaseCalories()){
                System.out.println("The base calories level has been exceeded");
            }
        }
    }
}
