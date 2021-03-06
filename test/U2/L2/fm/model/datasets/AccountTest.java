package U2.L2.fm.model.datasets;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by Сергеева on 18.03.2016.
 */
public class AccountTest {

    private Account account;
    private Record record;

    @Before
    public void setUp(){
        account = new Account("General account", 458.78);
        record = new Record(1L, new Date(), new Category(1L, "Post"), true, 4.8, "buy juice");
    }

    @Test
    public void getId() throws Exception {
        assertEquals(-1, account.getAccountId());

    }

    @Test
    public void setId() throws Exception {
        account.setAccountId(1L);
        assertEquals(1, account.getAccountId());
    }

    @Test
    public void getDescription() throws Exception {
        assertEquals("General account", account.getDescription());
    }

    @Test
    public void setDescription() throws Exception {
        account.setDescription("New account2016");
        assertEquals("New account2016", account.getDescription());

    }

    @Test
    public void getAmount() throws Exception {
        assertEquals(458.78, account.getAmount(), 0.0);
    }

    @Test
    public void setAmount() throws Exception {
        account.setAmount(500.00);
        assertEquals(500.00, account.getAmount(), 0.00);
    }

//    @Test
//    public void getRecords() throws Exception {
//        account.setRecords(Collections.singletonList(record));
//        assertNotNull(account.getRecords());
//
//    }
//
//    @Test
//    public void setRecords() throws Exception {
//        account.setRecords(Collections.singletonList(record));
//        assertNotNull(account.getRecords());
//    }
}