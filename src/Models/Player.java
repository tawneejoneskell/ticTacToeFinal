package Models;

public class Player {
    private char symbol;
    private int maxNumberOfTurns;
    private int turnsTaken;

    public Player(char symbol){
        this.symbol = symbol;
        this.maxNumberOfTurns = 5;
        this.turnsTaken = 0;
    }
    public char getSymbol(){
        return symbol;
    }

    @Override
    public String toString() {
        return "Player{" +
                "symbol=" + symbol +
                '}';
    }

    public void setSymbol(char symbol){
        this.symbol = symbol;

    }
    public int getMaxNumberOfTurns(){
        return maxNumberOfTurns;
    }
    public void setMaxNumberOfTurns(int maxNumberOfTurns){
        this.maxNumberOfTurns = maxNumberOfTurns;
    }
    public int getTurnsTaken(){
        return turnsTaken;
    }
    public void setTurnsTaken(int turnsTaken){
        this.turnsTaken = turnsTaken;
    }

}
