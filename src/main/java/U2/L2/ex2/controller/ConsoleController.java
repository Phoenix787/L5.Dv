package U2.L2.ex2.controller;

import U2.L2.ex2.model.FinancialManager;
import U2.L2.ex2.view.ConsoleView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Ксения on 18.03.2016.
 *
 */
public class ConsoleController implements GUI {
    private final Logger logger = LoggerFactory.getLogger(FinancialManager.class.getName());
    private ConsoleView view;


    public ConsoleController() {
        view = new ConsoleView();
    }

    @Override
    public void show() {
        view.show();
    }

    public String getUserInput(){
        return view.getMessage();
    }

    @Override
    public void sendMessage(String message) {
        view.sendMessage(message);
    }


}
