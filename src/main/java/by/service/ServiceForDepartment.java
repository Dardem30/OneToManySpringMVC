package by.service;

import by.DAO.DAOForDerpartment;
import by.model.Department;
import by.model.Employee;
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
public class ServiceForDepartment {
    private DAOForDerpartment daoForDepartment;

    public void setDaoForDepartment(DAOForDerpartment daoForDepartment) {
        this.daoForDepartment = daoForDepartment;
    }
    @Transactional
    public void saveDepartment(Department department){
        this.daoForDepartment.saveDepartment(department);
    }
    @Transactional
    public List<Employee> listEmployee(){
       return this.daoForDepartment.listEmployee();
    }
    @Transactional
    public Department findByIdDepartment(int id){
        return this.daoForDepartment.findByIdDepartment(id);
    }
    @Transactional
    public List<Employee> listEmployeeByIdDepartment(int id){
        return this.daoForDepartment.listEmployeeByIdDepartment(id);
    }
}
