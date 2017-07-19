package by.service;

import by.DAO.DAOForMessage;
import by.model.Employee;
import by.model.Message;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Роман on 09.07.2017.
 */
@Service
public class ServiceForMessage {
    private DAOForMessage daoForMessage;

    public void setDaoForMessage(DAOForMessage daoForMessage) {
        this.daoForMessage = daoForMessage;
    }
    @Transactional
    public void saveMessage(Message message){
        this.daoForMessage.saveMessage(message);
    }
    @Transactional
    public List<Message> showAllMessage(){
    return this.daoForMessage.showAllMessage();
    }
   @Transactional
    public Message findByIdMessage(int id){
    return    this.daoForMessage.findByIdMessage(id);
    }
    @Transactional
    public List<Employee> listEmployeeByIdMessage(int id){
       return this.daoForMessage.listEmployeeByIdMessage(id);
    }
}
