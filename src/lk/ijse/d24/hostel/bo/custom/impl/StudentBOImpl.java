package lk.ijse.d24.hostel.bo.custom.impl;

/*
    @author THINUX
    @created 14-Apr-23 - 08:05 
*/

import lk.ijse.d24.hostel.bo.custom.StudentBO;
import lk.ijse.d24.hostel.dao.DAOFactory;
import lk.ijse.d24.hostel.dao.custom.StudentDAO;
import lk.ijse.d24.hostel.entity.Student;
import lk.ijse.d24.hostel.model.StudentDTO;
import lk.ijse.d24.hostel.util.SessionFactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class StudentBOImpl implements StudentBO {

    private Session session;

    StudentDAO studentDAO = (StudentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.STUDENTDAO);

    @Override
    public List<StudentDTO> getAllStudents() throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        studentDAO.setSession(session);

        List<Student> allStudent = studentDAO.getAll();
        List<StudentDTO> studentDTOList = new ArrayList<>();

        for (Student s : allStudent) {
            studentDTOList.add(new StudentDTO(s.getsId(), s.getName(),
                    s.getAddress(), s.getContact(),
                    s.getDob(), s.getGender()));
        }
        return studentDTOList;
    }

    @Override
    public String saveStudent(StudentDTO studentDTO) throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            studentDAO.setSession(session);
            String id = studentDAO.save(new Student(studentDTO.getsId(), studentDTO.getName(),
                    studentDTO.getAddress(), studentDTO.getContact(),
                    studentDTO.getdOB(), studentDTO.getGender()
            ));

            transaction.commit();
            session.close();
            return id;

        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return "S00-001";
        }
    }

    @Override
    public boolean updateStudent(StudentDTO studentDTO) throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            studentDAO.setSession(session);
            studentDAO.update(new Student(studentDTO.getsId(), studentDTO.getName(),
                    studentDTO.getAddress(), studentDTO.getContact(),
                    studentDTO.getdOB(), studentDTO.getGender()));

            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteStudent(StudentDTO studentDTO) throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try {
            studentDAO.setSession(session);
            studentDAO.delete(new Student(studentDTO.getsId(), studentDTO.getName(),
                    studentDTO.getAddress(), studentDTO.getContact(),
                    studentDTO.getdOB(), studentDTO.getGender()));

            transaction.commit();
            session.close();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            session.close();
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public String generateNewId() throws Exception {
        session = SessionFactoryConfiguration.getInstance().getSession();
        studentDAO.setSession(session);
        return studentDAO.generateNewId();
    }
}
