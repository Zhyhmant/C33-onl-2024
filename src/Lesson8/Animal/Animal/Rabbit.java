package Lesson8.Animal.Animal;

class Rabbit extends Animal{
    public Rabbit(String name){
        super(name);
    }
    @Override
    public void voice(){
        System.out.println("Rabbit: Squek!");
    }
    @Override
    public void eat(String food){
     if(food.equalsIgnoreCase("Grass")){
         System.out.println("Rabbit happily munches on grass");
     }else{
         System.out.println("Rabbit doesn't like " + food + " and prefers grass.");
     }
    }
}
