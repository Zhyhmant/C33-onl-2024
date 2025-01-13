package caloriecounter;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<FoodItem>items;

    public Meal(){
        this.items = new ArrayList<>();
    }
    public void addItem(FoodItem item){
        items.add(item);
    }
    public double calculateTotalCalories(){
        double totalCalories = 0;
        for(FoodItem item: items){
         totalCalories += item.calculateCalories();
    }
    return totalCalories;
}

  public List<FoodItem> getItems(){
    return items;

  }
  @Override
  public String toString(){
    StringBuilder sb = new StringBuilder();
    sb.append("Meal items:\n");
    for (FoodItem item: items){
        sb.append("-- ").append(item).append("\n");
    }
    sb.append("Total calories: ").append(calculateTotalCalories());
    return sb.toString();
  }
  }