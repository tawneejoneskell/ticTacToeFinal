package Models;

import java.util.ArrayList;
import java.util.Arrays;

public class Gameboard {
    private int rows;
    private int columns;
    private ArrayList<ArrayList<String>> board;

    public Gameboard(int rows, int columns){
        this.rows=rows;
        this.columns = columns;

        ArrayList<String> initialContent = new ArrayList<String>();
        for(int i = 0; i < columns; i++) {
            initialContent.add(i, "|_ _|");
        };

        ArrayList<ArrayList<String>> finalBoard = new ArrayList<ArrayList<String>>(rows);
        for(int i = 0; i < rows; i++) {
            finalBoard.add(new ArrayList(initialContent));
        };

        this.board = finalBoard;
    }
    public int getRows(){
        return this.rows;
    }
    public void setRows(int rows){
        this.rows=rows;
    }

    public ArrayList<ArrayList<String>> getBoard() {
        return this.board;
    }


    public void getFormattedBoard() {
            Integer[] breakpoints = {2, 5, 8, 11, 14, 17, 20};
        for(int j = 0; j < 3; j++) {
            for(int k= 0; k < 3; k++) {
                if(Arrays.asList(breakpoints).contains(k)) {
                    System.out.print(this.board.get(j).get(k) + "\n" );
                } else {
                    System.out.print(this.board.get(j).get(k));
                }
            }
        }
        System.out.println("Above is the new game board.");
        System.out.println("________________________________");
    }

    public void takeTurn(char playerSymbol, int rowPosition, int columnPosition) {
        this.board.get(rowPosition).set(columnPosition, "|_" + playerSymbol + "_|");
        getFormattedBoard();
    }

    public char getSymbolAt(int row, int column){
        return this.board.get(row).get(column).charAt(2);
    }
}
