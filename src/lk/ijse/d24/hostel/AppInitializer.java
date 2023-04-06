package lk.ijse.d24.hostel;

/*
    @author THINUX
    @created 01-Apr-23 - 19:29 
*/

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppInitializer extends Application {
    public static void main(String[] args) {
        launch(args);

//        System.out.println("Hi");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root= FXMLLoader.load(getClass().getResource("view/LoginForm.fxml"));
        Scene mainScene=new Scene(root);
        primaryStage.setScene(mainScene);
        primaryStage.setTitle("D24 Hostel");
        primaryStage.centerOnScreen();
        primaryStage.show();
    }
}
