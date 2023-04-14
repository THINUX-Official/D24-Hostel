package lk.ijse.d24.hostel.bo.custom.impl;

/*
    @author THINUX
    @created 14-Apr-23 - 10:13 
*/

import lk.ijse.d24.hostel.bo.custom.ReservationBO;
import lk.ijse.d24.hostel.model.ReservationDTO;
import lk.ijse.d24.hostel.model.RoomDTO;
import lk.ijse.d24.hostel.model.StudentDTO;

import java.util.List;

public class ReservationBOImpl implements ReservationBO {
    @Override
    public List<ReservationDTO> getAllReservation() throws Exception {
        return null;
    }

    @Override
    public String saveReservation(ReservationDTO reservationDTO) throws Exception {
        return null;
    }

    @Override
    public boolean updateReservation(ReservationDTO reservationDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteReservation(ReservationDTO reservationDTO) throws Exception {
        return false;
    }

    @Override
    public String generateReservationId() throws Exception {
        return null;
    }

    @Override
    public StudentDTO getStudent() throws Exception {
        return null;
    }

    @Override
    public RoomDTO getRoom() throws Exception {
        return null;
    }

    @Override
    public List<String> getStudentId() throws Exception {
        return null;
    }

    @Override
    public List<String> getRoomId() throws Exception {
        return null;
    }

    @Override
    public boolean updateRoomQty() throws Exception {
        return false;
    }

    @Override
    public boolean checkStatusClick() throws Exception {
        return false;
    }
}
