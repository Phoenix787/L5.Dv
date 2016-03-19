package U2.L2.fm.model.datasets;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.Assert.*;

/**
 * Created by Сергеева on 18.03.2016.
 *
 */
public class UserTest {
    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User("User", "123456");

    }

    @Test
    public void getName() throws Exception {
        assertEquals("User", user.getName());
    }

    @Test
    public void setName() throws Exception {
        user.setName("Alisa");
        assertEquals("Alisa", user.getName());
    }

    @Test
    public void getPassword() throws Exception {

        assertEquals("123456", user.getPassword());
    }

    @Test
    public void setPassword() throws Exception {
        user.setPassword("789");
        assertEquals("789", user.getPassword());
    }

    @Test
    public void getAccounts() throws Exception {
        user.setAccounts(new HashSet<>(Arrays.asList(new Account("description", 45.8),
                new Account("general account", 458.45))));
        assertNotNull(user.getAccounts());
    }

    @Test
    public void setAccounts() throws Exception {
        user.setAccounts(new HashSet<>(Arrays.asList(new Account("description", 45.8),
                new Account("general account", 458.45))));
        assertNotNull(user.getAccounts());
    }
}