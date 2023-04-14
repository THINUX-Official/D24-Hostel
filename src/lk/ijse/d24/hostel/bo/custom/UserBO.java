package lk.ijse.d24.hostel.bo.custom;

/*
    @author THINUX
    @created 14-Apr-23 - 08:30 
*/

import lk.ijse.d24.hostel.bo.SuperBO;
import lk.ijse.d24.hostel.model.UserDTO;
import org.apache.poi.ss.extractor.ExcelExtractor;

import java.util.List;

public interface UserBO extends SuperBO {
    List<UserDTO> getAllUser() throws Exception;

    String saveUser(UserDTO userDTO) throws Exception;

    boolean updateUser(UserDTO userDTO) throws Exception;

    boolean deleteUser(UserDTO userDTO) throws Exception;

    String generateUserId() throws Exception;
}
