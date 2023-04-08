package lk.ijse.d24.hostel.model;

/*
    @author THINUX
    @created 08-Apr-23 - 19:48 
*/

import java.util.Date;

public class StudentDTO {
    private String sID;
    private String name;
    private String address;
    private String contact;
    private Date date;
    private String gender;

    public StudentDTO() {
    }

    public StudentDTO(String sID, String name, String address, String contact, Date date, String gender) {
        this.sID = sID;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.date = date;
        this.gender = gender;
    }

    public String getsID() {
        return sID;
    }

    public void setsID(String sID) {
        this.sID = sID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "sID='" + sID + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", date=" + date +
                ", gender='" + gender + '\'' +
                '}';
    }
}
