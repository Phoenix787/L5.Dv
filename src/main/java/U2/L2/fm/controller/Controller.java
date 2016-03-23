package U2.L2.fm.controller;

import U2.L2.fm.model.FinancialManager;
import U2.L2.fm.view.LoginWindow;

/**
 * Created by Ксения on 23.03.2016.
 */
public class Controller implements GUI {
    //подключить модель финансового менеджера
    //сюда можно попробовать подключить контроллер
    private FinancialManager fm;
    private LoginWindow frame;

    public Controller(FinancialManager fm, LoginWindow frame) {
        this.fm = fm;
        this.frame = frame;
    }



    public boolean authenticate(String name, String password) {
        /* выборка из базы данных */
        return fm.signIn(name, password);
    }

    @Override
    public boolean register(String username, String password) {
        return false;
    }
}
