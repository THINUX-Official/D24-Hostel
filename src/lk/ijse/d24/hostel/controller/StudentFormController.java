package lk.ijse.d24.hostel.controller;

/*
    @author THINUX
    @created 06-Apr-23 - 12:37 
*/

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.d24.hostel.model.StudentDTO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class StudentFormController {
//    public javafx.scene.control.Label lblSID;
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField txtSID;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private TableView<StudentDTO> tblStudent;

    /*@FXML
    private TableColumn<StudentDTO, String> colSID;

    @FXML
    private TableColumn<StudentDTO, String> colName;

    @FXML
    private TableColumn<StudentDTO, String> colAddress;

    @FXML
    private TableColumn<StudentDTO, String> colContact;

    @FXML
    private TableColumn<StudentDTO, Date> colDOB;

    @FXML
    private TableColumn<StudentDTO, String> colGender;*/

    @FXML
    private Label lblSID;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblContact;

    @FXML
    private JFXTextField txtDOB;

    @FXML
    private Label lblDOB;

    @FXML
    private JFXTextField txtGender;

    @FXML
    private Label lblGender;

    @FXML
    private Label lblName;

    @FXML
    void addOnAction(ActionEvent event) {

    }

    @FXML
    void deleteOnAction(ActionEvent event) {

    }

    @FXML
    void txtIIDKeyTypeOnAction(KeyEvent event) {

    }

    @FXML
    void txtQtyOnHandKeyTypeOnAction(KeyEvent event) {

    }

    @FXML
    void txtUnitPriceKeyTypeOnAction(KeyEvent event) {

    }

    @FXML
    void updateOnAction(ActionEvent event) {

    }

    public void addOnAction(javafx.event.ActionEvent actionEvent) {

    }

    public void deleteOnAction(javafx.event.ActionEvent actionEvent) {

    }

    public void updateOnAction(javafx.event.ActionEvent actionEvent) {

    }

    public void txtIIDKeyTypeOnAction(javafx.scene.input.KeyEvent keyEvent) {

    }

    public void txtUnitPriceKeyTypeOnAction(javafx.scene.input.KeyEvent keyEvent) {

    }

    public void txtQtyOnHandKeyTypeOnAction(javafx.scene.input.KeyEvent keyEvent) {

    }
}
