package play;
import java.util.Scanner;

public class SafeInput {
    // Checks if row or column entry is valid
    public static int validNum(Scanner userInput, int high)
    {
        int userMove;
        boolean invalidInput = true;
        
        do
        {
            // userMove variable holds the number user typed
            userMove = userInput.nextInt();
            // if number is between the range then it's not invalid
            if ((userMove >= 1) && (userMove <= high)){
                invalidInput = false;
            // if invalid then asks to type a new number
            } else {
                System.out.println("You entered: " + userMove + ".");
                System.out.println("Try again with an integer between 1 "  + " and " + high + ".");
            }
        } while (invalidInput); // stops until valid input is entered
        userInput.nextLine();
        // returns the final valid number
        return userMove; 
    }
    
    // Checks if Yes or No is valid 
    public static boolean getYNConfirm(Scanner userInput)
    {
        boolean invalidInput = true;
        boolean returnBoolean = false;
        
        do
        {   
            // yesOrNo variable holds the reply user types
            String yesOrNo = userInput.nextLine();
            // if user entered Yes or yes correctly, entry is not invalid and returns true
            if (yesOrNo.equalsIgnoreCase("Yes") || yesOrNo.equalsIgnoreCase("yes"))
            {
                returnBoolean = true;
                invalidInput = false;
            // if user entered No or no correctly, entry is not invalid and returns false
            } else if (yesOrNo.equalsIgnoreCase("No") || yesOrNo.equalsIgnoreCase("no")) {
                returnBoolean = false;
                invalidInput = false;
            // if user entered invalid entry then asks to type a new reply
            } else {
                System.out.println("You entered: " + yesOrNo + ".");
                System.out.println("Try again with a Yes or No.");
            }
        } while(invalidInput); // stops until valid input is entered
        return returnBoolean; // returns true for yes and false for no
    }
}