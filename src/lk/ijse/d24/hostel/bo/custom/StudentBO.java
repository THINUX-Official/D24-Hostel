package lk.ijse.d24.hostel.bo.custom;

/*
    @author THINUX
    @created 14-Apr-23 - 08:02 
*/

import lk.ijse.d24.hostel.bo.SuperBO;
import lk.ijse.d24.hostel.model.StudentDTO;

import java.util.List;

public interface StudentBO extends SuperBO {
    List<StudentDTO> getAllStudents() throws Exception;

    String saveStudent(StudentDTO studentDTO) throws Exception;

    boolean updateStudent(StudentDTO studentDTO) throws Exception;

    boolean deleteStudent(StudentDTO studentDTO) throws Exception;

    String generateNewId() throws Exception;
}
