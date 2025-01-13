package caloriecounter;

public class FoodItem {
    private String name;
    private double caloriesPer100g;
    private double grams;

    public FoodItem(String name,double caloriesPer100g,double grams){
        this.name = name ;
        this.caloriesPer100g = caloriesPer100g;
        this.grams = grams;

    }
    public String getName(){
        return name;
    }

    public double getCaloriesPer100g() {
        return caloriesPer100g;
    }

    public double getGrams() {
        return grams;
    }
    public double calculateCalories(){
        return (caloriesPer100g / 100) * grams;
    }
    @Override
    public String toString(){
        return String.format("%-20s - %.2f calories (%.0f grams)", name, calculateCalories(), grams);
    }
}
