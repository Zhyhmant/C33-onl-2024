package Lesson2;

import java.sql.SQLOutput;

public class JavaHomework {
    public static void main(String[] args) {
        enterTask6();
    }
        public static void enterTask() {
            int valueVeriableLow = 10;
            int valueVeriableHigh = 15;
            System.out.print(4 * (valueVeriableLow + valueVeriableHigh - 1) / 2);
        }

        public static void enterNextTask(){
            int valueNumberOut = 15;
            int valueMin = 1;
            int valueMax = 5;
            System.out.print(valueMin + valueMax);
            }
        public static void enterTask3(){
         int valueNumberOut = 159;
         int valueMeaningMin = 1;
         int valueMeaningMid = 5;
         int valueMeaningMax = 9;
         System.out.print(valueMeaningMin + valueMeaningMid + valueMeaningMax);
           }


         public static void enterTask4(){
             double valueNamberDouble = 1.5;
             int valueMeaning =(int)(valueNamberDouble+0.5);
                System.out.println(valueMeaning);
            }
         public static void enterTask5(){
          int valueI = 10;
          int valueB = 6;
          int valueX = valueI/valueB;
          int valueY = valueI%valueB;
             System.out.println(valueX + "." + valueY);
         }

         public static void enterTask6(){
          int valueA = 1;
          int valueB = 2;
          valueA = valueA^valueB;
          valueB = valueB^valueA;
          valueA = valueA^valueB;
             System.out.println(valueB);
         }

        }



