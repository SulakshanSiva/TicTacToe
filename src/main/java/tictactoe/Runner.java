package tictactoe;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {    
        //declare and initialize scanner to take in user input
        Scanner input = new Scanner(System.in);
        //display welcome messages to user
        System.out.println("Welcome to Tic Tac Toe!\n");
        System.out.println("This is a Two Player game.");
        //declare player objects and initialize using constructor
        Player playerOne = new Player('X',"Player One", false);
        Player playerTwo = new Player('O', "Player Two", true);
        //display player messages and show player representaion by symbol
        System.out.println(playerOne.getPlayerName() + " will be represented by " + playerOne.getPlayerSymbol());
        System.out.println(playerTwo.getPlayerName() + " will be represented by " + playerTwo.getPlayerSymbol());
        //display start game message
        System.out.println("This is the board. " + playerOne.getPlayerName() + " will start the game.");
        //declare board
        Board gameBoard = new Board();

        //create board
        gameBoard.createBoard();
        gameBoard.setGameEnd(false);

        //declare variable for temp player and position on board
        Player tempPlayer = gameBoard.checkPlayerTurn(playerOne, playerTwo);
        int position = 0;

        //loop until game has been won or tied
        while(!gameBoard.getGameEnd()){

            //show board and prompt for player move
            gameBoard.displayBoard();
            //prompt player for the position they would like to move to on the board
            position = gameBoard.promptPlayerMove(tempPlayer, input);

            //make player move
            gameBoard.makeMove(position, tempPlayer);

            //check board for win or tie game
            gameBoard.checkGameState(tempPlayer, gameBoard);

            //switch to next player turn
            tempPlayer = gameBoard.checkPlayerTurn(playerOne, playerTwo);

        }//end while loop

        //display game board
        gameBoard.displayBoard();    
        
        //close scanner
        input.close();
    }
}
