
package minibattleship;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author rhian
 */
public class GameValidation {
    
    String[][] gameBoard = new String[10][10];                                  // Matrix to print and save game board
    String[] flagShips = new String [3];                                        // Co-ordinates of flag ships
    String[] columns = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};      // Columns alphabets
    int hits = 0;                                                               // Number of player hits
    int misses = 0;                                                             // Number of player misses
    ArrayList<String> movesList = new ArrayList<String>();                      // Array to save all player's moves
        
    /*--------------------------------------------- PART 1 - QUESTION 2 --------------------------------------------*/
    
    /* -------------------------------------------- CONSTRUCTORS ---------------------------------------------------*/
    
    GameValidation()
    {
        
    }
    
    /* --------------------------------------------------------------------------------------------------------------*/
    
    /* ---------------------- FUNCTION USED TO ASSIGN RANDOM CO-ORDINATES TO FLAG SHIPS -----------------------------*/
    
    public void createBoard()
    {
        int max = 10;
        int min = 1;
        int range = max - min + 1;
        
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                gameBoard[i][j] = "*";
            }
        }
        
        for (int i = 0; i < 3; i++)
        {
            int row = (int)(Math.random() * range) + min;
            int col = (int)(Math.random() * range) + min;
            
            String r = Integer.toString(row);
            String c = Integer.toString(col);
            String co_ord = r + c;
            
            flagShips[i] = co_ord;          
            
        }
    }
    
    /* --------------------------------------------------------------------------------------------------------------*/
    
    /* ------------------------------ FUNCTION USED TO PRINT GAME BOARD MATRIX --------------------------------------*/
    
    public void printBoard()
    {
        System.out.println("----------------------------");
        System.out.print("|    | ");
        for (int i = 0; i < 10; i++)
        {
            System.out.print(columns[i] + " ");
        }
        System.out.println("|");
        System.out.println("----------------------------");
        
        for (int k = 0; k < 10; k++)
        {
            if(k == 9)
            {
                System.out.print("| " + Integer.toString(k+1) + " | ");
            }
            else
            {
                System.out.print("| " + Integer.toString(k+1) + "  | ");
            }
            
            for (int l = 0; l < 10; l++)
            {
                System.out.print(gameBoard[k][l] + " ");
            }
            System.out.println("|");
        }
        
        System.out.println("----------------------------");
        
    }
    
    /* --------------------------------------------------------------------------------------------------------------*/
    
    /* ------------------------- FUNCTION USED TO CHECK COLUMNS IN A-Z AND ROWS IN 1-10 -----------------------------*/
    
    public boolean CheckValidMove(String co_ord)
    {
        boolean valid = true;
        String col = "ABCDEFGHIJ";
        String row = "123456789";
        
        if (co_ord.length() == 2)
        {
            if (col.contains(Character.toString(co_ord.charAt(0))))
            {
                valid = true;
            }
            else
            {
                return false;
            }
            
            if (row.contains(Character.toString(co_ord.charAt(1))))
            {
                valid = true;
            }
            else
            {
                return false;
            }
        }
        else if (co_ord.length() == 3)
        {
            if (col.contains(Character.toString(co_ord.charAt(0))))
            {
                valid = true;
            }
            else
            {
                return false;
            }
            
            if ("10".equals(co_ord.substring(1, 3)))
            {
            } else {
                return false;
            }
        }
        
        return valid;
    }
    
    /* --------------------------------------------------------------------------------------------------------------*/
    
    /* -------------------------- FUNCTION USED TO CONVERT COLUMN ALPHABET TO INTEGER -------------------------------*/
    
    public String ConvertColumn(String col)
    {
        for(int i = 0; i < 10; i++)
        {
            if(columns[i].equals(col))
            {
                return Integer.toString(i+1);
            }
        }
        
        return "";
    }
    
    /* --------------------------------------------------------------------------------------------------------------*/
    
    /* ------------------------ FUNCTION USED TO CHECK USER'S INPUT AGAINST MATRIX VALUES ---------------------------*/
    
    public String MakeMove(String co_ord)   
    {
        String output = "";       
        boolean newMove = true;
        boolean hitShip = false;
        
        if(CheckValidMove(co_ord) == false) 
        {
            output = "Sorry, that was an invalid move! Try again!";
        }
        else
        {
            for (int i = 0; i < movesList.size(); i++) 
            {
                if(movesList.get(i).equals(co_ord))
                {
                    output = "Sorry, you've already made that move! Try again!";
                    newMove = false;
                    break;
                }
            }
            
            if (newMove == true)
            {
                String col = ConvertColumn(co_ord.substring(0,1));
                
                
                String finalCoord = co_ord.substring(1) + col;
                               
                
                for (int i = 0; i < 3; i++)
                {
                    if (finalCoord.equals(flagShips[i]))
                    {
                        hits++;

                        output = "Hit! Perfect, you got a flagship!";

                        gameBoard[Integer.parseInt(co_ord.substring(1))-1][Integer.parseInt(col)-1] = "X";
                        
                        hitShip = true;

                        break;
                    }

                }               
                
                if(hitShip == false)
                {
                    output = "Miss! Sorry, you missed it by a mile...";

                    misses++;

                    gameBoard[Integer.parseInt(co_ord.substring(1))-1][Integer.parseInt(col)-1] = "O";
                }                

                movesList.add(co_ord);
            }
        }
        
        return output;               
        
    }
    
    /* --------------------------------------------------------------------------------------------------------------*/
    
    /* ---------------------------- FUNCTION USED TO RETRIEVE PLAYER'S DETAILS --------------------------------------*/
    
    public String StartGame()
    {
        boolean validLevel = false;
        String output = "";
        String name = "";
        String level = "";
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Welcome to Mini Battlshipe, where you have limited moves to sink 3 flagships!");
        System.out.println(" ");
        System.out.print("What is your name, cadet? ");
        name = sc.next();
        System.out.println(" ");
        
        System.out.print("What difficulty would you like to play at, cadet? (Choose from: Easy, Medium, Hard) ");
        String answer = sc.next();
        validLevel = CheckLevel(answer);
        
        while(!validLevel)
        {
            System.out.print("Sorry, that was an invalid answer. Try again >> ");
            answer = sc.next();
            validLevel = CheckLevel(answer);
        }
        
        level = answer;
        
        output = name + "," + level;
        
        return output;
    }
    
    /* --------------------------------------------------------------------------------------------------------------*/
    
    /* ------------------------------ FUNCTION USED TO CHECK FOR A VALID LEVEL --------------------------------------*/
    
    public boolean CheckLevel(String answer)
    {
        String[] levels = {"easy", "medium", "hard"};
        
        for (int i = 0; i < 3; i++)
        {
            if(answer.toLowerCase().equals(levels[i]))
            {
                return true;
            }
        }
        
        
        
        return false;
    }
    
    /* --------------------------------------------------------------------------------------------------------------*/
}
