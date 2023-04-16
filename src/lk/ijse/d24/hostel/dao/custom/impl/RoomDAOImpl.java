package lk.ijse.d24.hostel.dao.custom.impl;

/*
    @author THINUX
    @created 11-Apr-23 - 19:01 
*/

import lk.ijse.d24.hostel.dao.SuperDAO;
import lk.ijse.d24.hostel.dao.custom.RoomDAO;
import lk.ijse.d24.hostel.entity.Room;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.List;

public class RoomDAOImpl implements RoomDAO, SuperDAO {

    private Session session;

    @Override
    public List<Room> getAll() throws Exception {
        String sql = "FROM room";
        Query query = session.createQuery(sql);
        List<Room> list = query.list();
        session.close();
        return list;
    }

    @Override
    public String save(Room dto) throws Exception {
        return (String) session.save(dto);
    }

    @Override
    public void update(Room dto) throws Exception {
        session.update(dto);
    }

    @Override
    public void delete(Room dto) throws Exception {
        session.delete(dto);
    }

    @Override
    public String generateNewId() throws Exception {
        /*String sql = "FROM room ORDER BY room_type_id DESC";

        Room room = (Room) session.createQuery(sql).setMaxResults(1).uniqueResult();
        session.close();

        if (room != null) {
            String lastId = room.getRoomTypeId();
            int newRoomId = Integer.parseInt(lastId.replace("RID-", "")) + 1;
            System.out.println(newRoomId);
            return String.format("RID-%03d", newRoomId);
        }
        return "RID-001";*/

        String sql = "FROM room ORDER BY room_type_id DESC";
        Room room = (Room) session.createQuery(sql).setMaxResults(1).uniqueResult();

        if (room != null) {
            String lastId = room.getRoomTypeId();
            int newRoomId = Integer.parseInt(lastId.replace("RM-", "")) + 1;
            return String.format("RM-%04d", newRoomId);
        }
        return "RM-001";
    }

    @Override
    public Room getObject(String s) throws Exception {
        return session.get(Room.class, s);
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public List<String> getIds() throws Exception {
        String sql = "SELECT id FROM room";
        Query<String> query = session.createQuery(sql);
        List<String> result = query.list();
        session.close();
        return result;
    }
}
