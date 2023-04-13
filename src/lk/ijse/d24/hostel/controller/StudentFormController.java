package lk.ijse.d24.hostel.controller;

/*
    @author THINUX
    @created 06-Apr-23 - 12:37 
*/

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.d24.hostel.model.StudentDTO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class StudentFormController {


    public AnchorPane pane;
    public JFXTextField txtSID;
    public JFXTextField txtName;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public JFXTextField txtSearch;
    public TableView tblStudent;
    public TableColumn colSID;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colContact;
    public TableColumn colDOB;
    public TableColumn colGender;
    public Label lblSID;
    public Label lblAddress;
    public Label lblContact;
    public JFXTextField txtDOB;
    public Label lblDOB;
    public JFXTextField txtGender;
    public Label lblGender;
    public Label lblName;

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
