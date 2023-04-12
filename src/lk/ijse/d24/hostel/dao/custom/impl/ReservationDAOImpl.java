package lk.ijse.d24.hostel.dao.custom.impl;

/*
    @author THINUX
    @created 11-Apr-23 - 19:21 
*/

import lk.ijse.d24.hostel.dao.SuperDAO;
import lk.ijse.d24.hostel.dao.custom.ReservationDAO;
import lk.ijse.d24.hostel.entity.Reservation;
import org.hibernate.Session;

import java.util.List;

public class ReservationDAOImpl implements ReservationDAO, SuperDAO {

    @Override
    public List<Reservation> getAll() throws Exception {
        return null;
    }

    @Override
    public String save(Reservation dto) throws Exception {
        return null;
    }

    @Override
    public void update(Reservation dto) throws Exception {

    }

    @Override
    public void delete(Reservation dto) throws Exception {

    }

    @Override
    public String generateNewId() throws Exception {
        return null;
    }

    @Override
    public Reservation getObject(String s) throws Exception {
        return null;
    }

    @Override
    public void setSession(Session session) {

    }
}
