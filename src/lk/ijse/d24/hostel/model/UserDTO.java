package lk.ijse.d24.hostel.model;

/*
    @author THINUX
    @created 11-Apr-23 - 18:48 
*/

public class UserDTO {
    private String uId;
    private String userName;
    private String password;
    private String contact;

    public UserDTO() {
    }

    public UserDTO(String uId, String userName, String password, String contact) {
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
        return "UserDTO{" +
                "uId='" + uId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }
}
