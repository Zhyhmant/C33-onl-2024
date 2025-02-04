package Lesson15;

import java.util.LinkedList;

public class AnimalCollection {
    private LinkedList<String> animals = new LinkedList<>();

    public void addAnimal(String animal){
        animals.addFirst(animal);
    }
    public String removeAnimal(){
        if (!animals.isEmpty()){
            return animals.removeLast();
        }
        return "The list is empty";
    }
    public void printAnimals(){
        System.out.println("The animals list: " + animals);
    }
}
