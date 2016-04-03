package U2.L2.fm.view;
/**
 * Created by Ксения on 02.04.2016.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        String fxmlFile = "/fxml/login.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        primaryStage.setTitle("Вход в систему");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
