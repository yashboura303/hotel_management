package sample;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("login1.fxml"));
            primaryStage.setTitle("NOVOTEL HOTEL ");
            primaryStage.setScene(new Scene(root, 500, 475));
            primaryStage.show();
        }
        catch(Exception e )
        {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
