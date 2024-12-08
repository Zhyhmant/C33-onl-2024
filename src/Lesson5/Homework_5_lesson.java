package Lesson5;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;



public class Homework_5_lesson {
    public static void main(String[] args) {
        taskThree();
    }

    public static void taskOne() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int line, colomn;
        while (true) {
            System.out.print("Pleae ,enter line : ");
            if (scanner.hasNext()) {
                line = scanner.nextInt();
                if (line > 0)
                    break;
                System.out.print("The number of rows must be greater than 0");
            } else {
                System.out.print("Incorrect input. Please enter an integer.");
                scanner.next();
            }
        }
        while (true) {
            System.out.print("Please ,enter colomn: ");
            if (scanner.hasNext()) {
                colomn = scanner.nextInt();
                if (colomn > 0)
                    break;
                System.out.print("The number of columns must be greater than 0: ");
            } else {
                System.out.print("Incorrect input. Please enter an integer.");
                scanner.next();
            }
        }
        int[][] array = new int[line][colomn];
        for (int l = 0; l < line; l++) {
            for (int c = 0; c < colomn; c++) {
                array[l][c] = random.nextInt(20);
            }
            System.out.println("Array:");
            for (int[] lines : array) {
                System.out.println(Arrays.toString(lines));
            }
            int inValue;
            while (true) {
                System.out.print("Pleas,enter number: ");
                if (scanner.hasNextInt()) {
                    inValue = scanner.nextInt();
                    break;
                } else {
                    System.out.println("Wrong");
                    scanner.next();
                }
            }
            int sum = 0;
            for (l = 0; l < line; l++) {
                for (int c = 0; c < colomn; c++) {
                    array[l][c] += inValue;
                    sum += array[l][c];
                }
            }
            System.out.print("\n Array corrected:");
            for (int[] lines : array) {
                System.out.println(Arrays.toString(lines));
            }
            System.out.println("\n Sum all elements: " + sum);
            scanner.close();
        }

    }

    public static void taskTwo() {
        String[][] chessDesk = new String[8][8];
        for (int b = 0; b < 8; b++) {
            for (int w = 0; w < 8; w++) {
                if ((b + w) % 2 == 0) {
                    chessDesk[b][w] = "W";
                } else {
                    chessDesk[b][w] = "B";

                }
            }

        }
        for (int b = 0; b < 8; b++) {
            for (int w = 0; w < 8; w++) {
                System.out.print(chessDesk[b][w] + " ");
            }
            System.out.println();
        }
    }
    public static void taskThree(){
     Scanner scanner = new Scanner(System.in);
        System.out.print("Please ,enter RAW(n): ");
        int n = scanner.nextInt();
        System.out.print("Pleas,enter COLOMN(m): ");
        int m = scanner.nextInt();

        int[][] array = new int [n][m];
        int value = 1;
        boolean right = true;

        for(int i = 0 ; i < n ; i++){
         if (right) {
             for (int j = 0; j < m; j++) {
                 array[i][j] = value++;
             }
         }else{
             for(int j = m -1 ;j<=0;j--){
                 array[i][j] = value++;
         }
     }
         right = !right;
    }
       for(int i = 0;i < n;i++){
           for (int j = 0;j<m;j++){
               System.out.printf("%3d",array[i][j]);
           }
        System.out.println();
       }
       scanner.close();
}
}