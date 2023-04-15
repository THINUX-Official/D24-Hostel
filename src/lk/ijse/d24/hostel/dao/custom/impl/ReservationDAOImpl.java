package lk.ijse.d24.hostel.dao.custom.impl;

/*
    @author THINUX
    @created 11-Apr-23 - 19:21 
*/

import lk.ijse.d24.hostel.dao.SuperDAO;
import lk.ijse.d24.hostel.dao.custom.ReservationDAO;
import lk.ijse.d24.hostel.entity.Reservation;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class ReservationDAOImpl implements ReservationDAO, SuperDAO {

    private Session session;

    @Override
    public List<Reservation> getAll() throws Exception {
        String sql = "FROM reservation";
        org.hibernate.query.Query query = session.createQuery(sql);
        List list = query.list();
        session.close();
        return list;
    }

    @Override
    public String save(Reservation dto) throws Exception {
        return (String) session.save(dto);
    }

    @Override
    public void update(Reservation dto) throws Exception {
        session.update(dto);
    }

    @Override
    public void delete(Reservation dto) throws Exception {
        session.delete(dto);
    }

    @Override
    public String generateNewId() throws Exception {
        String sql = "FROM reservation ORDER BY id DESC";
        Reservation reservation = (Reservation) session.createQuery(sql).setMaxResults(1).uniqueResult();
        session.close();

        if (reservation != null) {
            String lastId = reservation.getResId();
            int newId = Integer.parseInt(lastId.replace("RE0-", "")) + 1;
            return String.format("RE0-%03d", newId);
        }
        return "RE0-001";
    }

    @Override
    public Reservation getObject(String s) throws Exception {
        return session.get(Reservation.class, s);
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean changeCheckBoxValue(String id, String status) {
        String sql = "UPDATE reservation r SET r.reservation_status =: sts WHERE r.reservation_id =: rid";
        Query query = session.createQuery(sql);
        query.setParameter("sts", status);
        query.setParameter("rid", id);

        int value = query.executeUpdate();
        return value >= 0;
    }
}
