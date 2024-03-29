package lk.ijse.d24.hostel.model;

/*
    @author THINUX
    @created 08-Apr-23 - 19:48 
*/

import java.util.Date;

public class StudentDTO {
    private String sId;
    private String name;
    private String address;
    private String contact;
    private Date dOB;
    private String gender;

    public StudentDTO() {
    }

    public StudentDTO(String sId, String name, String address, String contact, Date dOB, String gender) {
        this.sId = sId;
        this.name = name;
        this.address = address;
        this.contact = contact;
        this.dOB = dOB;
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

    public Date getdOB() {
        return dOB;
    }

    public void setdOB(Date dOB) {
        this.dOB = dOB;
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
                "sId='" + sId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contact='" + contact + '\'' +
                ", dOB=" + dOB +
                ", gender='" + gender + '\'' +
                '}';
    }
}
