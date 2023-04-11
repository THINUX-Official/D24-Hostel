package lk.ijse.d24.hostel.dao.custom;

/*
    @author THINUX
    @created 11-Apr-23 - 19:19 
*/

import lk.ijse.d24.hostel.dao.CrudDAO;
import lk.ijse.d24.hostel.entity.User;
import org.hibernate.Session;

public interface UserDAO extends CrudDAO<User, String> {
    void setSession(Session session);
}
