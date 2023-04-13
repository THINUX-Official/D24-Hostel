package lk.ijse.d24.hostel.util;

/*
    @author THINUX
    @created 05-Apr-23 - 09:36 
*/

import animatefx.animation.FadeIn;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Navigation {
    private static AnchorPane pane;
    public static void navigate(Routes route, AnchorPane pane) throws IOException {

        Navigation.pane = pane;
        //animation
        new FadeIn(pane).setSpeed(2).play();

        Navigation.pane.getChildren().clear();
        Stage window = (Stage) Navigation.pane.getScene().getWindow();

        switch (route) {
            case LOGIN:
                window.setTitle("Login Form");
                initUI("LoginForm.fxml");
                break;
            case DASHBOARD:
                window.setTitle("Dashboard Form");
                initUI("MenuForm.fxml");
                break;
            case ROOM:
                window.setTitle("Room Form");
                initUI("RoomForm.fxml");
                break;
            case RESERVATION:
                window.setTitle("Reservation Form");
                initUI("ReservationForm.fxml");
                break;
            case STUDENT:
                window.setTitle("Student Form");
                initUI("StudentForm.fxml");
                break;
            case USER:
                window.setTitle("User Form");
                initUI("UserForm.fxml");
                break;
            default:
                new Alert(Alert.AlertType.ERROR, "Not suitable UI found!").show();
        }
    }
    private static void initUI(String location) throws IOException {
        Navigation.pane.getChildren().add(FXMLLoader.load(Navigation.class
                .getResource("/lk/ijse/d24/hostel/view/" + location)));
    }
}
