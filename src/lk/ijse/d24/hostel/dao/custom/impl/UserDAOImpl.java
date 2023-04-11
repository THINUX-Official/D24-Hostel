package lk.ijse.d24.hostel.dao.custom.impl;

/*
    @author THINUX
    @created 11-Apr-23 - 19:20 
*/

import lk.ijse.d24.hostel.dao.custom.UserDAO;
import lk.ijse.d24.hostel.entity.User;
import org.hibernate.Session;

import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getAll() throws Exception {
        return null;
    }

    @Override
    public String save(User dto) throws Exception {
        return null;
    }

    @Override
    public void update(User dto) throws Exception {

    }

    @Override
    public String generateNewId() throws Exception {
        return null;
    }

    @Override
    public User getObject(String s) throws Exception {
        return null;
    }

    @Override
    public void setSession(Session session) {

    }
}
