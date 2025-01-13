package TictacToe_OOP;

public abstract class Player {
    protected char marker;

    public Player(char marker) {
        this.marker = marker;
    }

    public abstract void makeMove(Board board);
    public char getMarker(){
        return marker;
    }
}

