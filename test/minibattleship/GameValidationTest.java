package minibattleship;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author rhian
 */
public class GameValidationTest {
    
    public GameValidationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of CheckValidMove method, of class GameValidation - CHECKS FOR VALID CO-ORDINATIONS
     */
    @Test
    public void TestCheckValidMove() {
        System.out.println("CheckValidMove");
        
        String co_ord = "A5";
        
        GameValidation instance = new GameValidation();
        
        boolean expResult = true;
        
        boolean result = instance.CheckValidMove(co_ord);
                      
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }
    
    /**
     * Test of CheckValidMove method, of class GameValidation - CHECKS FOR CO-ORDINATIONS WITH INVALID COLUMN
     */
    @Test
    public void TestCheckInvalidColumnMove() {
        System.out.println("CheckValidMove");
        
        String co_ord = "M5";
        
        GameValidation instance = new GameValidation();
        
        boolean expResult = false;
        
        boolean result = instance.CheckValidMove(co_ord);
                      
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }
    
    /**
     * Test of CheckValidMove method, of class GameValidation - CHECKS FOR CO-ORDINATES WITH INVALID ROW
     */
    @Test
    public void TestCheckInValidRowMove() {
        System.out.println("CheckValidMove");
        
        String co_ord = "A11";
        
        GameValidation instance = new GameValidation();
        
        boolean expResult = false;
        
        boolean result = instance.CheckValidMove(co_ord);
                      
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }

    /**
     * Test of ConvertColumn method, of class GameValidation - CHECKS FOR CORRECT COLUMN CONVERSION, ALPHABET TO INTEGER
     */
    @Test
    public void TestConvertColumn() {
        System.out.println("ConvertColumn");
        
        String col = "A";
        
        GameValidation instance = new GameValidation();
        
        String expResult = "1";
        
        String result = instance.ConvertColumn(col);
        
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }

    /**
     * Test of MakeMove method, of class GameValidation - CHECKS FOR VALID MOVE THAT MATCHES FLAGSHIP CO-ORDINATES
     */
    @Test
    public void TestMakeValidHitMove() {
        System.out.println("Make Valid Hit Move");
        
        String co_ord = "B2";
        
        GameValidation instance = new GameValidation();
        
        instance.flagShips[0] = "57";   //G5  
        instance.flagShips[1] = "810";  //J8 
        instance.flagShips[2] = "22";   //B2
        
        String expResult = "Hit! Perfect, you got a flagship!";
        
        String result = instance.MakeMove(co_ord);
        
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }
    
    /**
     * Test of MakeMove method, of class GameValidation - CHECKS FOR INVALID MOVE 
     */
    @Test
    public void TestMakeInValidMove() {
        System.out.println("Make InValid Move");
        
        String co_ord = "L2";
        
        GameValidation instance = new GameValidation();
        
        instance.flagShips[0] = "57";   //G5  
        instance.flagShips[1] = "810";  //J8 
        instance.flagShips[2] = "22";   //B2
        
        String expResult = "Sorry, that was an invalid move! Try again!";
        
        String result = instance.MakeMove(co_ord);
        
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }
    
    /**
     * Test of MakeMove method, of class GameValidation - CHECKS FOR VALID MOVE THAT DOESN'T MATCH FLAGSHIPS
     */
    @Test
    public void TestMakeValidMissMove() {
        System.out.println("Make Valid Miss Move");
        
        String co_ord = "L2";
        
        GameValidation instance = new GameValidation();
        
        instance.flagShips[0] = "57";   //G5  
        instance.flagShips[1] = "810";  //J8 
        instance.flagShips[2] = "22";   //B2
        
        String expResult = "Sorry, that was an invalid move! Try again!";
        
        String result = instance.MakeMove(co_ord);
        
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }
    
    /**
     * Test of MakeMove method, of class GameValidation - CHECKS FOR REPEATED MOVE
     */
    @Test
    public void TestMakeRepeatedMove() {
        System.out.println("Make Valid Miss Move");
        
        String co_ord = "B5";
        
        GameValidation instance = new GameValidation();
        
        instance.flagShips[0] = "57";   //G5  
        instance.flagShips[1] = "810";  //J8 
        instance.flagShips[2] = "22";   //B2
        
        instance.movesList.add("B5");
        
        String expResult = "Sorry, you've already made that move! Try again!";
        
        String result = instance.MakeMove(co_ord);
        
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }
    
    /**
     * Test of CheckLevel method, of class GameValidation - CHECKS FOR VALID LEVEL SETTING
     */
    @Test
    public void TestCheckValidLevel() {
        System.out.println("Check Valid Level");
        
        String answer = "easy";
        
        GameValidation instance = new GameValidation();
        
        boolean expResult = true;
        
        boolean result = instance.CheckLevel(answer);
        
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }
    
    /**
     * Test of CheckLevel method, of class GameValidation - CHECKS FOR INVALID SETTING
     */
    @Test
    public void TestCheckInvalidLevel() {
        System.out.println("Check Invalid Level");
        
        String answer = "expert";
        
        GameValidation instance = new GameValidation();
        
        boolean expResult = false;
        
        boolean result = instance.CheckLevel(answer);
        
        assertEquals(expResult, result);
        
        System.out.println(" ");
    }
    
}
