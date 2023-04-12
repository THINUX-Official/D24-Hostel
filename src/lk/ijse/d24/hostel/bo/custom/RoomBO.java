package lk.ijse.d24.hostel.bo.custom;

/*
    @author THINUX
    @created 12-Apr-23 - 08:54 
*/

import lk.ijse.d24.hostel.bo.SuperBO;
import lk.ijse.d24.hostel.model.RoomDTO;

import java.util.List;

public interface RoomBO extends SuperBO {
    List<RoomDTO> getAllRoom() throws Exception;

    String saveRoom(RoomDTO roomDTO) throws Exception;

    boolean updateRoom(RoomDTO roomDTO) throws Exception;

    boolean deleteRoom(RoomDTO roomDTO) throws Exception;

    String generateRoomId() throws Exception;
}
