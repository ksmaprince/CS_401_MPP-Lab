package lab10.prob4.soln2;

import lab10.prob4.Employee;
import lab10.prob4.Main;

import static org.junit.Assert.assertEquals;

public class Test {

    @org.junit.Test
   public void checkAsString(){

       Employee e1 = new Employee("Joe", "Davis", 120000);

       Employee e2 = new Employee("Andrew", "Reardon", 80000);

       Boolean is100000Employee1 = Main.salaryGreaterThan100000(e1);
       Boolean expectedResult1 = true;
       assertEquals(expectedResult1, is100000Employee1);

        Boolean is100000Employee2 = Main.salaryGreaterThan100000(e2);
        Boolean expectedResult2 = false;
        assertEquals(expectedResult2, is100000Employee2);


        Boolean is100000Employee3 = Main.lastNameAfterM(e1);
        Boolean expectedResult3 = false;
        assertEquals(expectedResult3, is100000Employee3);

        Boolean is100000Employee4 = Main.lastNameAfterM(e2);
        Boolean expectedResult4 = true;
        assertEquals(expectedResult4, is100000Employee4);


   }

}
