package lab10.prob4;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        /*Stream<Employee> emps = Arrays.asList(new Employee("Joe", "Davis", 120000),
                new Employee("John", "Sims", 110000),
                new Employee("Joe", "Stevens", 200000),
                new Employee("Andrew", "Reardon", 80000),
                new Employee("Joe", "Cummings", 760000),
                new Employee("Steven", "Walters", 135000),
                new Employee("Thomas", "Blake", 111000),
                new Employee("Alice", "Richards", 101000),
                new Employee("Donald", "Trump", 100000)).stream();

        System.out.println(emps
                .filter(e -> (e.getSalary() > 100000))
                .filter(e -> (e.getLastName().charAt(0) > 'M'))
                .map(e -> fullName(e))
                .sorted()
                .collect(Collectors.joining(", ")));*/
        List<Employee> emps = Arrays.asList(new Employee("Joe", "Davis", 120000),
                new Employee("John", "Sims", 110000),
                new Employee("Joe", "Stevens", 200000),
                new Employee("Andrew", "Reardon", 80000),
                new Employee("Joe", "Cummings", 760000),
                new Employee("Steven", "Walters", 135000),
                new Employee("Thomas", "Blake", 111000),
                new Employee("Alice", "Richards", 101000),
                new Employee("Donald", "Trump", 100000));

        printEmps(emps);

    }

    private static String fullName(Employee e) {
        return e.getFirstName() + " " + e.getLastName();
    }

    //For Solution 1 Test
    /*public static String asString(List<Employee> emps) {
        return emps.stream()
                .filter(e -> (e.getSalary() > 100000))
                .filter(e -> (e.getLastName().charAt(0) > 'M'))
                .map(e -> fullName(e))
                .sorted()
                .collect(Collectors.joining(", "));
    }*/


    //For Solution 2 Test
    public static String asString(List<Employee> emps) {
        return emps.stream()
                .filter(Main::salaryGreaterThan100000)
                .filter(Main::lastNameAfterM)
                .map(e -> fullName(e))
                .sorted()
                .collect(Collectors.joining(", "));
    }
    public static void printEmps(List<Employee> list) {
        System.out.println(asString(list));
    }

    public static boolean salaryGreaterThan100000(Employee e){
        return e.salary>100000;
    }

    public static boolean lastNameAfterM(Employee e){
        return e.lastName.charAt(0)>'M';
    }

}
