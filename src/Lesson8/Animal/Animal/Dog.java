package Lesson8.Animal.Animal;

class Dog {
    private String name;
    private Dog (String name){
      this.name=name;
   }
   public static Dog createDog(String name){
        return new Dog(name);
   }

    public void voice(){
    System.out.println("Dog:Woof!");
}
    public void eat(String food){

       if(food.equalsIgnoreCase("Meat")){
           System.out.println("Dog happily eats meat");
       }else{
           System.out.println("Dog is not interested in " + food);
       }
}
}
