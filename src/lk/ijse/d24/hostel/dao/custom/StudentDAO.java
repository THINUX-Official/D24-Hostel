package lk.ijse.d24.hostel.dao.custom;

/*
    @author THINUX
    @created 11-Apr-23 - 19:15 
*/

import lk.ijse.d24.hostel.dao.CrudDAO;
import lk.ijse.d24.hostel.entity.Student;
import org.hibernate.Session;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student, String> {
    void setSession(Session session);

    List<String> geIds() throws Exception;
}
