package Lesson11;

import java.util.*;

public class StringHomework {
    public static void main(String[] args) {
        palindromeChecker();

    }
        public static void stringLength() {
            Scanner scanner = new Scanner(System.in);
            String[] strings = new String[3];

            for (int i = 0; i < 3; i++) {
                System.out.println("Enter string " + (i + 1) + ":");
                strings[i] = scanner.nextLine();
            }
            String shortest = strings[0];
            String longest = strings[0];

            for (int i = 0; i < 3; i++) {
                if (strings[i].length() < shortest.length()) {
                    shortest = strings[i];
                }
                if (strings[i].length() > longest.length()) {
                    longest = strings[i];
                }
            }
            System.out.println("The shortest line: \"" + shortest + "\", length" + shortest.length());
            System.out.println("The longest line: \"" + longest + "\", length" + longest.length());
            scanner.close();
        }

        public static void sortString(){
        Scanner scanner = new Scanner(System.in);
        String[] strings = new String[3];

        for(int i=0; i<3; i++){
            System.out.println("Enter line: " + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }
        Arrays.sort(strings, Comparator.comparingInt(String::length));

        System.out.println("The rows are in ascending order of their length:");
        for (String str: strings){
            System.out.println(str);
        }
        scanner.close();


    }

        public static void averageLength(){
        Scanner scanner = new Scanner(System.in);
        String[] strings = new String[3];
        int totallength = 0;

        for(int i=0; i<3; i++){
            System.out.println("Enter line " + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
            totallength += strings[i].length();
        }
        double averageLength = (double) totallength/3;

        System.out.println("Lines that are shorter than the average length (" +
                String.format("%.2f",averageLength) + "):");
        for (String str: strings){
            if(str.length()<averageLength){
                System.out.println("Line: \"" + str + "\", length: " + str.length());
            }
        }
        scanner.close();
    }
        public static void uniqueChar(){
        Scanner scanner = new Scanner(System.in);
        String[] strings = new String[3];

        for(int i=0; i<3; i++){
            System.out.println("Enter line:" + (i + 1) + ": ");
            strings[i] = scanner.nextLine();
        }
        String uniqueWord = null;
        for(String str : strings){
            String[] words = str.split(" ");
            for (String word: words){
                if (hasUniqueChars(word)){
                    uniqueWord = word;
                    break;
                }
            }
            if(uniqueWord != null){
                break;
            }
        }
        if( uniqueWord != null){
            System.out.println("The first word with unique characters: " + uniqueWord);
        }else {
            System.out.println("There are no words with unique characters.");
        }
        scanner.close();
    }
        private static boolean hasUniqueChars(String word){
        Set<Character> chars = new HashSet<>();
        for(char c: word.toCharArray()){
            if(!chars.add(c)){
                return false;
            }
        }
        return true;
    }

        public static void duplicateChars(){
        Scanner scanner = new Scanner(System.in);

            System.out.println("Enter line:");
            String input = scanner.nextLine();

            StringBuilder result = new StringBuilder();
            for(char c: input.toCharArray()){
                result.append(c).append(c);
            }
            System.out.println("Result: " + result.toString());
            scanner.close();
        }

        public static void palindromeChecker(){
        Scanner scanner = new Scanner(System.in);
            System.out.println("Enter line: ");
            String input = scanner.nextLine();
            System.out.println("Enter number word please: ");
            int wordNumber = 0;
            try {
                String number = scanner.nextLine();
                wordNumber = Integer.parseInt(number);
            }catch (NumberFormatException e){
                System.out.println("Incorecter enter, enter number please ");
                scanner.close();
                return;
            }
            String[] words = input.split(" ");
            if(wordNumber <= 0 || wordNumber > words.length){
                System.out.println("Error: Incorrect word number is entered.");
                scanner.close();
                return;
            }
            String wordToCheck = words[wordNumber -1];

            if (isPalindrome(wordToCheck)){
                System.out.println("Word \"" + wordToCheck + "\" is palindrom");
            }else {
                System.out.println("Word \"" + wordToCheck + "\" is not palinrom");
            }
            scanner.close();
        }
        private static boolean isPalindrome(String word){
        String cleanedWord =  word.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reverseWord = new StringBuilder(cleanedWord).reverse().toString();
        return cleanedWord.equals(reverseWord);
        }
}
