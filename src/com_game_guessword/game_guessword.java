package com_game_guessword;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.lang.String;


public class game_guessword {
    private static final int MAX_ATTEMPTS = 2;
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        boolean playAgain = true;
        do {
            startGame();
            playAgain = askPlayAgain();
        } while (playAgain);
        scanner.close();
    }


    public static void startGame() {

        char[] hiddenWord = getHiddenWords().toCharArray();
        char[] displayedWord = new char[hiddenWord.length];
        Arrays.fill(displayedWord, 0,displayedWord.length,'*');
        StringBuilder usedLetters = new StringBuilder();
        int attemptsRemaining = MAX_ATTEMPTS;

        welcome();
        playOrNot();
        
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            getMessage();

            while (attemptsRemaining > 0 && !Arrays.equals(displayedWord, hiddenWord)) {
                System.out.println("\nThere are still attempts left: " + attemptsRemaining);
                printWord(displayedWord);
                System.out.print("The letters used: " + usedLetters + "\nEnter a letter or word: ");
                String input = scanner.nextLine().toLowerCase();

                if (input.length() == 0) {
                    System.out.println("You haven't entered anything!");
                    continue;
                } else if (input.length() == 1) {
                    if (!Character.isLetter(input.charAt(0))) {
                        System.out.println("Incorrect input! Enter a letter.");
                        continue;
                    }
                    checkLetter(input.charAt(0), hiddenWord, displayedWord, usedLetters);
                } else {
                    if (checkWord(input, hiddenWord)) {
                        break;
                    }
                }
                attemptsRemaining--;
            }

            if (Arrays.equals(displayedWord, hiddenWord)) {
                getWonMessage();
            } else {
                System.out.println();
            }
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

    public static String[] getWordsFruits() {
        return new String[]{
                "apple",
                "peach",
                "banana",
                "coconut",
                "apricot",
                "pineapple",

        };
    }

    public static String getHiddenWords() {
        String[] hiddenWord = getWordsFruits();

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

    public static void getMessage() {
        System.out.println("\u001B[32m|||||||||||||||||||||||||");
        System.out.println("The word is invented, start playing\u001B[0m");
    }


    public static boolean checkLetter(char letter, char[] hiddenWord, char[] displayedWord, StringBuilder usedLetters) {
        if (usedLetters.indexOf(String.valueOf(letter)) != -1) {
            System.out.println("This letter has already been used!");
            return false;
        }
        usedLetters.append(letter);
        boolean letterFound = false;
        for (int i = 0; i < hiddenWord.length; i++) {
            if (hiddenWord[i] == letter && displayedWord[i] == '*') {
                displayedWord[i] = letter;
                letterFound = true;
            }
        }
        if (!letterFound) {
            System.out.println("There is no such letter in the word.");
        }
        return letterFound;
    }

    public static boolean checkWord(String input, char[] hiddenWord) {
        if (input.equalsIgnoreCase(new String(hiddenWord))) {
            getWonMessage();
            return true;
        } else {
            System.out.println("The wrong word!");
            return false;
        }
    }

    public static void getWonMessage() {

        System.out.println("\u001B[31mVICTORY!!!Congratulations!!!\u001B[0m");
    }

    public static boolean askPlayAgain(){
        System.out.print("\u001B[33mDo you want to play again? (y/n): \u001B[0m");
        String answer = scanner.nextLine().trim().toLowerCase();
        System.out.println();
        return answer.equals("y");
    }
}


