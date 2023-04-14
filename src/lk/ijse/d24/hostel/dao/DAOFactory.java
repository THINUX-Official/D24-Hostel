package lk.ijse.d24.hostel.dao;

/*
    @author THINUX
    @created 12-Apr-23 - 09:41 
*/

import lk.ijse.d24.hostel.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {

    }

    public static DAOFactory getDaoFactory() {
        return daoFactory == null
                ? daoFactory = new DAOFactory()
                : daoFactory;

        /*if (daoFactory==null){
            daoFactory=new DAOFactory();
        }
        return daoFactory;*/
    }

    public enum DAOTypes {
        ROOM_DAO, STUDENT_DAO, RESERVATION_DAO, USER_DAO, QUERY_DAO;
    }

    public SuperDAO getDAO(DAOTypes daoTypes) {
        switch (daoTypes) {
            case ROOM_DAO:
                return new RoomDAOImpl();
            case STUDENT_DAO:
                return new StudentDAOImpl();
            case RESERVATION_DAO:
                return new ReservationDAOImpl();
            case USER_DAO:
                return new UserDAOImpl();
            case QUERY_DAO:
                return new QueryDAOImpl();
        }
        return null;
    }
}
