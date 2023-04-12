package lk.ijse.d24.hostel.bo.custom.impl;

/*
    @author THINUX
    @created 12-Apr-23 - 08:54 
*/

import lk.ijse.d24.hostel.bo.custom.RoomBO;
import lk.ijse.d24.hostel.dao.DAOFactory;
import lk.ijse.d24.hostel.dao.custom.RoomDAO;
import lk.ijse.d24.hostel.entity.Room;
import lk.ijse.d24.hostel.model.RoomDTO;
import lk.ijse.d24.hostel.util.SessionFactoryConfiguration;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class RoomBOImpl implements RoomBO {

    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOMDAO);

    private Session session;

    @Override
    public List<RoomDTO> getAllRoom() throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        roomDAO.setSession(session);
        List<Room> allRooms = roomDAO.getAll();
        ArrayList<RoomDTO> roomDTOS = new ArrayList<>();

        for (Room room : allRooms){
            roomDTOS.add(new RoomDTO(room.getRoomTypeId(), room.getType(), room.getKeyMoney(), room.getQty()));
        }

        return roomDTOS;
    }

    @Override
    public String saveRoom(RoomDTO roomDTO) throws Exception {
        return null;
    }

    @Override
    public boolean updateRoom(RoomDTO roomDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteRoom(RoomDTO roomDTO) throws Exception {
        return false;
    }

    @Override
    public String generateRoomId() throws Exception {
        return null;
    }
}
