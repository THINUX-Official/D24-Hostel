package lk.ijse.d24.hostel.controller;

/*
    @author THINUX
    @created 06-Apr-23 - 11:59 
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.d24.hostel.bo.BOFactory;
import lk.ijse.d24.hostel.bo.custom.RoomBO;
import lk.ijse.d24.hostel.model.RoomDTO;

import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RoomFormController {
    public AnchorPane pane;
    public JFXTextField txtRoomType;
    public JFXTextField txtKeyMoney;
    public JFXTextField txtRoomQty;
    public JFXTextField txtSearch;
    public TableView<RoomDTO> tblRoom;
    public TableColumn colRID;
    public TableColumn colType;
    public TableColumn colKeyMoney;
    public TableColumn colRoomQty;
    public Label lblRID;
    public Label lblKeyMoney;
    public Label lblRoomQty;
    public Label lblType;
    public JFXButton btnAdd;
    public JFXButton btnDelete;
    public JFXButton btnUpdate;
    public Label lblRid;

    private Matcher nameMatcher;
    private Matcher amountMatcher;

    private final RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBOTypes(BOFactory.BOTypes.ROOM);

    public void initialize() throws Exception {
        colRID.setCellValueFactory(new PropertyValueFactory<>("roomTypeId"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("keyMoney"));
        colRoomQty.setCellValueFactory(new PropertyValueFactory<>("qty"));

        tblRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnDelete.setDisable(newValue == null);
            btnAdd.setDisable(newValue == null);

            if (newValue != null) {
                lblRid.setText(newValue.getRoomTypeId());
                txtRoomType.setText(newValue.getType());
                txtKeyMoney.setText(newValue.getKeyMoney());
                txtRoomQty.setText(String.valueOf(newValue.getQty()));
            }
        });

        loadAllRooms();
        lblRid.setText(generateNewID());
    }

    private void loadAllRooms() {
        try {
            ArrayList<RoomDTO> allRoom = (ArrayList<RoomDTO>) roomBO.getAllRoom();
//            List<RoomDTO> allRoom = roomBO.getAllRoom();
            System.out.println(allRoom);

            for (RoomDTO roomDTO : allRoom) {
                tblRoom.getItems().add(new RoomDTO(
                        roomDTO.getRoomTypeId(),
                        roomDTO.getType(),
                        roomDTO.getKeyMoney(),
                        roomDTO.getQty())
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addOnAction(javafx.event.ActionEvent actionEvent) {
        String id = lblRid.getText();
        String roomType = txtRoomType.getText();
        String keyMoney = txtKeyMoney.getText();
        int roomQty = Integer.parseInt(txtRoomQty.getText());

        try {
            RoomDTO roomDTO = new RoomDTO(id, roomType, keyMoney, roomQty);

            roomBO.saveRoom(roomDTO);
            tblRoom.getItems().add(roomDTO);

            clearData();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }
    }

    public void updateOnAction(javafx.event.ActionEvent actionEvent) {
        String id = lblRid.getText();
        String roomType = txtRoomType.getText();
        String keyMoney = txtKeyMoney.getText();
        int roomQty = Integer.parseInt(txtRoomQty.getText());

        try {
            RoomDTO roomDTO = new RoomDTO(id, roomType, keyMoney, roomQty);

            roomBO.updateRoom(roomDTO);
            tblRoom.getItems().add(roomDTO);

            clearData();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }
    }

    public void deleteOnAction(javafx.event.ActionEvent actionEvent) {
        RoomDTO roomDTO = tblRoom.getSelectionModel().getSelectedItem();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete this room?", ButtonType.YES, ButtonType.NO);
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.get() == ButtonType.YES) {
            try {
                roomBO.deleteRoom(roomDTO);
                tblRoom.getItems().remove(roomDTO);
                tblRoom.getSelectionModel().clearSelection();

                clearData();

            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Failed to delete room: " + e.getMessage()).show();
                e.printStackTrace();
            }
        }
    }

    private void clearData() {
        txtRoomType.clear();
        txtKeyMoney.clear();
        txtRoomQty.clear();
    }

    private String generateNewID() throws Exception {
        try {
            return roomBO.generateRoomId();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Failed to generate the new ID " + e.getMessage()).show();
            e.printStackTrace();
        }
        return "RM-0001";
    }

    public void txtTypeKeyTypeOnAction(KeyEvent keyEvent) {
        lblType.setText("");

        Pattern namePattern = Pattern.compile("^([a-zA-Z]{2,})$");
        nameMatcher = namePattern.matcher(txtRoomType.getText());

        if (!nameMatcher.matches()) {
            txtRoomType.requestFocus();
            lblType.setText("Invalid Name");
        }
    }

    public void txtKeyMoneyKeyTypeOnAction(KeyEvent keyEvent) {
        lblKeyMoney.setText("");

        Pattern amountPattern = Pattern.compile("^[0-9]{3,}\\d+\\.\\d+$");
        amountMatcher = amountPattern.matcher(txtKeyMoney.getText());

        if (!amountMatcher.matches()) {
            txtKeyMoney.requestFocus();
            lblKeyMoney.setText("Invalid Input");
        }
    }

    public void txtRoomQtyKeyTypeOnAction(KeyEvent keyEvent) {
        lblRoomQty.setText("");

        Pattern amountPattern = Pattern.compile("^[0-9]{1,}$");
        amountMatcher = amountPattern.matcher(txtRoomQty.getText());

        if (!amountMatcher.matches()) {
            txtRoomQty.requestFocus();
            lblRoomQty.setText("Invalid Input");
        }
    }
}
