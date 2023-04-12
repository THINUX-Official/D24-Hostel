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
    }

    public enum DAOTypes {
        ROOMDAO, STUDENTDAO, RESERVATIONDAO, USERDAO, QUERYDAO
    }

    public SuperDAO getDAO(DAOTypes daoTypes) {
        switch (daoTypes) {
            case ROOMDAO:
                return new RoomDAOImpl();
            case STUDENTDAO:
                return new StudentDAOImpl();
            case RESERVATIONDAO:
                return new ReservationDAOImpl();
            case USERDAO:
                return new UserDAOImpl();
            case QUERYDAO:
                return new QueryDAOImpl();
        }
        return null;
    }
}
