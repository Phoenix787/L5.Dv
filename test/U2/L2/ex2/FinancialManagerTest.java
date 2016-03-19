package U2.L2.ex2;

import U2.L2.ex2.controller.DBHelper;
import U2.L2.ex2.controller.GUI;
import U2.L2.ex2.model.FinancialManager;
import org.junit.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 * Created by Ксения on 18.03.2016.
 *
 */
public class FinancialManagerTest {

    private  static FinancialManager fm;
    private static DBHelper dbHelper;
    private static GUI controller = mock(GUI.class);

    @BeforeClass
    public static void setUp() throws Exception {
        dbHelper = DBHelper.getInstance();
        fm = new FinancialManager(dbHelper, controller);

    }

    @Test
    public void signIn() throws Exception {

        assertTrue(fm.signIn("Alisa", "123"));

    }

    @Test
    public void signUp() throws Exception {
        assertTrue(fm.signUp("Tom", "789"));
    }

    @AfterClass
    public static void tearDown(){
        dbHelper.removeUser("Tom");
        dbHelper.closeConnection();
    }
}