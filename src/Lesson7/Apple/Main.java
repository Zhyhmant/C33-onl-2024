package Lesson7.Apple;

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple();
        System.out.println("The original color of the apple: " + apple.getColor());

        apple.setColor("green");
        System.out.println("The color of the apple after the change: " + apple.getColor());

        try{
            java.lang.reflect.Field field = apple.getClass().getDeclaredField("color");
            field.setAccessible(true);
            field.set(apple,"yellow");
            System.out.println("The color of the apple after changing by reflection: " + apple.getColor());
        } catch (NoSuchFieldException | IllegalAccessException e){
            e.printStackTrace();
        }


    }
}
