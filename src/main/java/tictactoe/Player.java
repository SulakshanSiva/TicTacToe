package tictactoe;
/**
 * Represent a class for a Player for the Tic Tac Toe game.
 * 2 players will be active in a game of Tic Tac Toe game.
 */
public class Player {
    //declare and initialize variable for player symbol, name and their turn
    private char playerSymbol;
    private String playerName;
    private boolean playerTurn;
    /**
     * Constructor to create a player
     * @param pSymbol - For player symbol which will be "X" or "O"
     * @param pName - For player name
     * @param pTurn - For player turn, to see if its their turn or not
     */
    public Player(char pSymbol, String pName, boolean pTurn){
        //set symbol to player symbol
        playerSymbol = pSymbol;
        //set name to player name
        playerName = pName;
        //set turn to player turn
        playerTurn = pTurn;
    }   
    /*
     * Getter to get player symbol
     * @return the player symbol
     */
    public char getPlayerSymbol(){
        return playerSymbol;
    }
    /*
     * Setter to set player symbol 
     * @param symbol - Player symbo as a char: "X" or "O"
     */
    public void setPlayerSymbol(char symbol){
        playerSymbol = symbol;
    }
    /*
     * Getter to get player name
     * @return the player name
     */
    public String getPlayerName(){
        return playerName;
    }
    /*
     * Setter to set the player name
     * @param pName - Takes in the player name as a string
     */
    public void setPlayerName(String pName){
        playerName = pName;
    }
    /*
     * Getter to get the player turn
     * @return true if it is the players turn, false otherwise
     */
    public boolean getPlayerTurn(){
        return playerTurn;
    }
    /*
     * Setter to set the player turn
     * @param pTurn - Takes in a boolean to see if it is the players turn
     */
    public void setPlayerTurn(boolean pTurn){
        playerTurn = pTurn;
    }


}


