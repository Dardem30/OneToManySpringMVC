package by.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Роман on 07.07.2017.
 */
@Entity
public class Employee {
    @Id
    @Column(name = "id_employee")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Basic
    @Column(name = "name_employee")
    private String name;
    @ManyToOne
    @JoinColumn(name = "id_department",updatable = false,nullable = false)
    private Department department;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(name = "employee_message",joinColumns = @JoinColumn(name = "id_employee"),
    inverseJoinColumns = @JoinColumn(name = "id_message"))
    private Set<Message> messages;
    @Basic
    @Column(name = "photo")
    private String photo;
    @Basic
    @Column(name = "photo_employee")
    @Lob
    private byte[] photoEmployee;

    public byte[] getPhotoEmployee() {
        return photoEmployee;
    }

    public void setPhotoEmployee(byte[] photoEmployee) {
        this.photoEmployee = photoEmployee;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Set<Message> getMessages() {
        return messages;
    }

    public void setMessages(Set<Message> messages) {
        this.messages = messages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != employee.id) return false;
        return name != null ? name.equals(employee.name) : employee.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}
