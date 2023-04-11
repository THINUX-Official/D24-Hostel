package lk.ijse.d24.hostel.controller;

/*
    @author THINUX
    @created 06-Apr-23 - 11:59 
*/

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.d24.hostel.model.RoomDTO;

import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RoomFormController {
    @FXML
    private AnchorPane pane;

    @FXML
    private JFXTextField txtRID;

    @FXML
    private JFXTextField txtType;

    @FXML
    private JFXTextField txtKeyMoney;

    @FXML
    private JFXTextField txtRoomQty;

    @FXML
    private JFXTextField txtSearch;

    @FXML
    private TableView<RoomDTO> tblRoom;

    /*@FXML
    private TableColumn<RoomDTO, String> colRID;

    @FXML
    private TableColumn<RoomDTO, String> colType;

    @FXML
    private TableColumn<RoomDTO, String> colKeyMoney;

    @FXML
    private TableColumn<RoomDTO, Integer> colRoomQty;*/

    @FXML
    private Label lblIID;

    @FXML
    private Label lblUnitPrice;

    @FXML
    private Label lblQtyOnHand;

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
