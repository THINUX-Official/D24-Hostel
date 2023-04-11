package lk.ijse.d24.hostel.entity;

/*
    @author THINUX
    @created 01-Apr-23 - 19:38 
*/

import javax.persistence.*;
import java.util.Date;

@Entity (name = "reservation")
public class Reservation {

    @Id
    @Column(name = "reservation_id", length = 10)
    private String resId;

    @Column(name = "reservation_date")
    private Date date;

    @Column (name = "reservation_status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "room_type_id")
    private Room room;

    public Reservation() {
    }

    public Reservation(String resId, Date date, String status, Student student, Room room) {
        this.resId = resId;
        this.date = date;
        this.status = status;
        this.student = student;
        this.room = room;
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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "resId='" + resId + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                ", student=" + student +
                ", room=" + room +
                '}';
    }
}
