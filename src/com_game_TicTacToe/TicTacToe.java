package com_game_TicTacToe;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();
    private static final char PLAYER_MARKER = 'X';
    private static final char AI_MARKER = 'O';
    private static char[][] gameTable;

    public static void main(String[] args) {
        startGame();
        scanner.close();
    }

    public static void startGame() {
        getInitialMessage();

        //Сканер который начинает игру либо выход из игры
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            System.out.println("Start GAME");
            gameTable = createInitializeTable(); // Инициализация игрового поля
            drawTable(gameTable);
            boolean playerTurn = random.nextBoolean(); // Случайный выбор, кто ходит первым

            boolean gameFinished = false;
            while (!gameFinished) {  //Игровой цикл пока игра не закончена.
                if (playerTurn) {
                    makePlayerMove(gameTable, PLAYER_MARKER);
                } else {
                    makeAIMove(gameTable, AI_MARKER);
                }
                drawTable(gameTable); //Обновляем экран после каждого хода

                if (checkWin(gameTable, playerTurn ? PLAYER_MARKER : AI_MARKER)) {
                    System.out.println((playerTurn ? "Player" : "AI") + " WIN!");
                    gameFinished = true; // игра закончена, если есть победитель
                } else if (isTableFull(gameTable)) {
                    System.out.println("DRAW!");
                    gameFinished = true; //игра закончена, если ничья
                } else {
                    playerTurn = !playerTurn; //передача хода
                }
            }
        } else {
            System.out.println("Good Buy!");
        }
    }
    // Создаем таблицу
    public static char[][] createInitializeTable() {
        return new char[][]{
                {'*', '*', '*'},
                {'*', '*', '*'},
                {'*', '*', '*'}
        };
    }

    public static void getInitialMessage() {
        System.out.println("\u001B[34mStart of the game tic tac toe");
        System.out.println("The rules of the game :");
        System.out.println("Randomly, the game will determine who will start first");
        System.out.println("If the player needs to enter X");
        System.out.println("If AI O\u001B[0m");
        System.out.println("|||||||||||||||||||||||||||||||||||||||||||");
        System.out.print("Do you want to continue and start playing? Press |Y| or ane key :");

    }

    //Метод для рисования таблицы
    public static void drawTable(char[][] gameTable) {
        System.out.println("\u001B[32m");
        for (char[] outer : gameTable) {
            for (char inner : outer) {
                System.out.print("\t" + inner + " ");
            }
            System.out.println();
        }
        System.out.println("\u001B[0m");

    }

    //Метод для шага искуственного интелекта

    public static void makeAIMove(char[][] gameTable, char marker) {
        System.out.println("Move AI...");
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (gameTable[row][col] != '*'); // проверка на занятую клетку
        gameTable[row][col] = marker;
    }

    //Метод для шага игрока
    public static void makePlayerMove(char[][] gameTable, char marker) {
        System.out.println("You move...");
        int row = 0, col = 0;
        do {
            System.out.print("Please enter row (1-3): ");
            String rowInput = scanner.nextLine();
            System.out.print("Please enter col(1-3): ");
            String colInput = scanner.nextLine();

            try {
                row = Integer.parseInt(rowInput) - 1;
                col = Integer.parseInt(colInput) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Incorrect input! Please enter an integer.");
                continue; // Переходим на следующую итерацию do-while
            }

            if (row < 0 || row > 2 || col < 0 || col > 2 || gameTable[row][col] != '*') {
                System.out.println("Incorrect input! Try again.");
            }
        } while (row < 0 || row > 2 || col < 0 || col > 2 || gameTable[row][col] != '*');
        gameTable[row][col] = marker;
    }


    public static boolean checkWin(char[][] gameTable, char marker) {
        // Проверка по горизонтали, вертикали и диагонали.
        for (int i = 0; i < 3; i++) {
            if ((gameTable[i][0] == marker && gameTable[i][1] == marker && gameTable[i][2] == marker) ||
                    (gameTable[0][i] == marker && gameTable[1][i] == marker && gameTable[2][i] == marker)) {
                return true;
            }
        }
        if ((gameTable[0][0] == marker && gameTable[1][1] == marker && gameTable[2][2] == marker) ||
                (gameTable[0][2] == marker && gameTable[1][1] == marker && gameTable[2][0] == marker)) {
            return true;
        }
        return false;
    }

    public static boolean isTableFull(char[][] gameTable) {
        for (char[] outer : gameTable) {
            for (char inner : outer) {
                if (inner == '*') {
                    return false;
                }
            }
        }
        return true;
    }
}
