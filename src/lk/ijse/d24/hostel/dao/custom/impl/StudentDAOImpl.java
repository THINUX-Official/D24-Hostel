package lk.ijse.d24.hostel.dao.custom.impl;

/*
    @author THINUX
    @created 11-Apr-23 - 19:16 
*/

import lk.ijse.d24.hostel.dao.SuperDAO;
import lk.ijse.d24.hostel.dao.custom.StudentDAO;
import lk.ijse.d24.hostel.entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAOImpl implements StudentDAO, SuperDAO {

    private Session session;

    @Override
    public List<Student> getAll() throws Exception {
        String sql = "FROM student";
        Query query = session.createQuery(sql);
        List list = query.list();
        session.close();
        return list;
    }

    @Override
    public String save(Student dto) throws Exception {
        return (String) session.save(dto);
    }

    @Override
    public void update(Student dto) throws Exception {
        session.update(dto);
    }

    @Override
    public void delete(Student dto) throws Exception {
        session.delete(dto);
    }

    @Override
    public String generateNewId() throws Exception {
        String sql = "FROM student ORDER BY id DESC";
        Student student = (Student) session.createQuery(sql).setMaxResults(1).uniqueResult();
        session.close();

        if (student != null) {
            String lastId = student.getsId();
            int newId = Integer.parseInt(lastId.replace("S00-", "")) + 1;
            return String.format("S00-%03d", newId);
        }
        return "S00-001";
    }

    @Override
    public Student getObject(String s) throws Exception {
        return session.get(Student.class, s);
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public List<String> geIds() throws Exception {
        String sql = "SELECT id FROM student";
        Query query = session.createQuery(sql);
        List<String> list = query.list();
        session.close();
        System.out.println(list);
        return list;
    }
}
