package lk.ijse.d24.hostel.entity;

/*
    @author THINUX
    @created 01-Apr-23 - 19:38 
*/

import java.util.Date;

public class Reservation {
    private String resId;
    private Date date;
    private String sId;
    private String roomTypeId;
    private String status;

    public Reservation() {
    }

    public Reservation(String resId, Date date, String sId, String roomTypeId, String status) {
        this.resId = resId;
        this.date = date;
        this.sId = sId;
        this.roomTypeId = roomTypeId;
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

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(String roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "resId='" + resId + '\'' +
                ", date=" + date +
                ", sId='" + sId + '\'' +
                ", roomTypeId='" + roomTypeId + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
