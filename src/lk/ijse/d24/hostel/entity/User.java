package lk.ijse.d24.hostel.entity;

/*
    @author THINUX
    @created 11-Apr-23 - 18:16 
*/

import javax.persistence.Column;
import javax.persistence.Id;

public class User {
    @Id
    @Column(name = "user_id")
    private String uId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_contact")
    private String contact;

    public User() {
    }

    public User(String uId, String userName, String password, String contact) {
        this.uId = uId;
        this.userName = userName;
        this.password = password;
        this.contact = contact;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "User{" +
                "uId='" + uId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
