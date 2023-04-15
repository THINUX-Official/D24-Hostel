package lk.ijse.d24.hostel.bo.custom;

/*
    @author THINUX
    @created 14-Apr-23 - 10:05 
*/

import lk.ijse.d24.hostel.bo.SuperBO;
import lk.ijse.d24.hostel.model.ReservationDTO;
import lk.ijse.d24.hostel.model.RoomDTO;
import lk.ijse.d24.hostel.model.StudentDTO;
import org.apache.hadoop.hive.ql.session.LineageState;

import java.util.List;

public interface ReservationBO extends SuperBO {
    List<ReservationDTO> getAllReservation() throws Exception;

    String saveReservation(ReservationDTO reservationDTO) throws Exception;

    boolean updateReservation(ReservationDTO reservationDTO) throws Exception;

    boolean deleteReservation(ReservationDTO reservationDTO) throws Exception;

    String generateReservationId() throws Exception;

    StudentDTO getStudent(String id) throws Exception;

    RoomDTO getRoom(String id) throws Exception;

    List<String> getStudentId() throws Exception;

    List<String> getRoomId() throws Exception;

    List<StudentDTO> getAllStudent() throws Exception;

    List<RoomDTO> getAllRoom() throws Exception;

    boolean updateRoomQty(RoomDTO roomDTO) throws Exception;

    boolean checkStatusClick(String id, String status) throws Exception;
}
