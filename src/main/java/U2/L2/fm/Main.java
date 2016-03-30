package U2.L2.fm;

import U2.L2.fm.controller.LoginWindowController;
import U2.L2.fm.model.DBService;
import U2.L2.fm.model.FinancialManagerWithHibernate;
import U2.L2.fm.model.datasets.Account;
import U2.L2.fm.model.datasets.Category;
import U2.L2.fm.model.datasets.Record;
import U2.L2.fm.model.datasets.User;
import U2.L2.fm.model.interfaces.GUI;
import U2.L2.fm.view.LoginWindow;

import java.util.List;
import java.util.Set;

/**
 * Created by Ксения on 17.03.2016.
 *
 */
public class Main {

    public static void main(String[] args) {
        GUI controller = new LoginWindowController(new FinancialManagerWithHibernate(new DBService()));
//        GUI controller = new LoginWindowController(new FinancialManager(DBHelper.getInstance()));
//        GUI controller = new ConsoleController(new FinancialManagerWithHibernate(new DBService()));
////        GUI controller = new ConsoleController(new FinancialManager(DBHelper.getInstance()));
        LoginWindow view = new LoginWindow(controller);
//        //AccountForm view = new AccountForm(controller);
//        ConsoleView view = new ConsoleView(controller);
        view.start();

//        DBService dbService = new DBService();
//        Category category = new Category();
//        category.setNameCategory("Телефон, Интернет");
//        dbService.addCategory(category);
//
//        List<Category> list = dbService.getCategories();
//
//        for (Category c : list) {
//            System.out.println(c.getCategoryId() + ": " + c.getNameCategory());
//        }
//
//        User user = new User("Bob", "bob");
//        dbService.addUser(user);
//
//        Account account = new Account("new account", 1400);
//
//        dbService.addAccount(user, account);
//
//        Record record = new Record();
//        record.setAmount(-200);
//        record.setCategory(category);
//        record.setRecordName("За телефон");
//        dbService.addRecord(account, record);
//        record = new Record();
//        record.setAmount(-20);
//        record.setCategory(category);
//        record.setRecordName("за интернет");
//        dbService.addRecord(account, record);
//
//        System.out.println("LIST OF CATEGORIES");
//        System.out.println("-------------------");
//        list = dbService.getCategories();
//        for (Category c : list) {
//            System.out.println(c.getCategoryId() + ": " + c.getNameCategory() + " number of records: " +c.getRecords().size());
//        }
//
//        Set<Record> recordSet = dbService.getRecords(account);
//
//        for (Record r : recordSet) {
//            System.out.println(r.getRecordName());
//        }



    }
    

}
