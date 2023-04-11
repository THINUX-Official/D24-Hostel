package lk.ijse.d24.hostel.model;

/*
    @author THINUX
    @created 11-Apr-23 - 18:41 
*/

import lk.ijse.d24.hostel.entity.Room;
import lk.ijse.d24.hostel.entity.Student;

import java.util.Date;

public class ReservationDTO {
    private String resId;
    private Date date;
    private String status;

    private StudentDTO studentDTO;
    private RoomDTO roomDTO;

    private String sId;
    private String rId;

    public ReservationDTO() {
    }

    public ReservationDTO(String resId, Date date, String status, StudentDTO studentDTO, RoomDTO roomDTO, String sId, String rId) {
        this.resId = resId;
        this.date = date;
        this.status = status;
        this.studentDTO = studentDTO;
        this.roomDTO = roomDTO;
        this.sId = sId;
        this.rId = rId;
    }

    public ReservationDTO(String resId, Date date, String status) {
        this.resId = resId;
        this.date = date;
        this.status = status;
    }

    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public StudentDTO getStudentDTO() {
        return studentDTO;
    }

    public void setStudentDTO(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public RoomDTO getRoomDTO() {
        return roomDTO;
    }

    public void setRoomDTO(RoomDTO roomDTO) {
        this.roomDTO = roomDTO;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getrId() {
        return rId;
    }

    public void setrId(String rId) {
        this.rId = rId;
    }

    @Override
    public String toString() {
        return "ReservationDTO{" +
                "resId='" + resId + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", studentDTO=" + studentDTO +
                ", roomDTO=" + roomDTO +
                ", sId='" + sId + '\'' +
                ", rId='" + rId + '\'' +
                '}';
    }
}
