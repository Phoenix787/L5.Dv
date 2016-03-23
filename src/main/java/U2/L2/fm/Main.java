package U2.L2.fm;

import U2.L2.fm.controller.DBHelper;
import U2.L2.fm.controller.GUI;
import U2.L2.fm.controller.LoginWindowController;
import U2.L2.fm.model.FinancialManager;
import U2.L2.fm.view.LoginWindow;

/**
 * Created by Ксения on 17.03.2016.
 *
 */
public class Main {

    public static void main(String[] args) {
        GUI controller = new LoginWindowController(new FinancialManager(DBHelper.getInstance()));
        LoginWindow view = new LoginWindow(controller);
        view.start();

    }
    

}
