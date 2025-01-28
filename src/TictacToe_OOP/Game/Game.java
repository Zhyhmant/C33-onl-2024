package TictacToe_OOP.Game;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private final Board board;
    private final Player player1;
    private final Player player2;
    private  Player currentPlayer;
    private  Scanner scanner = new Scanner(System.in);


    public Game() {
        this.board = new Board();
        boolean playerFirst;
        if (new Random().nextBoolean()) playerFirst = true;
        else playerFirst = false;
        if (playerFirst){
            this.player1 = new HumanPlayer('X', scanner);
            this.player2 = new AIPlayer('O');
        } else {
            this.player1 =  new AIPlayer('X');
            this.player2 = new HumanPlayer('O', scanner);
        }
        this.currentPlayer = player1;
    }

    public void start() {
        System.out.println("Игра началась!");
        while (true) {
            board.draw();
            currentPlayer.makeMove(board);
            if (board.checkWin(currentPlayer.getMarker())) {
                board.draw();
                System.out.println("Победил игрок с маркером " + currentPlayer.getMarker() + "!");
                break;
            } else if (board.isFull()) {
                board.draw();
                System.out.println("Ничья!");
                break;
            }

            switchCurrentPlayer();
        }
    }
    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
