
package dto;

import entities.Employee;


public class EmployeeDTO {
    
    private int id;
    private String name;
    private String address;


    public EmployeeDTO(Employee employee) {
        
        this.id = employee.getID();
        this.name = employee.getName();
        this.address = employee.getAddres();
        
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
