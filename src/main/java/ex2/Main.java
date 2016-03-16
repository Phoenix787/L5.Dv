package ex2;

import ex2.Controller.GameController;
import ex2.Model.MainGame;
import ex2.View.GameWindow;

/**
 * Created by Сергеева on 10.03.2016.
 *
 */
public class Main {
    public static void main(String[] args) {
//        GameWindowTest gameWindowTest = new GameWindowTest();
//        gameWindowTest.init();

        GameController gameController = new GameController();

        GameWindow gameWindow = new GameWindow(gameController);
        gameWindow.init();

        MainGame game = new MainGame(gameController);
        game.start();

    }
}
