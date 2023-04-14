package lk.ijse.d24.hostel.bo.custom.impl;

/*
    @author THINUX
    @created 14-Apr-23 - 08:32 
*/

import lk.ijse.d24.hostel.bo.custom.UserBO;
import lk.ijse.d24.hostel.model.UserDTO;

import java.util.List;

public class UserBOImpl implements UserBO{
    @Override
    public List<UserDTO> getAllUser() throws Exception {
        return null;
    }

    @Override
    public String saveUser(UserDTO userDTO) throws Exception {
        return null;
    }

    @Override
    public boolean updateUser(UserDTO userDTO) throws Exception {
        return false;
    }

    @Override
    public boolean deleteUser(UserDTO userDTO) throws Exception {
        return false;
    }

    @Override
    public String generateUserId() throws Exception {
        return null;
    }
}
