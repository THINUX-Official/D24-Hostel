package lk.ijse.d24.hostel.dao.custom.impl;

/*
    @author THINUX
    @created 11-Apr-23 - 19:20 
*/

import lk.ijse.d24.hostel.dao.SuperDAO;
import lk.ijse.d24.hostel.dao.custom.UserDAO;
import lk.ijse.d24.hostel.entity.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserDAOImpl implements UserDAO, SuperDAO {

    private Session session;

    @Override
    public List<User> getAll() throws Exception {
        String sql = "FROM user";
        Query query = session.createQuery(sql);
        List<User> list = query.list();
        session.close();
        return list;
    }

    @Override
    public String save(User dto) throws Exception {
        return (String) session.save(dto);
    }

    @Override
    public void update(User dto) throws Exception {
        session.update(dto);
    }

    @Override
    public void delete(User dto) throws Exception {
        session.delete(dto);
    }

    @Override
    public String generateNewId() throws Exception {
        String sql = "FROM user ORDER BY id DESC";
        User user = (User) session.createQuery(sql).setMaxResults(1).uniqueResult();
        session.close();

        if (user != null) {
            String lastId = user.getuId();
            int newId = Integer.parseInt(lastId.replace("U00-", "")) + 1;
            return String.format("U00-%03d", newId);
        }
        return "U00-001";
    }

    @Override
    public User getObject(String s) throws Exception {
        return session.get(User.class, s);
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }
}
