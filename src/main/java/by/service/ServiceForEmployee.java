package by.service;

import by.DAO.DAOForEmployee;
import by.model.Department;
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
 * Created by Роман on 07.07.2017.
 */
@Service
public class ServiceForEmployee {
    private DAOForEmployee daoForEmployee;

    public void setDaoForEmployee(DAOForEmployee daoForEmployee) {
        this.daoForEmployee = daoForEmployee;
    }
    @Transactional
    public void saveEmployee(Employee employee){
        this.daoForEmployee.saveEmployee(employee);
    }
    @Transactional
    public List<Department> getListDepartment(){
        return this.daoForEmployee.getListDepartment();
    }
    @Transactional
    public Employee findByIdMessage(int id){
        return this.daoForEmployee.findByIdMessage(id);
    }
    @Transactional
    public void updateEmployee(Employee employee){
        this.daoForEmployee.updateEmployee(employee);
    }
    @Transactional
    public List<Message> listMessageByIdEmployee(int id){
        return this.daoForEmployee.listMessageByIdEmployee(id);
    }
    @Transactional
    public byte[] getImageById(int id){
       return this.daoForEmployee.getImageById(id);
    }
    @Transactional
    public Employee getEmployeeById(int id){
       return this.daoForEmployee.getEmployeeById(id);
    }
}
