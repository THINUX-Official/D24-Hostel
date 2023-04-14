package lk.ijse.d24.hostel.bo.custom.impl;

/*
    @author THINUX
    @created 14-Apr-23 - 08:32 
*/

import lk.ijse.d24.hostel.bo.BOFactory;
import lk.ijse.d24.hostel.bo.custom.UserBO;
import lk.ijse.d24.hostel.dao.DAOFactory;
import lk.ijse.d24.hostel.dao.custom.UserDAO;
import lk.ijse.d24.hostel.entity.User;
import lk.ijse.d24.hostel.model.UserDTO;
import lk.ijse.d24.hostel.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO{
    private Session session;

    UserDAO userDAO = (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER_DAO);


    @Override
    public List<UserDTO> getAllUser() throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        userDAO.setSession(session);

        List<User> allUser = userDAO.getAll();
        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user : allUser) {
            userDTOList.add(new UserDTO(user.getuId(), user.getUserName(), user.getPassword(), user.getContact()));
        }
        return userDTOList;
    }

    @Override
    public String saveUser(UserDTO userDTO) throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            userDAO.setSession(session);
            String id = userDAO.save(new User(userDTO.getuId(), userDTO.getUserName(), userDTO.getPassword(), userDTO.getContact()));

            transaction.commit();
            session.close();
            return id;

        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return "U00-001";
        }
    }

    @Override
    public boolean updateUser(UserDTO userDTO) throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            userDAO.setSession(session);
            userDAO.update(new User(userDTO.getuId(), userDTO.getUserName(), userDTO.getPassword(), userDTO.getContact()));

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
    public boolean deleteUser(UserDTO userDTO) throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            userDAO.setSession(session);
            userDAO.delete(new User(userDTO.getuId(), userDTO.getUserName(), userDTO.getPassword(), userDTO.getContact()));

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
    public String generateUserId() throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        userDAO.setSession(session);
        return userDAO.generateNewId();
    }
}
