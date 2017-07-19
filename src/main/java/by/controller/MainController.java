package by.controller;

import by.model.Department;
import by.model.Employee;
import by.model.Message;
import by.modelSecurity.RolesEntity;
import by.modelSecurity.UsersEntity;
import by.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import javax.validation.Valid;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by Роман on 07.07.2017.
 */
@Controller
public class MainController{
    String UPLOADED_FOLDER="C:\\Users\\Роман\\IdeaProjects\\ManyToOneSpringMVCHibernate\\web\\image\\";
    @Autowired
    @Qualifier("serviceUser")
    private ServiceUser serviceUser;

    public void setServiceUser(ServiceUser serviceUser) {
        this.serviceUser = serviceUser;
    }
@Autowired
@Qualifier("serviceRole")
private ServiceRole serviceRole;

    public void setServiceRole(ServiceRole serviceRole) {
        this.serviceRole = serviceRole;
    }

    @Autowired
    @Qualifier("serviceForDepartment")
    private ServiceForDepartment serviceForDepartment;
    @Autowired
    @Qualifier("serviceForEmployee")
    private ServiceForEmployee serviceForEmployee;
     @Autowired
     @Qualifier("serviceForMessage")
     private ServiceForMessage serviceForMessage;

    public void setServiceForMessage(ServiceForMessage serviceForMessage) {
        this.serviceForMessage = serviceForMessage;
    }

    public void setServiceForEmployee(ServiceForEmployee serviceForEmployee) {
        this.serviceForEmployee = serviceForEmployee;
    }

    public void setServiceForDepartment(ServiceForDepartment serviceForDepartment) {
        this.serviceForDepartment = serviceForDepartment;
    }

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView main(){
        ModelAndView modelAndView=new ModelAndView("saveImageEmployee");
        modelAndView.addObject("department",new Department());
        modelAndView.addObject("employee",new Employee());
        modelAndView.addObject("message",new Message());
        modelAndView.addObject("listMessage",this.serviceForMessage.showAllMessage());
        modelAndView.addObject("listDepartment",serviceForEmployee.getListDepartment());
        modelAndView.addObject("listEmployee",serviceForDepartment.listEmployee());
        return modelAndView;
    }
    @RequestMapping(value = "/saveDepartment",method = RequestMethod.GET)
    public String saveDepartment(@ModelAttribute("department") Department department){
            this.serviceForDepartment.saveDepartment(department);
            return "redirect:/";
    }
    @RequestMapping(value = "/saveEmployee",method = RequestMethod.GET)
    public String saveEmployee(@ModelAttribute("employee")Employee employee){
            this.serviceForEmployee.saveEmployee(employee);
            return "redirect:/";
    }
    @RequestMapping(value = "/employeeListDepartment/{id}",method = RequestMethod.GET)
    public String listEmployeeDepartment(@PathVariable("id")int id,Model model){
        model.addAttribute("employee",new Employee());
        model.addAttribute("employeeListDepartments",this.serviceForDepartment.listEmployeeByIdDepartment(id));
        model.addAttribute("employeeListMessage",this.serviceForMessage.listEmployeeByIdMessage(id));
        return "employee";
    }
    @RequestMapping(value = "/messageListEmployee/{id}",method = RequestMethod.GET)
    public String listEmployeeMessage(@PathVariable("id")int id,Model model){
        model.addAttribute("message",new Message());
        model.addAttribute("messageListEmployee",this.serviceForEmployee.listMessageByIdEmployee(id));
        return "message";
    }
    @RequestMapping(value = "/addImage",method = RequestMethod.POST)
    public String addImage(@RequestParam("file")MultipartFile file,@ModelAttribute("employee")Employee employee){
        serviceForEmployee.saveEmployee(employee);
        byte[] bytes = new byte[0];
        try {
            bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER +employee.getId()+ file.getOriginalFilename());
            employee.setPhoto(employee.getId()+file.getOriginalFilename());
            Files.write(path, bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        serviceForEmployee.updateEmployee(employee);
        return "redirect:/";
    }
    @RequestMapping(value = "/saveImageEmployee",method = RequestMethod.POST)
    public ModelAndView saveImageEmployee(
            @RequestParam("photoE")MultipartFile file,
            @ModelAttribute("employee")Employee employee) throws IOException {
        employee.setPhotoEmployee(file.getBytes());
        serviceForEmployee.saveEmployee(employee);
        ModelAndView modelAndView=new ModelAndView("photoEmployee");
        modelAndView.addObject("listEmployee",serviceForDepartment.listEmployee());
        return modelAndView;
    }
    @RequestMapping(value = "/drow",method = RequestMethod.GET)
    public void drowImage(@RequestParam("id")Integer id, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        byte[] bytes=serviceForEmployee.getImageById(id);
        Employee employee=serviceForEmployee.getEmployeeById(id);
        response.setContentType("image/png");
//        ServletOutputStream servletOutputStream=response.getOutputStream();
//        servletOutputStream.write(employee.getPhotoEmployee());
//        servletOutputStream.close();
        response.getOutputStream().write(employee.getPhotoEmployee());
        response.getOutputStream().close();
    }
    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String registration(Model model){
    model.addAttribute("user",new UsersEntity());
    return "registration";
    }
    @RequestMapping(value = "/registration",method = RequestMethod.POST)
    public String registration(@ModelAttribute("user")UsersEntity usersEntity){
        Set<RolesEntity> rolesEntitySet=new HashSet<>();
        rolesEntitySet.add(serviceRole.getRoleById(2));
        usersEntity.setRolesEntitySet(rolesEntitySet);
        serviceUser.saveUser(usersEntity);
        return "redirect:/";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model
            //, String error, String logout
                        ) {
//        if (error != null) {
//            model.addAttribute("error", "Username or password is incorrect.");
//        }
//
//        if (logout != null) {
//            model.addAttribute("message", "Logged out successfully.");
//        }

        return "login";
    }
}
