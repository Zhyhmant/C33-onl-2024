package TictacToe_OOP;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private final Scanner scanner;

    public HumanPlayer(char marker, Scanner scanner) {
        super(marker);
        this.scanner = scanner;
    }

    @Override
    public void makeMove(Board board) {
        int row = -1, col = -1;
        do {
            System.out.print("Введите номер строки (1-3): ");
            String rowInput = scanner.nextLine();
            System.out.print("Введите номер столбца (1-3): ");
            String colInput = scanner.nextLine();

            try {
                row = Integer.parseInt(rowInput) - 1;
                col = Integer.parseInt(colInput) - 1;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод! Пожалуйста, введите целое число.");
                continue;
            }
            if (!board.setMove(row,col,marker)){
                System.out.println("Некорректный ввод! Попробуйте еще раз.");
            }

        } while (!board.setMove(row, col, marker));
    }

}

