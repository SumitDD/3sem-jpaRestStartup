package facades;

import entities.Employee;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class FacadeExample {

    private static EntityManagerFactory emf;
    private static FacadeExample instance;

    private FacadeExample() {

    }

    public static FacadeExample getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new FacadeExample();
        }
        return instance;
    }

    public Employee addEmployee(String name, String addres, int salary) {
        Employee employee = new Employee(name, addres, salary);
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(employee);
            em.getTransaction().commit();
            return employee;
        } finally {
            em.close();
        }
    }

    public Employee getEmployeeId(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            Employee employee = em.find(Employee.class, id);
            return employee;
        } finally {
            em.close();
        }
    }

    public List findEmployeeByName(String name) {
        EntityManager em = emf.createEntityManager();

        try {
            TypedQuery<Employee> query = em.createQuery("Select e.name FROM Employee e where e.name = :name", Employee.class);
            query.setParameter("name", name);
            return (List) query.getResultList();

        } finally {
            em.close();
        }

    }

    public List<Employee> getAllEmployees() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("Select e.name FROM Employee e");
            List<String> result4 = query.getResultList();
            for (String employee : result4) {

                System.out.println(employee);
            }
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Employee> getEmployeesWithHighestSalary() {
        EntityManager em = emf.createEntityManager();
        try {
            Query query6 = em.createQuery("SELECT e.name FROM Employee e WHERE e.salary = (SELECT MAX(e.salary) FROM Employee e)");
            List employeeSalary = query6.getResultList();
           
            return employeeSalary;
        } finally {
            em.close();
        }
    }
}
