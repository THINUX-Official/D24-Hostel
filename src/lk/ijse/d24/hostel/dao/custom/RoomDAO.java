package lk.ijse.d24.hostel.dao.custom;

/*
    @author THINUX
    @created 11-Apr-23 - 19:00 
*/

import lk.ijse.d24.hostel.dao.CrudDAO;
import lk.ijse.d24.hostel.entity.Room;
import org.hibernate.Session;

import java.util.List;

public interface RoomDAO extends CrudDAO<Room, String> {
    void setSession(Session session);

    List<String> getIds() throws Exception;
}
