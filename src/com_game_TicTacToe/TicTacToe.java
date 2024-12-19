package com_game_TicTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args){
     startGame();
    }
    //Start game
    public static void startGame() {
        getInitialMessage();
        //Сканер который начинает игру либо выход из игры
        if (getInputValue().nextLine().equals("y")) {
            System.out.println("You have started playing, welcome");
            System.out.println("|||||||||||||||||||||||||||||||||||||||||||");
        char[][] gameTable = createInitializeTable();
        drawTable(gameTable);

        int dice = getRandomNumbers().nextInt(0,20);
        if (dice >= 0 && dice<= 10) {
            //Игрок первый
            makePlayerMove();
        }else{
            //Первый AI`
            makeAIMove();
        }
        } else {
            System.out.println("You are out of the game, goodbye.");
        }
    }
    public static void setGameTableValue(char[][] gameTable){

    }
    // Создаем таблицу
    public static char[][] createInitializeTable(){
        return new char[][]{
                {'*', '*', '*'},
                {'*', '*', '*'},
                {'*', '*', '*'}
        };
    }
    public static void getInitialMessage(){
        System.out.println("\u001B[34mStart of the game tic tac toe");
        System.out.println("The rules of the game :");
        System.out.println("Randomly, the game will determine who will start first");
        System.out.println("If the player needs to enter X");
        System.out.println("If AI O\u001B[0m");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||");
        System.out.print("Do you want to continue and start playing? Press |Y| or ane key :");

    }
    //Метод для рисования таблицы
    public static void drawTable(char[][] gameTable){
        System.out.println("\u001B[32m");
        for(char[] outer: gameTable){
            for(char inner : outer){
                System.out.print("\t" + inner + " ");
            }
            System.out.println();
        }
        System.out.println("\u001B[0m");

    }
    //Метод для шага искуственного интелекта
    public static void makeAIMove(){
        System.out.println("AI firs move...");
        int cellAI = getRandomNumbers().nextInt(0,3);
        int collomnAI = getRandomNumbers().nextInt(0,3);

        System.out.println("AI has decided to make the following move: [" +
                (cellAI + 1) + "][" + (collomnAI + 1) + "].");
    }
    //Метод для шага игрока
    public static void makePlayerMove(){
        System.out.println("Player first move...");
        while (true){
            System.out.print("Please, enter coordinates cell (1-3): ");
            int cellPlayer = getInputValue().nextInt();
            System.out.print("Please, enter coordinates column (1-3): ");
            int columnPlayer = getInputValue().nextInt();

            if (cellPlayer >= 1 && cellPlayer <=3 && columnPlayer >= 1 && columnPlayer <=3){
                System.out.println("The player have decided to put a value: [" +
                        cellPlayer + "][" + columnPlayer + "].");
                break;
            }
            System.out.println("\u001B[31m");
            System.out.println("YOU HAVE ENTERED WRONG VALUE ,PLEASE ENTER COORECT VALUE");
            System.out.println("\u001B[0m");
        }

    }
    //Проверить статус
    public static void checkStatus(){

    }
    //Метод вводить рандомное число
    public static Random getRandomNumbers(){
        return new Random();
    }
    // Get input
    public static Scanner getInputValue(){
            return new Scanner(System.in);
    }
}
