package by.DAO;

import by.model.Department;
import by.model.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Роман on 07.07.2017.
 */
@Repository
public class DAOForDerpartment {
    SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void saveDepartment(Department department){
        sessionFactory.getCurrentSession().persist(department);
    }
    public List<Employee> listEmployee(){
        Session session=this.sessionFactory.getCurrentSession();
        List<Employee> list=session.createQuery("from Employee ").list();
        return list;
    }
    public Department findByIdDepartment(int id){
        Session session=this.sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Department where id=:id");
        query.setInteger("id",id);
        Department department= (Department) query.uniqueResult();
        return department;
    }
    public List<Employee> listEmployeeByIdDepartment(int id){
        Session session=this.sessionFactory.getCurrentSession();
        Department department= (Department) session.get(Department.class,id);
        Set<Employee> set=department.getEmployees();
        List<Employee> list=new ArrayList<>(set);
        return list;
    }
}
