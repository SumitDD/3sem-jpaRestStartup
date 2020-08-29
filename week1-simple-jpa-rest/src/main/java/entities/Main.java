/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import facades.FacadeExample;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author sumit
 */
public class Main {
    
    public static void main(String[] args) {
        
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");      
    FacadeExample facade = FacadeExample.getFacadeExample(emf);
        //Employee el = facade.addEmployee("niels", "taastrup", 222);
        //System.out.println(facade.getAllEmployees());
        System.out.println(facade.getEmployeeId(201));
        


    }
    
}
