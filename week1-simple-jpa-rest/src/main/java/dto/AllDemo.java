/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.Employee;
import facades.FacadeExample;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author sumit
 */
@Path("employee")
public class AllDemo {

    private static EntityManagerFactory emf;
    private static Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    FacadeExample facade = FacadeExample.getFacadeExample(emf);

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AllDemo
     */
    public AllDemo() {
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployeeById(@PathParam("id") int id) {

        EmployeeDTO employee = new EmployeeDTO(facade.getEmployeeId(id));

        return new Gson().toJson(employee.getName());

    }

    @Path("all")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllEmployees() {

        EmployeeDTO employee = new EmployeeDTO((Employee) facade.getAllEmployees());

        return new Gson().toJson(employee.getName());

    }

    @Path("salary")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployeeHighestSalary() {

        EmployeeDTO employee = new EmployeeDTO((Employee) facade.getEmployeesWithHighestSalary());

        return new Gson().toJson(employee.getName());

    }

    @Path("[name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String findEmployeeByName(@PathParam("name") String name) {

        EmployeeDTO employee = new EmployeeDTO((Employee) facade.findEmployeeByName(name));

        return new Gson().toJson(employee.getName());

    }

    @Path("new")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String addEmployee() {

        EmployeeDTO employee = new EmployeeDTO((Employee) facade.addEmployee("jens", "danshøj", 1000));

        return new Gson().toJson(employee.getName());

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
