package lk.ijse.d24.hostel.entity;

/*
    @author THINUX
    @created 01-Apr-23 - 19:30 
*/

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "student")
public class Student {

    @Id
    @Column(name = "student_id", length = 10)
    private String sId;

    @Column(name = "student_name")
    private String name;

    @Column(name = "student_address")
    private String address;

    @Column(name = "student_contact")
    private String contact;

    @Column(name = "student_date_of_birth")
    private Date dob;

    @Column(name = "student_gender")
    private String gender;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "student")
    private List<Reservation> reservationList = new ArrayList<>();

    public Student(String s, String name, String address, String contact, Date date, String gender, Room room) {
    }

    public Student(String sId, String name, String address, String contact, Date dob, String gender) {
        this.sId = sId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.dob = dob;
        this.gender = gender;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId='" + sId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", dob=" + dob +
                ", gender='" + gender + '\'' +
                '}';
    }
}
