package ex2.Model;

import ex2.Controller.GameController;

/**
 * Created by Сергеева on 10.03.2016.
 *
 */
public class MainGame {
//    public Field field = new Field();
//    public Computer computer = new Computer();
//    public User user = new User();
    private GameController gameController;

    public MainGame(GameController gameController) {
        this.gameController = gameController;
    }

    public void start(){
        gameController.getField().show();
        for (int i = 0; i < 10; i++) {
            boolean res;
            do {
               res  = gameController.getField().doShoot(gameController.getComputer().getShoot(), gameController.getComputer().type);
            } while(!res);
                gameController.getField().show();
            if(gameController.getField().checkIsWin(gameController.getComputer().type)){
                System.out.println("Computer is WIN!");
                break;
            }

            //checkWin
            do {
                res = gameController.getField().doShoot(gameController.getUser().getShoot(), gameController.getUser().type);
            } while(!res);

            gameController.getField().show();
            //checkWin
            if (gameController.getField().checkIsWin(gameController.getUser().type)){
                System.out.println("User is WIN!");
                break;
            }

        }

    }
}
