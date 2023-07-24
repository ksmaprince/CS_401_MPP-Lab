package lab10.prob4.soln1;

import lab10.prob4.Employee;
import lab10.prob4.Main;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Test {

    @org.junit.Test
   public void checkAsString(){
       List<Employee> emps = Arrays.asList(new Employee("Joe", "Davis", 120000),
               new Employee("John", "Sims", 110000),
               new Employee("Joe", "Stevens", 200000),
               new Employee("Andrew", "Reardon", 80000));

       String expectedResult = "Joe Stevens, John Sims";

       String str = Main.asString(emps);

       assertEquals(expectedResult, str);
   }

}
