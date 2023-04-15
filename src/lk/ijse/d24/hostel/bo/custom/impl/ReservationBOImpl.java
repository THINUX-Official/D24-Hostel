package lk.ijse.d24.hostel.bo.custom.impl;

/*
    @author THINUX
    @created 14-Apr-23 - 10:13 
*/

import lk.ijse.d24.hostel.bo.custom.ReservationBO;
import lk.ijse.d24.hostel.dao.DAOFactory;
import lk.ijse.d24.hostel.dao.custom.QueryDAO;
import lk.ijse.d24.hostel.dao.custom.ReservationDAO;
import lk.ijse.d24.hostel.dao.custom.RoomDAO;
import lk.ijse.d24.hostel.dao.custom.StudentDAO;
import lk.ijse.d24.hostel.entity.Reservation;
import lk.ijse.d24.hostel.entity.Room;
import lk.ijse.d24.hostel.entity.Student;
import lk.ijse.d24.hostel.model.ReservationDTO;
import lk.ijse.d24.hostel.model.RoomDTO;
import lk.ijse.d24.hostel.model.StudentDTO;
import lk.ijse.d24.hostel.util.SessionFactoryConfiguration;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class ReservationBOImpl implements ReservationBO {

    private Session session;

    ReservationDAO reservationDAO = (ReservationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.RESERVATION_DAO);
    RoomDAO roomDAO = (RoomDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ROOM_DAO);
    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENT_DAO);
    QueryDAO queryDAO = (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERY_DAO);

    @Override
    public List<ReservationDTO> getAllReservation() throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        reservationDAO.setSession(session);

        List<Reservation> allReservation = reservationDAO.getAll();
        List<ReservationDTO> reservationDTOS = new ArrayList<>();

        for (Reservation reservation : allReservation) {
            reservationDTOS.add(
                    new ReservationDTO(
                            reservation.getResId(),
                            reservation.getDate(),
                            reservation.getStatus(),
                            new StudentDTO(
                                    reservation.getStudent().getsId(),
                                    reservation.getStudent().getName(),
                                    reservation.getStudent().getAddress(),
                                    reservation.getStudent().getContact(),
                                    reservation.getStudent().getDob(),
                                    reservation.getStudent().getGender()),
                            new RoomDTO(
                                    reservation.getRoom().getRoomTypeId(),
                                    reservation.getRoom().getType(),
                                    reservation.getRoom().getKeyMoney(),
                                    reservation.getRoom().getQty())));
        }
        return reservationDTOS;
    }

    @Override
    public String saveReservation(ReservationDTO reservationDTO) throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            reservationDAO.setSession(session);
            reservationDAO.save(
                    new Reservation(
                            reservationDTO.getResId(),
                            reservationDTO.getDate(),
                            reservationDTO.getStatus(),
                            new Student(
                                    reservationDTO.getStudentDTO().getsId(),
                                    reservationDTO.getStudentDTO().getName(),
                                    reservationDTO.getStudentDTO().getAddress(),
                                    reservationDTO.getStudentDTO().getContact(),
                                    reservationDTO.getStudentDTO().getdOB(),
                                    reservationDTO.getStudentDTO().getGender(),
                                    new Room(
                                            reservationDTO.getRoomDTO().getRoomTypeId(),
                                            reservationDTO.getRoomDTO().getType(),
                                            reservationDTO.getRoomDTO().getKeyMoney(),
                                            reservationDTO.getRoomDTO().getQty()))));

            transaction.commit();
            session.close();
            return String.valueOf(true);
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean updateReservation(ReservationDTO reservationDTO) throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            reservationDAO.setSession(session);
            reservationDAO.update(
                    new Reservation(
                            reservationDTO.getResId(),
                            reservationDTO.getDate(),
                            reservationDTO.getStatus(),
                            new Student(
                                    reservationDTO.getStudentDTO().getsId(),
                                    reservationDTO.getStudentDTO().getName(),
                                    reservationDTO.getStudentDTO().getAddress(),
                                    reservationDTO.getStudentDTO().getContact(),
                                    reservationDTO.getStudentDTO().getdOB(),
                                    reservationDTO.getStudentDTO().getGender(),
                                    new Room(
                                            reservationDTO.getRoomDTO().getRoomTypeId(),
                                            reservationDTO.getRoomDTO().getType(),
                                            reservationDTO.getRoomDTO().getKeyMoney(),
                                            reservationDTO.getRoomDTO().getQty()
                                    ))));

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
    public boolean deleteReservation(ReservationDTO reservationDTO) throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            reservationDAO.setSession(session);
            reservationDAO.delete(new Reservation(
                    reservationDTO.getResId(),
                    reservationDTO.getDate(),
                    reservationDTO.getStatus()));

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
    public String generateReservationId() throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        return reservationDAO.generateNewId();
    }

    @Override
    public StudentDTO getStudent(String id) throws Exception {
        try {
            session = SessionFactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();

            studentDAO.setSession(session);
            Student s = studentDAO.getObject(id);

            transaction.commit();
            session.close();
            return new StudentDTO(s.getsId(), s.getName(), s.getAddress(), s.getContact(), s.getDob(), s.getGender());

        } catch (Exception e) {
            session.close();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public RoomDTO getRoom(String id) throws Exception {
        try {
            session = SessionFactoryConfiguration.getInstance().getSession();
            Transaction transaction = session.beginTransaction();

            roomDAO.setSession(session);
            Room r = roomDAO.getObject(id);

            transaction.commit();
            session.close();
            return new RoomDTO(r.getRoomTypeId(), r.getType(), r.getKeyMoney(), r.getQty());
        } catch (Exception e) {
            session.close();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<String> getStudentId() throws Exception {
        try {
            session = SessionFactoryConfiguration.getInstance().getSession();
            studentDAO.setSession(session);
            session.close();

            return studentDAO.geIds();
        } catch (Exception e) {
            session.close();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<String> getRoomId() throws Exception {
        try {
            session = SessionFactoryConfiguration.getInstance().getSession();
            roomDAO.setSession(session);
            session.close();

            return roomDAO.getIds();
        } catch (Exception e) {
            session.close();
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<StudentDTO> getAllStudent() throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        studentDAO.setSession(session);

        List<Student> allStudent = studentDAO.getAll();
        ArrayList<StudentDTO> studentDTOS = new ArrayList<>();

        for (Student student : allStudent) {
            studentDTOS.add(new StudentDTO(student.getsId(), student.getName(),
                    student.getAddress(), student.getContact(),
                    student.getDob(), student.getGender()));
        }
        return studentDTOS;
    }

    @Override
    public List<RoomDTO> getAllRoom() throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        studentDAO.setSession(session);

        List<Room> allRoom = roomDAO.getAll();
        ArrayList<RoomDTO> roomDTOS = new ArrayList<>();

        for (Room room : allRoom) {
            roomDTOS.add(new RoomDTO(room.getRoomTypeId(), room.getType(),
                    room.getKeyMoney(), room.getQty()));
        }
        return roomDTOS;
    }

    @Override
    public boolean updateRoomQty(RoomDTO roomDTO) throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            roomDAO.setSession(session);
            roomDAO.update(new Room(roomDTO.getRoomTypeId(), roomDTO.getType(),
                    roomDTO.getKeyMoney(), roomDTO.getQty()));
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
    public boolean checkStatusClick(String id, String status) throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        boolean isUpdated = false;

        try {
            reservationDAO.setSession(session);
            isUpdated = reservationDAO.changeCheckBoxValue(id, status);
            transaction.commit();
            session.close();
        } catch (HibernateException e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
        }
        return isUpdated;
    }
}
