package by.DAO;

import by.model.Department;
import by.model.Employee;
import by.model.Message;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Роман on 07.07.2017.
 */
@Repository
public class DAOForEmployee {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void saveEmployee(Employee employee){
        this.sessionFactory.getCurrentSession().persist(employee);
    }
    public List<Department> getListDepartment(){
        Session session=this.sessionFactory.getCurrentSession();
        List<Department> departments=session.createQuery("from Department ").list();
        return departments;
    }
    public Employee findByIdMessage(int id){
       Session session=this.sessionFactory.getCurrentSession();
       Employee employee= (Employee) session.get(Employee.class,id);
       return employee;
    }
    public List<Message> listMessageByIdEmployee(int id){
      Session session=this.sessionFactory.getCurrentSession();
      Employee employee=findByIdMessage(id);
      Set<Message> messageSet=employee.getMessages();
      List<Message> messages=new ArrayList<>(messageSet);
      return messages;
    }
    public void updateEmployee(Employee employee){
        this.sessionFactory.getCurrentSession().update(employee);
    }

    public byte[] getImageById(int id){
        Employee employee= (Employee) this.sessionFactory.getCurrentSession().get(Employee.class,id);
        return employee.getPhotoEmployee();
    }
    public Employee getEmployeeById(int id){
        Employee employee= (Employee) this.sessionFactory.getCurrentSession().get(Employee.class,id);
        return employee;
    }
}
