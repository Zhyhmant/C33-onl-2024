package Lesson4;

public class Homework_4_lesson {
    public static void main(String[] arg) {
        enterTask2();
    }

    public static void useTest() {
        int[] arrayOne = new int[10];
        arrayOne[0]= 30;
        arrayOne[1]= 29;
        arrayOne[2]= 28;
        arrayOne[3]= 27;
        arrayOne[4]= 26;
        arrayOne[5]= 25;
        arrayOne[6]= 24;
        arrayOne[7]= 23;
        arrayOne[8]= 22;
        arrayOne[9]= 21;
        System.out.println("First number : " + arrayOne[4] + " result");

    }

    public static void useTestTwo() {
      int[] numbers = new int[]{1,2,3,4,5,6,7,8,9};
      String[] names = new String[]{"Dzimitry","Zhyhhmant",};
        System.out.println("My Name :" + names[0] + " " + names[1]);
        System.out.println("Age: " + numbers[2] + numbers[0]);
    }

    public static void enterTask1(){
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.print("The direct order : ");
        for (int beginnin = 0; beginnin < array.length; beginnin++) {
            System.out.print(array[beginnin] + " ");
        }
        System.out.println(" ");
        System.out.print("Reverse order: ");
        for (int beginning = array.length - 1; beginning >= 0; beginning--) {
            System.out.print(array[beginning] + " ");
        }
        System.out.println();
    }
    public static void enterTask2(){
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int min = array[0];
        int max = array[0];
        for (int number : array) {
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }
        System.out.println("Minimum element: " + min);
        System.out.println("Maximum element: " + max);

    }
    public static void enterTask3(){

    }
}

