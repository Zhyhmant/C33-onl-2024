package Lesson3;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Lesson_3_homework {
    public static void main(String[] args) {
        enterTask1();
    }

    public static void enterTask1() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number :");
        String numer = input.nextLine();
        System.out.print("True or false :");
        String truse = input.nextLine();
    }
}