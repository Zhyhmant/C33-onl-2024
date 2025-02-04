package Lesson15;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueNumbers {
    public static void main(String[] args) {
        AnimalsCollection();
    }




     public static void UniqNumbers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the numbers separated by commas: ");
        String input = scanner.nextLine();

        Set<Integer> unuqueNumbers = new LinkedHashSet<>();
        for (String num : input.split(",")){
            unuqueNumbers.add(Integer.parseInt(num.trim()));
        }
        System.out.println("Unique number : "  + unuqueNumbers);
    }


    public static void AnimalsCollection(){
        AnimalCollection zoo = new AnimalCollection();

        zoo.addAnimal("Lion");
        zoo.addAnimal("Tiger");
        zoo.addAnimal("Elephant");

        zoo.printAnimals();
        System.out.println("Delete: " + zoo.removeAnimal());
        zoo.printAnimals();
    }
}
