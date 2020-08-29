package facades;

import entities.Employee;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat; 




public class FacadeExampleTest {
    private static final EntityManagerFactory ENF = Persistence.createEntityManagerFactory("pu");
    private static final FacadeExample FE = FacadeExample.getFacadeExample(ENF);
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");      
    FacadeExample facade = FacadeExample.getFacadeExample(emf);

    
    
    public FacadeExampleTest() {
        
        
    }
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
//        Clean up database after test is done or use a persistence unit with drop-and-create to start up clean on every test
    }
    
    @BeforeEach
    public void setUp() {
//        Put the test database in a proper state before each test is run
    }
    
    @AfterEach
    public void tearDown() {
//        Remove any data after each test was run
    }

    /**
     * Test a method here.
     */
  
    @Test
    public void testAllEmployees(){
        
        int expected = 9;
        int result = facade.getAllEmployees().size();
        assertEquals(result, expected);
    }
    @Test
    public void testGetEmployeeById(){
        String expected = "sumit";
        Employee em = facade.getEmployeeId(201);
        assertEquals(expected, em.getName());
    }
     @Test
     public void testGetEmployeeWithHighestSalary(){
         String expected = "[ffff]";
         List<Employee> result = facade.getEmployeesWithHighestSalary();
         assertEquals(expected, result.toString());
     }
      @Test
    public void testFindEmployeeName(){
        String expected = "sumit";
        Employee em = facade.getEmployeeId(201);
        assertEquals(expected, em.getName());
     
     

    
}
}
