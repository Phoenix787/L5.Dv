package U2.L2.fm;

import U2.L2.fm.controller.ConsoleController;
import U2.L2.fm.controller.DBHelper;
import U2.L2.fm.controller.GUI;
import U2.L2.fm.model.FinancialManager;

/**
 * Created by Ксения on 17.03.2016.
 *
 */
public class Main {

    public static void main(String[] args) {
        GUI controller = new ConsoleController();
        new FinancialManager(DBHelper.getInstance(), controller).start();
    }
    

}
