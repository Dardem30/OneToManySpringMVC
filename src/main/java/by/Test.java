package by;

import by.DAO.DAOForDerpartment;
import by.model.Department;

/**
 * Created by Роман on 07.07.2017.
 */
public class Test {
    public static void main(String[] args) {
        DAOForDerpartment daoForDerpartment = new DAOForDerpartment();
        Department department = new Department();
        department.setName("bugalteria");
        daoForDerpartment.saveDepartment(department);
    }
}
