package U2.L1.L2.ex2;

import U2.L1.L2.ex2.controller.ConsoleController;
import U2.L1.L2.ex2.controller.GUI;
import U2.L1.L2.ex2.datasets.User;
import U2.L1.L2.ex2.view.ConsoleView;

import java.util.Scanner;

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
