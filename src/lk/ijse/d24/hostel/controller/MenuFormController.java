package lk.ijse.d24.hostel.controller;

/*
    @author THINUX
    @created 06-Apr-23 - 10:22 
*/

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.d24.hostel.util.Navigation;
import lk.ijse.d24.hostel.util.Routes;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class MenuFormController {

    public AnchorPane pane;
    public AnchorPane ancPane;
    public AnchorPane loginPane;
    public Label lblProductCount;
    public Label lblOrderCount;
    public AnchorPane pane1;
    public Label lblDate;
    public Label lblTime;
    public Label lblServiceCount;
    public Label lblCustomerCount;

    public void initialize() throws IOException, SQLException, ClassNotFoundException {
        customerCount();
        orderCount();
        serviceCount();
        productCount();

        loadOrderDate();
        loadOrderTime();
    }

    private void loadOrderDate() {
        lblDate.setText(String.valueOf(LocalDate.now()));
    }

    private void loadOrderTime() {
        lblTime.setText(String.valueOf(LocalTime.now()));
    }

    private void customerCount() throws SQLException, ClassNotFoundException {
//        lblCustomerCount.setText(String.valueOf(CustomerModel.customerCount()));
    }

    private void orderCount() throws SQLException, ClassNotFoundException {
//        lblOrderCount.setText(String.valueOf(OrderDetailModel.orderCount()));
    }

    private void serviceCount() throws SQLException, ClassNotFoundException {
//        lblServiceCount.setText(String.valueOf(ServiceModel.serviceCount()));
    }

    private void productCount() throws SQLException, ClassNotFoundException {
//        lblProductCount.setText(String.valueOf(ItemModel.productCount()));
    }

    public void logoutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/LoginForm.fxml")))));

//        Navigation.navigate(Routes.LOGIN, pane);
    }

    public void dashboardOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) pane.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("../view/MenuForm.fxml")))));

//        Navigation.navigate(Routes.ADMIN_MENU, pane);
    }

    public void roomOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.ROOM, pane);
    }

    public void reservationOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.RESERVATION, pane);
    }


    public void studentOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.STUDENT, pane);
    }
}
