package lk.ijse.d24.hostel.controller;

/*
    @author THINUX
    @created 06-Apr-23 - 11:59 
*/

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.d24.hostel.model.RoomDTO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RoomFormController {
    public AnchorPane pane;
    public JFXTextField txtRID;
    public JFXTextField txtType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtRoomQty;
    public JFXTextField txtSearch;
    public TableView tblRoom;
    public TableColumn colRID;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colRoomQty;
    public Label lblRID;
    public Label lblKeyMoney;
    public Label lblRoomQty;
    public Label lblType;

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
