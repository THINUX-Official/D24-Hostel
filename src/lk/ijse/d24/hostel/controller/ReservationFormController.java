package lk.ijse.d24.hostel.controller;

/*
    @author THINUX
    @created 13-Apr-23 - 16:21 
*/

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class ReservationFormController {
    public AnchorPane pane;
    public JFXTextField txtSearch;
    public TableView tblRoom;
    public TableColumn colRID;
    public TableColumn colDate;
    public TableColumn colRoomTypeID;
    public TableColumn colStudentID;
    public TableColumn colStatus;
    public Label lblRID;
    public DatePicker datePicker;
    public CheckBox cbxPaid;
    public CheckBox cbxUnpaid;
    public ComboBox cmbSID;
    public ComboBox cmbRoomTypeID;
    public Label lblRoomQty;

    public void addOnAction(ActionEvent actionEvent) {
    }

    public void deleteOnAction(ActionEvent actionEvent) {
    }

    public void updateOnAction(ActionEvent actionEvent) {
    }
}
