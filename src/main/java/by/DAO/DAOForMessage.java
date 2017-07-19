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
 * Created by Роман on 09.07.2017.
 */
@Repository
public class DAOForMessage {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void saveMessage(Message message){
        this.sessionFactory.getCurrentSession().persist(message);
    }
    public List<Message> showAllMessage(){
        Session session=this.sessionFactory.getCurrentSession();
        List<Message> messages=session.createQuery("from Message ").list();
        return messages;
    }
    public Message findByIdMessage(int id){
        Session session=this.sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Message where id=:id");
        query.setInteger("id",id);
        Message message= (Message) query.uniqueResult();
        return  message;
    }
    public List<Employee> listEmployeeByIdMessage(int id){
        Session session=this.sessionFactory.getCurrentSession();
        Message message= (Message) session.get(Message.class,id);
        Set<Employee> set=message.getEmployees();
        List<Employee> list=new ArrayList<>(set);
        return list;
    }
}
