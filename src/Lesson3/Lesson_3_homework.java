package Lesson3;

import java.util.Scanner;

public class Lesson_3_homework {
    public static void main(String[] args) {
        enterTask5();
    }

    public static void enterTask1() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please,enter number: ");
        if (scanner.hasNext()) {
            int number = scanner.nextInt();
            if (number % 2 == 0) {
                System.out.println(number + " - An even number");
            } else {
                System.out.println(number + " - Ann odd number");
            }
        }
        scanner.close();
    }

    public static void enterTask2() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter the air temperature:");
        if (scanner.hasNext()) {
            int temperature = scanner.nextInt();
            {
                if (temperature > -5) {
                    System.out.println("WARM");
                } else {
                    if (temperature > -20) {
                        System.out.println("NORMAL");
                    } else {
                        if (temperature - 20 > temperature) ;
                        System.out.println("COLD");
                    }
                }
                scanner.close();
            }
        }
    }

    public static void enterTask3() {
        for (int square = 10; square <= 20; square++) {
            System.out.println("the square of the number " + square + " equal to " + (square * square));
        }
    }

    public static void enterTask4() {
        int beginnin = 7;
        while (beginnin <= 98) {
            System.out.print(beginnin + " ");
            beginnin += 7;
        }
    }

    public static void enterTask5(){
      Scanner scanner = new Scanner(System.in);
         int number;
         long sum = 0;

         while (true){
             System.out.print("Please,enter your number: ");
             if (scanner.hasNext()){
                 number= scanner.nextInt();
                 if (number > 0) {
                     break;
                 }else{
                     System.out.println("The number must be positive.");
                 }
             }else{
                 System.out.println("Please enter an integer.");
                 scanner.next();
             }
         }
         sum = (long) number * (number + 1)/2;
        System.out.println("Sum number " + number + " equal to " + sum);
        scanner.close();

    }
}









