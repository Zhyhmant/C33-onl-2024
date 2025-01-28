package TictacToe_OOP.Game;

import java.util.Random;

public class AIPlayer extends Player {
    private final Random random;

    public AIPlayer(char marker) {
        super(marker);
        this.random = new Random();
    }

    @Override
    public void makeMove(Board board) {
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        } while (board.setMove(row, col, marker));
        System.out.println("AI сделал ход.");
    }
}
