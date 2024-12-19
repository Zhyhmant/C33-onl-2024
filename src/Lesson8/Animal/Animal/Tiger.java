package Lesson8.Animal.Animal;

class Tiger extends Animal {
    public Tiger(String name){
        super(name);
    }
@Override
    public void voice(){
    System.out.println("Tiger: Roar");
}
@Override
    public void eat(String food){
        if(food.equalsIgnoreCase("Meat")){
            System.out.println("Tiger devours the meat");
        }else{
            System.out.println("Tiger prefers meat to " + food);
        }
}
}
