package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

 /*
  * Represent a class for the Tic Tac Toe game board.
  */
public class Board {
    //declare and initialize variables for the rows of the board and for the game state
    private int[][] rows = new int[3][3];
    private boolean gameEnd = false;
    /*
     * createBoard(): Creates the board and initializes the indexes
     */
    public void createBoard(){

        //declare and initialize a counter
        int counter = 0;
        //loop through the rows of the 2d array
        for(int i = 0; i < rows.length; i++){
            for(int j = 0; j < rows[i].length; j++){
                //initialize the indexes of the array
                rows[i][j] = counter;
                //add 1 to counter
                counter++;
            }//end inner for
        }//end outer for

    }//end method

    /*
     * displayBoard(): Displays the board to user
     */
    public void displayBoard(){
        //loop through rows of array(loop through the board positions)
        for(int i = 0; i < rows.length; i++){
            for(int j = 0; j < rows[i].length; j++){
                //if index of array has a player symbol
                if(rows[i][j] == 88 || rows[i][j] == 79){
                    //display player symbol on board to user
                    if(j == rows[i].length - 1){
                        System.out.print((char)rows[i][j]);
                    } else {
                        System.out.print((char)rows[i][j] + "|");
                    }
                    
                } else {
                    //display board position on board to user
                    if(j == rows[i].length - 1){
                        System.out.print(rows[i][j]);
                    } else {
                        System.out.print(rows[i][j] + "|");
                    }
                }
                
            }//end inner for

            //display board lines to seperate board position
            if(i != rows.length - 1){
                System.out.println("");
                System.out.println("-+-+-");
            } else {
                System.out.println("\n");
            }

        }//end outer for
    }//end method

    /*
     * checkPlayerTurn(): Checks whose player turn it was and sets the next player to have a turn
     * @param pOne - player one
     * @param pTwo - player two
     * @return the player who currently has a turn
     */
    public Player checkPlayerTurn(Player pOne, Player pTwo){
        //if player one has just had a turn 
        if(pOne.getPlayerTurn()){
            //set player two to have a turn
            pTwo.setPlayerTurn(true);
            pOne.setPlayerTurn(false);
            //return player two
            return pTwo;
        } else {
            //set player one to have a turn
            pTwo.setPlayerTurn(false);
            pOne.setPlayerTurn(true);
            //return player one
            return pOne;
        }
    }//end method

    /*
     * promptPlayerMove(): Prompts player to enter a valid move 
     * @param player - Player who currently has a turn
     * @param in - Scanner to take in user input
     * @return the position that the player would like to move to 
     */
    public int promptPlayerMove(Player player, Scanner in){
        /*
         * declare and initialize variables for player position on board, counter,
         * and a checker to see if board position is free for player move
         */
        int move = -1;  
        int counter = 0;
        boolean spotTaken = true;
        //prompt player for move
        System.out.println("Turn = " + player.getPlayerSymbol());
        System.out.println("Enter a number between 0 and 8: ");
        do{
            //if player has already tried to enter a value 
            if(counter > 0){
                //display error message and reprompt
                System.out.println("Error. Enter a number between 0 and 8 that has not been selected yet: ");
            }
            try {
                //get user input
                move = in.nextInt();
            } catch (InputMismatchException e) {
                //display error message
                System.out.println("Invalid input.");
                //clear invalid input
                in.nextLine();
            }
            //check to see if board spot has not already been selected
            for(int i = 0; i < rows.length; i++){
                for(int j = 0; j < rows[i].length; j++){
                    if(spotTaken){
                        //if the player move has not been taken
                        if(move == rows[i][j]){
                            //set variable to false
                            spotTaken = false;
                            //break out of loop
                            break;
                        }
                    }
                }//end inner for
            }//end outer for

            //add 1 to counter
            counter++;
        }
        //loop until user enters valid input
        while(move < 0 || move > 8 || spotTaken);
        //return player move
        return move;
    }//end method

    /*
     * makeMove(): makes the player move and sets the move on the board
     * @param boardPosition - position that player would like to move to
     * @param playerNum - player that is currently moving
     */
    public void makeMove(int boardPosition, Player playerNum){
        //loop through board rows
        for(int i = 0; i < rows.length; i++){
            for(int j = 0; j < rows[i].length; j++){
                //if board position is same as player move position
                if(boardPosition == rows[i][j]){
                    //set player Symbol at board position
                    rows[i][j] = playerNum.getPlayerSymbol();
                }
            }//end inner for
        }//end outer for

    }//end method

    /*
     * checkRowWin(): checks to see if player has won by a row
     * @param player - player that is current playing
     */
    public void checkRowWin(Player player){
        //declare and initialize variable for win 
        boolean win = true;

        //loop through board rows
        for(int i = 0; i < rows.length; i++){
            for(int j = 0; j  < rows[i].length - 1; j++){
                //if current board index is not equal to the next board index
                if(rows[i][j] != rows[i][j + 1]){
                    //set win to false
                    win = false;
                    //break out of loop
                    break;
                } else {
                    //set win to true
                    win = true;
                }
            }//end inner for

            //if player has won
            if(win){
                //set game to end
                gameEnd = true;
                //print player win message
                System.out.println(player.getPlayerName() + ": " + player.getPlayerSymbol() + " has won!");
                //exit loop
                break;
            }

        }//end outer for

    }//end method

    /*
     * checkColumnWin(): checks to see if player has won by a column
     * @param player - player that is current playing
     */
    public void checkColumnWin(Player player){
         //declare and initialize variable for win 
        boolean win = true;

        //if game has not already ended
        if(!gameEnd){
            //loop through board columns
            for(int i = 0; i < rows.length; i++){
                for(int j = 0; j  < rows[i].length - 1; j++){
                    //if current board index is not equal to the next board index
                    if(rows[j][i] != rows[j + 1][i]){
                        //set win to false
                        win = false;
                        //exit loop
                        break;
                    } else {
                        //set win to true
                        win = true;
                    }
                }//end inner for

                //if player has won
                if(win){
                    //set game to end
                    gameEnd = true;
                    //print player win message
                    System.out.println(player.getPlayerName() + ": " + player.getPlayerSymbol() + " has won!");
                    //exit loop
                    break;
                }

            }//end outer for
            
        }//end if
    }//end method

    /*
     * checkDiagonalWin(): checks to see if player has won by a diagonal
     * @param player - player that is current playing
     */
    public void checkDiagonalWin(Player player){
         //declare and initialize variable for win 
        boolean win = true;

        //if game has not already ended
        if(!gameEnd){
            //check diagonal win from left to right
            for(int i = 0; i < 2; i++){
                //if current board index is not equal to the next board index
                if(rows[i][i] != rows[i+1][i+1]){
                    //set win to false
                    win = false;
                }
            }//end for loop

            //if player has not won yet
            if(!win){
                //initialize win to true
                win = true;
                //counter for disgonal column position
                int counter = 2;    
                //check diagonal win from right to left
                for(int i = 0; i < 2; i++){
                    //if current board index is not equal to the next board index
                    if(rows[i][counter] != rows[i + 1][counter - 1]){
                        //set win to false
                        win = false;
                    } else {
                        //subtract one from counter
                        counter--;
                    }
                }//end for loop
            }

            //if player won
            if(win){
                //set game to end
                gameEnd = true;
                //display player win message
                System.out.println(player.getPlayerName() + ": " + player.getPlayerSymbol() + " has won!");
            }

        }//end outer if

    }//end method

    /*
     * checkTieGame(): checks to see if the game has ennded in a tie
     */
    public void checkTieGame(){
        //declare and initialize variable for tie game
        boolean tie = true;

        //if game has not ended already
        if(!gameEnd){
            //loop through board positions
            for(int i = 0; i < rows.length; i++){
                for(int j = 0; j < rows.length; j++){
                    //if the board position has not been filled with a player move yet
                    if(rows[i][j] < 10){
                        //game is not tied, set false
                        tie = false;
                        //exit loop
                        break;
                    }
                }//end inner for 
                //if tie is false
                if(!tie){
                    //exit loop
                    break;
                }
            }//end outer for
        }

        //if tie is true
        if(tie){
            //set game to end
            gameEnd = true;
            //dispay tie game message
            System.out.println("Tie Game!");
        }
    }//end method

    /*
     * checkGameState(): checks if a game win or tie has occured yet
     * @param currPlayer - player who is currently playing
     * @param game - the board that is being played on 
     */
    public void checkGameState(Player currPlayer, Board game){
        //check for win by row
        checkRowWin(currPlayer);
        //check for win by column
        checkColumnWin(currPlayer);
        //check for win by diagonal
        checkDiagonalWin(currPlayer);
        //if game has not been won yet/ended yet
        if(!game.getGameEnd()){
           //check for a tie game
            checkTieGame(); 
        }
    }//end method

    /*
     * setter to set the game state
     * @param gameCondition - Takes in a boolean to see if game has ended or not
     */
    public void setGameEnd(boolean gameCondition){
        gameEnd = gameCondition;
    }
    /*
     * getter to get the game state
     * @return a boolean that tells us if the game has ended or not
     */
    public boolean getGameEnd(){
        return gameEnd;
    }
    /*
     * getter to get the board 
     * @return the array that contains the board position
     */
    public int[][] getRows(){
        return rows;
    }
    /* 
     * setter to set the board positions
     * @param twoDArr - Takes in a 2d array that will be the base of our board
    */
    public void setRows(int[][] twoDArr){
        rows = twoDArr;
    }

}
