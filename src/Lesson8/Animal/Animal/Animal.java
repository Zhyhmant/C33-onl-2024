package Lesson8.Animal.Animal;

public class Animal {
    private String name;

    public Animal(String name){
        this.name =name;
    }
    public String getName(){
        return name;
    }
    public void voice(){
        System.out.println("Generic animal sound");
    }
    public void eat(String food){
        System.out.println("Animal eat: " + food);
    }
}
