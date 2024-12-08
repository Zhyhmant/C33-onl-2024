package com_game_guessword;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class game_guessword {
    public static void main(String[] args) {
        startGame();


        if (getInput().nextLine().equals("y")) {
            getMessage();
        } else {
            System.out.println("Goodbye, come back.");
            return;
        }

    }

    public static void startGame() {
        welcome();

        char[] hiddenWord = getHiddenWords().toCharArray();
        char[] openWord = new char[hiddenWord.length];
        Arrays.fill(openWord, 0, openWord.length, '*');


        playOrNot();
        if (getInput().nextLine().equals("y")) {
            getMessage();
            printWord(openWord);
            getInputMsg();

            while (true) {
                String input = getInput().nextLine();
                if (input.length() == 0) {
                    System.out.print("You have not entered a letter, please enter a letter");
                    continue;
                } else if (input.length() == 1) {
                    checkleater();
                    break;
                } else if (input.length() > 1) {
                 if  (checkWord(input, hiddenWord)){
                     return;
                 }



                }
            }
        } else {
            System.out.println("Goodbye, come back.");
            return;
        }


    }

    public static void welcome() {
        System.out.println("|||||||||||||||||||||||||");
        System.out.println("\u001B[35mWelcome to game GUESS*WORD by Zhyhmant");
        System.out.println("The rules of the game");
        System.out.println("You need to guess the hidden word");
        System.out.println("The encrypted word will be displayed on the screen");
        System.out.println("You need to guess the whole word, or guess it by letters");
        System.out.println("If you decide to guess by letters, the number of attempts will be limited");
        System.out.println("Good LUCK\u001B[0m");
        System.out.println("|||||||||||||||||||||||||");

    }

    public static String[] getWordsFriuts() {
        return new String[]{
                "Apple",
                "Peach",
                "Banana",
                "Coconut",
                "Apricot",
                "Pineapple",

        };
    }

    public static String getHiddenWords() {
        String[] hiddenWord = getWordsFriuts();

        return hiddenWord[new Random().nextInt(0, hiddenWord.length)];
    }

    public static void printWord(char[] word) {
        for (char element : word) {
            System.out.print("'" + element + "'");
        }
    }

    public static void playOrNot() {
        System.out.println("\u001B[34m|||||||||||||||||||||||||");
        System.out.print("If you want to start the game, press |Y|, if you exit any key...\u001B[0m");
    }

    public static Scanner getInput() {
        return new Scanner(System.in);
    }

    public static void getMessage() {
        System.out.println("\u001B[32m|||||||||||||||||||||||||");
        System.out.println("The word is invented, start playing\u001B[0m");
    }

    public static void getInputMsg() {
        System.out.println("You see a hidden word in front of you, please enter the letter or the whole word");
    }

    public static void checkleater() {

    }

    public static boolean checkWord(String input, char[] hiddenWord) {
        System.out.println("You have entered a word: " + input);
        System.out.println("Your hidden word equals: " + Arrays.toString(hiddenWord));

        if (!Arrays.equals(input.toCharArray(), hiddenWord)) {
            System.out.println("You have entered wrong word.");
        }else{
            getWonMassage();
            return true;
        }
        return false;
    }

    public static void getWonMassage(){
        System.out.print("\u001B[31mYOU WON !!!Congratulations\u001B[0m");
        System.out.println("\u001B[41mPLEASE ENTER\u001B[0m");
    }
}