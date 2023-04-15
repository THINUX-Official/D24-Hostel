package lk.ijse.d24.hostel.dao.custom;

/*
    @author THINUX
    @created 11-Apr-23 - 19:20 
*/

import lk.ijse.d24.hostel.dao.CrudDAO;
import lk.ijse.d24.hostel.entity.Reservation;
import org.hibernate.Session;

public interface ReservationDAO extends CrudDAO<Reservation, String> {
    void setSession(Session session);
    boolean changeCheckBoxValue(String id, String status);
}
