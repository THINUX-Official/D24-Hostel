package lk.ijse.d24.hostel.controller;

/*
    @author THINUX
    @created 06-Apr-23 - 11:59 
*/

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.d24.hostel.bo.BOFactory;
import lk.ijse.d24.hostel.bo.custom.RoomBO;
import lk.ijse.d24.hostel.model.RoomDTO;

import java.util.ArrayList;
import java.util.Optional;

public class RoomFormController {
    public AnchorPane pane;
    public JFXTextField txtRID;
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

    private final RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBOTypes(BOFactory.BOTypes.ROOM);

    public void initialize() throws Exception {
        colRID.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("room_type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("room_key_money"));
        colRoomQty.setCellValueFactory(new PropertyValueFactory<>("room_qty"));

        tblRoom.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            btnDelete.setDisable(newValue == null);
            btnAdd.setDisable(newValue == null);

            if (newValue != null) {
                txtRID.setText(newValue.getRoomTypeId());
                txtRoomType.setText(newValue.getType());
                txtKeyMoney.setText(newValue.getKeyMoney());
                txtRoomQty.setText(String.valueOf(newValue.getQty()));
            }
        });

        loadAllRooms();
        txtRID.setText(generateNewID());
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
        String id = txtRID.getText();
        String roomType = txtRoomType.getText();
        String keyMoney = txtKeyMoney.getText();
        int roomQty = Integer.parseInt(txtRoomQty.getText());

        try {
            RoomDTO roomDTO = new RoomDTO(id, roomType, keyMoney, roomQty);

            roomBO.saveRoom(roomDTO);
            tblRoom.getItems().add(roomDTO);

            txtRID.clear();
            txtRoomType.clear();
            txtKeyMoney.clear();
            txtRoomQty.clear();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
            e.printStackTrace();
        }
    }

    public void updateOnAction(javafx.event.ActionEvent actionEvent) {
        String id = txtRID.getText();
        String roomType = txtRoomType.getText();
        String keyMoney = txtKeyMoney.getText();
        int roomQty = Integer.parseInt(txtRoomQty.getText());

        try {
            RoomDTO roomDTO = new RoomDTO(id, roomType, keyMoney, roomQty);

            roomBO.updateRoom(roomDTO);
            tblRoom.getItems().add(roomDTO);

            txtRID.clear();
            txtRoomType.clear();
            txtKeyMoney.clear();
            txtRoomQty.clear();

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

                txtRID.clear();
                txtRoomType.clear();
                txtKeyMoney.clear();
                txtRoomQty.clear();

            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Failed to delete room: " + e.getMessage()).show();
                e.printStackTrace();
            }
        }
    }

    public void txtIIDKeyTypeOnAction(javafx.scene.input.KeyEvent keyEvent) {

    }

    public void txtUnitPriceKeyTypeOnAction(javafx.scene.input.KeyEvent keyEvent) {

    }

    public void txtQtyOnHandKeyTypeOnAction(javafx.scene.input.KeyEvent keyEvent) {

    }

    private String generateNewID() throws Exception {
        try {
            return roomBO.generateRoomId();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Failed to generate the new ID " + e.getMessage()).show();
            e.printStackTrace();
        }
        return "RM-001";
    }
}
