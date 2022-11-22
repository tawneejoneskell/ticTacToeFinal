import Models.Gameboard;
import Models.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        Player playerOne = new Player('x');
        Player playerTwo = new Player('o');

        Gameboard myBoard = new Gameboard(3, 3);
        int maxTurns = 5;
        int currentTurn = 1;
        boolean aPlayerHasWon = false;

        while((currentTurn <= maxTurns) && !aPlayerHasWon) {
            printInstructions(playerOne);
            int userParams1 = inputScanner.nextInt();
            int[] userSquare1 = mapInputToSquare(userParams1);
            myBoard.takeTurn(playerOne.getSymbol(), userSquare1[0], userSquare1[1]);
            aPlayerHasWon = checkWinner(myBoard, playerOne);

            if(!aPlayerHasWon) {
                printInstructions(playerTwo);
                int userParams2 = inputScanner.nextInt();
                int[] userSquare2 = mapInputToSquare(userParams2);
                myBoard.takeTurn(playerTwo.getSymbol(), userSquare2[0], userSquare2[1]);
                aPlayerHasWon = checkWinner(myBoard, playerTwo);
            }

            currentTurn++;
        }
    }

    public static void printInstructions(Player selectedPlayer) {
        System.out.println("Player: " + selectedPlayer.getSymbol() + ", please take your turn!");
        System.out.println("0: upper-left, 1: upper-center, 2: upper-right");
        System.out.println("3: center-left, 4: center 5: center-right");
        System.out.println("6: bottom-left, 7: bottom-center, 8: bottom-right");
    };

    public static int[] mapInputToSquare(int input){
        switch(input){
            case 0:
               return new int[]{0, 0};
            case 1:
                return new int[]{0,1};
            case 2:
                return new int[]{0,2};
            case 3:
                return new int[]{1,0};
            case 4:
                return new int[]{1,1};
            case 5:
                return new int[]{1,2};
            case 6:
                return new int[]{2,0};
            case 7:
                return new int[]{2,1};
            case 8:
                return new int[]{2,2};
            default:
                return new int[]{};
        }
    };

    public static boolean checkWinner( Gameboard myGameboard, Player playerToTest){
        char symbol = playerToTest.getSymbol();
        final int[][] victoryOne = {{0,0},{1,0},{2,0}};
        final int[][] victoryTwo = {{0,0},{1,1},{2,2}};
        final int[][] victoryThree = {{1,0},{1,1},{1,2}};
        final int[][] victoryFour = {{2,0},{1,1},{0,2}};
        final int[][] victoryFive = {{0,1},{1,1},{2,1}};
        final int[][] victorySix = {{2,0},{2,1},{2,2}};
        final int[][] victorySeven = {{0,0},{0,1},{0,2}};
        final int[][] victoryEight = {{0,2},{1,2},{2,2}};
        final int[][][] masterVictoryList = {victoryOne, victoryTwo, victoryThree, victoryFour, victoryFive, victorySix, victorySeven, victoryEight};

        for(int i =0; i< masterVictoryList.length; i++){
            int count = 0;
            for(int j=0; j<masterVictoryList[i].length; j++){
                final int row = masterVictoryList[i][j][0];
                final int column = masterVictoryList[i][j][1];
                if(myGameboard.getSymbolAt(row,column) == symbol) {
                    count++;
                }
            }
            if(count >=3) {
                System.out.println("Player " + playerToTest.getSymbol() + " has won!");
                return true;
            }
        }
        System.out.println("It is now the next player's turn!");
        return false;
    }
}