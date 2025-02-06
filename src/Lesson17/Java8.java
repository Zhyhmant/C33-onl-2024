package Lesson17;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class Java8 {
    public static void main(String[] args) {
        ConvertBynToUsd();
    }
    public static void HundredYearsOld(){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter birthday date at format YYYY-MM-DD");
            String input =scanner.nextLine();


            LocalDate birthDay = LocalDate.parse(input, DateTimeFormatter.ISO_LOCAL_DATE);

            LocalDate hundredYearOldDate = birthDay.plusYears(100);

            System.out.println("You will turn 100 years old:" + hundredYearOldDate);
    }

    public static void PositiveNumbers(){
        List<Integer> numbers = Arrays.asList(-5,10,-3,8,0,15);

        Predicate<Integer> isPositive = num -> num > 0 ;

        numbers.stream()
                .filter(isPositive)
                .forEach(System.out::println);
    }

    public static void ConvertBynToUsd(){
        double exchageRate = 0.34;

        Function<String,Double> convert = input ->{
            String[] parts = input.split(" ");
            double BYN = Double.parseDouble(parts[0]);
            return BYN * exchageRate;
        };
        String input = "1234 BYN";
        double USD = convert.apply(input);
        System.out.println(input + " = " + USD + "USD");
    }
}
