package U2.L2.fm;

import U2.L2.fm.controller.LoginWindowController;
import U2.L2.fm.model.DBService;
import U2.L2.fm.model.FinancialManagerWithHibernate;
import U2.L2.fm.model.interfaces.GUI;
import U2.L2.fm.view.LoginWindow;

/**
 * Created by Ксения on 17.03.2016.
 *
 */
public class Main {

    public static void main(String[] args) {
        GUI controller = new LoginWindowController(new FinancialManagerWithHibernate(new DBService()));
//        GUI controller = new LoginWindowController(new FinancialManager(DBHelper.getInstance()));
        LoginWindow view = new LoginWindow(controller);
        //AccountForm view = new AccountForm(controller);
        view.start();

    }
    

}
