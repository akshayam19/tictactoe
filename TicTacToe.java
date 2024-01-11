package play;
import java.util.Scanner;

public class TicTacToe {
    
    // Runs the methods to create, print, play, win, and replay the game 
    public static void main(String[] args) {
        // Initializing a scanner for integer input
        Scanner in = new Scanner(System.in);
        // Initializing a scanner for String input
        Scanner user = new Scanner(System.in);
        
        
        boolean continuePlaying = true;
        //loop for playing again until continuePlaying is false
        while(continuePlaying) {
            
            // Prompting the user for what size game board
            System.out.print("Enter number of rows and columns for the board: ");
            System.out.println();
            int lines;

            do {
                if (in.hasNextInt()) {
                    lines = in.nextInt();

                    if (lines < 1) {
                        System.out.println("Invalid input. Please enter a value greater than or equal to 1.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    in.next(); // Consume the invalid input
                    lines = 0; // Set lines to 0 to continue the loop
                }
            } while (lines < 1);

            // Initializing a 2D array with the size the user entered
            String[][] board = new String[lines][lines];
            
            // Creates a blank game board
            createBoard(board);
            // Prints game board
            displayBoard(board);
            
            // If someone wins or ties the game after playing
            if(play(board) == false) {
                // Asks user to for another play
                System.out.println("Do you want to play again?");
                
                // Valid class will make sure the userInput is valid
                // returns true for Yes and false for No
                if(SafeInput.getYNConfirm(user)) {
                    // If user replies yes then creates new board and plays again
                    continuePlaying = true;
                } else {
                // If user replies no then game ends
                    System.out.println("Thanks for playing!");
                    continuePlaying = false;
                }
            }
        }
        // Closing scanners
        in.close();
        user.close();
        
}
    
    // Creates a blank game board
    public static void createBoard(String[][] board) {
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board.length; j++) {
                board[i][j] = " ";  
            }
        }
    }

    // Prints game board
    public static void displayBoard(String[][] board) {
        for (int i=0; i< board.length; i++) {
            for(int j=0; j< board.length; j++) {
                if (j == board[i].length - 1) {
                    System.out.print("  " + board[i][j] + "  ");
                } else {
                    System.out.print("    " + board[i][j] + "  | ");
                }
            }
            if(i<board.length-1) {
                System.out.println();
            for(int k=0;k<board.length;k++) {
                System.out.print(" ------ ");
            }
                System.out.println();
            }
        }
        System.out.println();
    }
    
    // Plays game until a player wins
    public static boolean play(String[][] board) {
        // Initializing a Scanner
        Scanner in = new Scanner (System.in);
        
        // turn variable will keep track of who's playing 
        // Odd number means player 1 and even number means player 2
        int turn = 1;
        // Win variable will allow the users to keep playing until someone wins (win = true)
        boolean win = false;
        
        
        while(win == false) {
            // Prompting Player 1 to make a move (need to enter row and column)
            // When the turn is an odd number, it is Player 1's turn
            if (turn % 2 != 0) {
                System.out.println("Player 1, enter the row to place X (an integer):");

                int row1;
                while (true) {
                    if (in.hasNextInt()) {
                        row1 = in.nextInt() - 1;
                        if (row1 >= 0 && row1 < board.length) {
                            break; // Valid input, exit the loop
                        } else {
                            System.out.println("Invalid input. Enter a row between 1 and " + board.length + ":");
                        }
                    } else {
                        System.out.println("Invalid input. Enter a valid integer for the row:");
                        in.next(); // Consume the invalid input
                    }
                }

                // Similar loop for getting the column input from Player 1
                System.out.println("Player 1, enter the column to place X (an integer):");

                int col1;
                while (true) {
                    if (in.hasNextInt()) {
                        col1 = in.nextInt() - 1;
                        if (col1 >= 0 && col1 < board.length) {
                            break; // Valid input, exit the loop
                        } else {
                            System.out.println("Invalid input. Enter a column between 1 and " + board.length + ":");
                        }
                    } else {
                        System.out.println("Invalid input. Enter a valid integer for the column:");
                        in.next(); // Consume the invalid input
                    }
                }
            
            
            
        // Checks if there is a mark already in given spot
        if(board[row1][col1] != "X" && board[row1][col1] != "O") {
            board[row1][col1] = "X";
               turn++;
        } else {
            System.out.println("Space occupied. Enter another row and column.");
        }
            
            // Prints game board
            displayBoard(board);
            
            // Checks for wins
            if(rows(board)||columns(board)||diagonal1(board)||diagonal2(board)) {
                win = true;
                return false;
            // Checks for tie which means the board is filled
            } else if (turn == board.length*board.length + 1) {
                System.out.println("It's a tie!");
                win = true;
                return false;
            }   
        }
        
        
            // Prompting Player 2 to make a move (need to enter row and column)
            // When the turn is an even number, it is Player 2's turn
            if (turn % 2 == 0) {
                System.out.println("Player 2, enter the row to place O (an integer):");

                int row2;
                while (true) {
                    if (in.hasNextInt()) {
                        row2 = in.nextInt() - 1;
                        if (row2 >= 0 && row2 < board.length) {
                            break; // Valid input, exit the loop
                        } else {
                            System.out.println("Invalid input. Enter a row between 1 and " + board.length + ":");
                        }
                    } else {
                        System.out.println("Invalid input. Enter a valid integer for the row:");
                        in.next(); // Consume the invalid input
                    }
                }

                // Similar loop for getting the column input from Player 2
                System.out.println("Player 2, enter the column to place O (an integer):");

                int col2;
                while (true) {
                    if (in.hasNextInt()) {
                        col2 = in.nextInt() - 1;
                        if (col2 >= 0 && col2 < board.length) {
                            break; // Valid input, exit the loop
                        } else {
                            System.out.println("Invalid input. Enter a column between 1 and " + board.length + ":");
                        }
                    } else {
                        System.out.println("Invalid input. Enter a valid integer for the column:");
                        in.next(); // Consume the invalid input
                    }
                }
            
        // Checks if there is a mark already in given spot
            if(board[row2][col2] != "X" && board[row2][col2] != "O") {
                board[row2][col2] = "O";
                turn++;
            } else {
                // If there is a mark already in given spot Player 1 gets to retry move
                System.out.println("Space occupied. Enter another row and column.");
            }
            
            // Prints game board
            displayBoard(board);
            
            // Checks for wins
            if(rows(board)||columns(board)||diagonal1(board)||diagonal2(board)) {
                win = true;
                return false;
            }
        }  
     }
        return true;    
    }
        
    // Checks for a win in any of the rows
    public static boolean rows(String[][] board){
        
        for(int i=0; i<board.length; i++) { // each row
            int countX = 0;
            int countO = 0;
            for(int j=0; j<board.length; j++) { // each column in the row
                if(board[i][j] == "X") {
                    countX++;
                } else if(board[i][j] == "O") {
                    countO++;
                }
            }
            // if the whole row has an X, player 1 wins
            if(countX == board.length) {
                System.out.println("Player 1 won!");
                return true;
            // if the whole row has an O, player 2 wins
            } else if (countO == board.length) {
                System.out.println("Player 2 won!");
                return true;
            }
        }
        // else no one wins
        return false;
    }
    
    // Checks for a win in any of the columns
    public static boolean columns(String[][] board){
        
        for(int i=0; i<board.length; i++) { // each column
            int countX = 0;
            int countO = 0;
            for(int j=0; j<board.length; j++) { // each row in the column
                if(board[j][i] == "X") {
                    countX++;
                } else if(board[j][i] == "O") {
                    countO++;
                }
            }
            // if the whole row has an X, player 1 wins
            if(countX == board.length) {
                System.out.println("Player 1 won!");
                return true;
            // if the whole row has an O, player 2 wins
            } else if (countO == board.length) {
                System.out.println("Player 2 won!");
                return true;
            }
        }
        // else no one wins
        return false;
    }
    
    // Checks for a win in the diagonal from the top left to bottom right
    public static boolean diagonal1(String[][] board) {
        int countX = 0;
        int countO = 0;
        for(int i=0; i<board.length; i++) {
            if(board[i][i] == "X") {
                countX++;
            } else if(board[i][i] == "O") {
                countO++;
            }
        }
        // if the whole row has an X, player 1 wins
        if(countX == board.length) {
            System.out.println("Player 1 won!");
            return true;
        // if the whole row has an O, player 2 wins
        } else if (countO == board.length) {
            System.out.println("Player 2 won!");
            return true;
        }
        // else no one wins
        return false;
    }
    
    // Checks for a win in the diagonal from the top right to bottom left   
    public static boolean diagonal2(String [][] board){

        int countX = 0;
        int countO = 0;
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if ((i + j) == (board.length - 1) && board[i][j] == "X") {
                    countX++;
                }
                if ((i + j) == (board.length - 1) && board[i][j] == "O") {
                    countO++;
                }
            }
        }
        // if the whole row has an X, player 1 wins
        if(countX == board.length) {
            System.out.println("Player 1 wins!");
            return true;
        }
        // if the whole row has an O, player 2 wins
        if(countO == board.length) {
                System.out.println("Player 2 wins!");
                return true;
        }
        // else no one wins
        return false;
        
    }
    

}