package lk.ijse.d24.hostel.dao.custom.impl;

/*
    @author THINUX
    @created 11-Apr-23 - 19:16 
*/

import lk.ijse.d24.hostel.dao.SuperDAO;
import lk.ijse.d24.hostel.dao.custom.StudentDAO;
import lk.ijse.d24.hostel.entity.Student;
import org.hibernate.Session;

import java.util.List;

public class StudentDAOImpl implements StudentDAO, SuperDAO {
    @Override
    public List<Student> getAll() throws Exception {
        return null;
    }

    @Override
    public String save(Student dto) throws Exception {
        return null;
    }

    @Override
    public void update(Student dto) throws Exception {

    }

    @Override
    public void delete(Student dto) throws Exception {

    }

    @Override
    public String generateNewId() throws Exception {
        return null;
    }

    @Override
    public Student getObject(String s) throws Exception {
        return null;
    }

    @Override
    public void setSession(Session session) {

    }

    @Override
    public List<String> geIds() throws Exception {
        return null;
    }
}
