package caloriecounter;

import java.util.Scanner;

public class CalorieCounterApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static User currentuser;
    private static String[] parts;

    public static void main(String[] args) {
        login();
        while(true){
            displayMainMenu();
            String choice = scanner.nextLine();
            switch (choice){
                case "1":
                    addMeal();
                    break;
                case "2":
                    currentuser.viewMealHistory();
                    break;
                case "0":
                    System.out.println("Thanks for use app");
                    scanner.close();
                    return;
                default:
                    System.out.println("Incorrect input. Please try again");
            }
        }
    }

    private static void displayMainMenu() {
        System.out.println("\n Choose an action:");
        System.out.println("1- add food intake ");
        System.out.println("2- view history food intake ");
        System.out.println("3- exit");
    }
    private static void login(){
            System.out.println("Please enter your Name : ");
            String name = scanner.nextLine();

            System.out.println("Please enter your gender (male|famale");
            String gender = scanner.nextLine();

            System.out.println("Please enter your Age: ");
            int Age;
            while (true){
                try {
                    String ageInput = scanner.nextLine();
                    Age = Integer.parseInt(ageInput);
                    break;
                }catch (NumberFormatException e){
                    System.out.println("Incorrect input. Please enter An integer.");
                }
            }
            currentuser = new User(name,gender,Age);
            System.out.println("Welcome," + currentuser.getName() + "!");

        }
        private static void addMeal(){
        Meal meal = new Meal();
        while (true){
            System.out.println("Add foods to a meal (for example: bread 100 20, milk 80 200, or 'done'):");
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("done")){
                break;
            }
            String[] parts = input.split(" ");
            if (parts.length != 3){
                System.out.println("Incorrect input! Enter the 'calorie product_n_100g gramovka'. Try again");

            continue;
        }
        try{
            String name = parts[0];
            double calories = Double.parseDouble(parts[1]);
            double grams = Double.parseDouble(parts[2]);
            FoodItem foodItem = new FoodItem(name,calories,grams);
            meal.addItem(foodItem);
        }catch (NumberFormatException e){
            System.out.println("Incorrect input !Please enter An integer");
        }

        }
        currentuser.addMeal(meal);
        System.out.println(meal);
    }
}
