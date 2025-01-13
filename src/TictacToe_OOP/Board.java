package TictacToe_OOP;

public class Board {
    private char[][] board;

    public Board() {
        board = new char[][]{
                {'*', '*', '*'},
                {'*', '*', '*'},
                {'*', '*', '*'}
        };
    }

    public void draw() {
        System.out.println("\u001B[32m");
        for (char[] outer : board) {
            for (char inner : outer) {
                System.out.print("\t" + inner + " ");
            }
            System.out.println();
        }
        System.out.println("\u001B[0m");
    }

    public boolean setMove(int row, int col, char marker) {
        if (row < 0 || row > 2 || col < 0 || col > 2 || board[row][col] != '*') {
            return false;
        }
        board[row][col] = marker;
        return true;
    }


    public boolean checkWin(char marker) {
        // Проверка по горизонтали, вертикали и диагонали.
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == marker && board[i][1] == marker && board[i][2] == marker) ||
                    (board[0][i] == marker && board[1][i] == marker && board[2][i] == marker)) {
                return true;
            }
        }
        if ((board[0][0] == marker && board[1][1] == marker && board[2][2] == marker) ||
                (board[0][2] == marker && board[1][1] == marker && board[2][0] == marker)) {
            return true;
        }
        return false;
    }

    public boolean isFull() {
        for (char[] outer : board) {
            for (char inner : outer) {
                if (inner == '*') {
                    return false;
                }
            }
        }
        return true;
    }
}

