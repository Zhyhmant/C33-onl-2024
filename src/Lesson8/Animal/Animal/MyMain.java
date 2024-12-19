package Lesson8.Animal.Animal;

import static Lesson8.Animal.Animal.Dog.createDog;

public class MyMain {
    public static  void main(String[] args){
      Animal genericAnimal = new Animal("Generic");
      Tiger tiger = new Tiger("Sharic");
      Rabbit rabbit = new Rabbit("Reks");
        Dog dog = createDog("");
        genericAnimal.voice();
      genericAnimal.eat("Meat");


        tiger.voice();
        tiger.eat("Banana");

        rabbit.voice();
        rabbit.eat("Meat");

    }

}
