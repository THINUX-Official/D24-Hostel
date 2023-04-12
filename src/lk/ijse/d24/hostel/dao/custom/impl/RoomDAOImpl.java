package lk.ijse.d24.hostel.dao.custom.impl;

/*
    @author THINUX
    @created 11-Apr-23 - 19:01 
*/

import lk.ijse.d24.hostel.dao.custom.RoomDAO;
import lk.ijse.d24.hostel.entity.Room;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class RoomDAOImpl implements RoomDAO {

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
        return null;
    }

    @Override
    public void update(Room dto) throws Exception {

    }

    @Override
    public String generateNewId() throws Exception {
        return null;
    }

    @Override
    public Room getObject(String s) throws Exception {
        return null;
    }

    @Override
    public void setSession(Session session) {

    }

    @Override
    public List<String> getIds() throws Exception {
        return null;
    }
}
