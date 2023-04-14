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
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class RoomBOImpl implements RoomBO {

    private Session session;

    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM_DAO);

    @Override
    public List<RoomDTO> getAllRoom() throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        roomDAO.setSession(session);
        List<Room> allRooms = roomDAO.getAll();
        ArrayList<RoomDTO> roomDTOS = new ArrayList<>();

        for (Room room : allRooms) {
            roomDTOS.add(new RoomDTO(room.getRoomTypeId(), room.getType(), room.getKeyMoney(), room.getQty()));
        }

        return roomDTOS;
    }

    @Override
    public String saveRoom(RoomDTO roomDTO) throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            roomDAO.setSession(session);
            String id = roomDAO.save(new Room(roomDTO.getRoomTypeId(), roomDTO.getType(),
                    roomDTO.getKeyMoney(), roomDTO.getQty()));
            transaction.commit();
            session.close();
            return id;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return "RES-001";
        }
    }

    @Override
    public boolean updateRoom(RoomDTO roomDTO) throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            roomDAO.setSession(session);
            roomDAO.update(new Room(roomDTO.getRoomTypeId(), roomDTO.getType(), roomDTO.getKeyMoney(), roomDTO.getQty()));
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e){
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteRoom(RoomDTO roomDTO) throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            roomDAO.setSession(session);
            roomDAO.delete(new Room(roomDTO.getRoomTypeId(), roomDTO.getType(), roomDTO.getKeyMoney(), roomDTO.getQty()));
            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String generateRoomId() throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        roomDAO.setSession(session);
        return roomDAO.generateNewId();
    }
}
