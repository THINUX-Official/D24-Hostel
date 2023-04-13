package lk.ijse.d24.hostel.controller;

/*
    @author THINUX
    @created 06-Apr-23 - 11:59 
*/

import com.jfoenix.controls.JFXTextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.d24.hostel.bo.BOFactory;
import lk.ijse.d24.hostel.bo.custom.RoomBO;
import lk.ijse.d24.hostel.model.RoomDTO;
import java.util.List;

public class RoomFormController {
    public AnchorPane pane;
    public JFXTextField txtRID;
    public JFXTextField txtRoomType;
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

    private final RoomBO roomBO = (RoomBO) BOFactory.getBoFactory().getBOTypes(BOFactory.BOTypes.ROOM);

    public void initialize() {
        colRID.setCellValueFactory(new PropertyValueFactory<>("room_type_id"));
        colType.setCellValueFactory(new PropertyValueFactory<>("room_type"));
        colKeyMoney.setCellValueFactory(new PropertyValueFactory<>("room_key_money"));
        colRoomQty.setCellValueFactory(new PropertyValueFactory<>("room_qty"));

        loadAllRooms();
    }

    private void loadAllRooms() {

        /*ObservableList<RoomTM> roomTMS = FXCollections.observableArrayList();

        try {
            List<RoomDTO> roomDTOS = roomBO.getAllRoom();

            for (RoomDTO roomDTO : roomDTOS) {
                RoomTM roomTM = new RoomTM(
                        roomDTO.getRoomTypeId(),
                        roomDTO.getType(),
                        roomDTO.getKeyMoney(),
                        roomDTO.getQty()
                );
                roomTMS.add(roomTM);
            }
            tblRoom.setItems(roomTMS);
        } catch (Exception e) {
            e.printStackTrace();
        }

        tblRoom.getItems().clear();*/

        try {
//            ArrayList<RoomDTO> roomDTOArrayList= (ArrayList<RoomDTO>) roomBO.getAllRoom();
            List<RoomDTO> allRoom = roomBO.getAllRoom();
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
