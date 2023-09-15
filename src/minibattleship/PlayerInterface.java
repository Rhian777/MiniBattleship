package minibattleship;

import java.util.Scanner;
import java.util.*;
import java.lang.*;

/**
 *
 * @author rhian
 */
public class PlayerInterface {
    
    GameValidation game = null;     // GameValidation object
    String level = " easy";         // Game level
    String name = " ";              // Player name
    int moves = 15;                 // Default moves at easy level
    
    /*--------------------------------------------- PART 1 - QUESTION 2 --------------------------------------------*/
    
    /* -------------------------------------------- CONSTRUCTORS ---------------------------------------------------*/
    
    PlayerInterface()
    {
        game = new GameValidation();
    }
    
    PlayerInterface(String playerName, String playerLevel, GameValidation newGame)
    {
        name = playerName;
        level = playerLevel;
        game = newGame;
        
        if (level.equals("easy"))
        {
            moves = 15;
        }
        
        if (level.equals("medium"))
        {
            moves = 10;
        }
        
        if (level.equals("hard"))
        {
            moves = 5;
        }
    }    
        
    /* --------------------------------------------------------------------------------------------------------------*/
    
    /* -------------------------- FUNCTION USED TO REPEATED PRINT MATRIX AND GAME STATS -----------------------------*/
    
    public void PlayGame()
    {        
        boolean winner = false;
        
        String details = game.StartGame();
        
        int pos = details.indexOf(",");
        
        name = details.substring(0, pos);
        
        level = details.substring(pos+1, details.length());
        
        Scanner sc = new Scanner(System.in);
        
        game.createBoard();
        System.out.println(" ");
        System.out.println("Get ready, " + name + "!");
        System.out.println(" ");
        System.out.println("You have seleted to play at " + level + " difficulty");
        System.out.println(" ");
        System.out.println("This means you have to sink the 3 flag ships in " + Integer.toString(moves) + " moves or less");       
        System.out.println(" "); 
                
        while(moves>0)
        {
            System.out.println("If you want to quit at any point, just enter (Q)");
            System.out.println("Player: " + name + " | Moves Left: " + Integer.toString(moves) + " | Hits: " + Integer.toString(game.hits) + " | Misses: " + Integer.toString(game.misses));
            System.out.println(" ");            
            game.printBoard();
            System.out.println(" ");
            
            System.out.print("Enter the co-ordinates you'd like to hit (E.g. - A9) >> ");
            String answer = sc.next();
            
            if(answer.toUpperCase().equals("Q"))
            {
                System.exit(0);
            }
            else
            {
               
                String output = game.MakeMove(answer.toUpperCase());

                System.out.println(" ");
                System.out.println(output);
                System.out.println(" ");

                if ((output.equals("Sorry, that was an invalid move! Try again!")) || (output.equals("Sorry, you've already made that move! Try again!")))
                {                    
                }
                else
                {
                    moves = moves - 1;            
                }

                if(game.hits == 3)
                {
                    winner = true;
                    break;
                }
            }
                        
        }
        
        if(winner)
        {
            System.out.println("Congrats! You win!");
        }
        else
        {
            System.out.println("Nice try, but you didn't sink all the ships...You Lose!");
        }
        
    }
    
    /* --------------------------------------------------------------------------------------------------------------*/
    
    
}
