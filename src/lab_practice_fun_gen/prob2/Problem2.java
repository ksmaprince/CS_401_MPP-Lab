package lab_practice_fun_gen.prob2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Problem2 {
    public static void main(String[] args) {
        // initialize array of Employees
        Employee[] employees = {
                new Employee("Jason", "Red", 5000, "IT"),
                new Employee("Ashley", "Green", 7600, "IT"),
                new Employee("Matthew", "Indigo", 3587.5, "Sales"),
                new Employee("Indigo", "Indigo", 3587.5, "Sales"),
                new Employee("Indra", "Matthew", 3587.5, "Sales"),
                new Employee("James", "Indigo", 4700.77, "Marketing"),
                new Employee("Luke", "Indigo", 6200, "IT"),
                new Employee("Jason", "Blue", 3200, "Sales"),
                new Employee("Wendy", "Brown", 4236.4, "Marketing")};

        // get List view of the Employees
        List<Employee> list = Arrays.asList(employees);

        // display all Employees
        System.out.println("Complete Employee list:");
        list.stream().forEach(System.out::println);   //A method reference.

        //implement here
        //NO.1. Employees in IT department
        System.out.println("\nNO.1 Employee in IT department: ");
        list.stream()
                .filter(e -> e.getDepartment().equals("IT"))
                .forEach(System.out::println);

        //NO.2 the first Employee with a salary in the range of $3000-$7000.
        System.out.println("\nNO.2 First Employee with 3000-7000 salary:");
        list.stream()
                .filter(e -> e.getSalary() >= 3000 && e.getSalary() <= 7000)
                .findFirst()
                .ifPresent(System.out::println);


        //NO.3 Print out All of the employee objects, but if the last name begins with the letter ‘I’, then capitalize all the letters
        //in the last name.
        System.out.println("\nNO.3 Print All Employee - last name begin with I and then capitalize it");
        list.stream()
                .map(e -> {
                    if (e.getLastName().startsWith("I"))
                        e.setLastName(e.getLastName().toUpperCase());
                    return e;
                })
                .forEach(System.out::println);

        //NO.4 Print out all the Employee objects’ last names, whose last name begins with the letter ‘I’, but First name does
        //not begin with the letter ‘I’. Print out only the last names.
        System.out.println("\nNO.4 Print the last name of Emp start with I and whose first name not start with I");
        list.stream()
                .filter(e -> e.getLastName().startsWith("I") && !e.getFirstName().startsWith("I"))
                .map(Employee::getLastName)
                .forEach(System.out::println);


        //NO. 5 Use the Collectors.joining method to print out All Employee objects and separate each one with a delimiter of
        //“---\n---“.
        System.out.println("\nNO.5 Print out All Employee objects with delimiter");
        System.out.println(list.stream()
                .map(e -> e.toString())
                .collect(Collectors.joining("--\n--")));

        //NO. 6
        System.out.println("\nNO.6 Print out Even number");
        System.out.println(Stream.iterate(0, n -> n + 2)
                .map(n -> n.toString())
                .limit(20)
                .collect(Collectors.joining(", ")));

        //NO. 7 Display employee’s first names with salaries in the range of $5000-$10000 sorted into ascending order by
        //department.
        list.stream()
                .filter(e -> e.getSalary() >= 5000 && e.getSalary() <= 10000)
                .sorted(Comparator.comparing(e -> e.getDepartment()))
                .forEach(System.out::println);


        //NO. 8 Display last names of unique employees in sorted order.Note: use the distinct operation before mapping to last
        //name.
        System.out.println("\nNO.8 Display last name ...");
        list.stream()
                .distinct()
                .map(e -> e.getLastName())
                .sorted()
                .forEach(System.out::println);


        //NO. 9 Print a list of both the capital and non-capital last names of employees using stream concat operation.
        System.out.println("\nNO.9 Display a list of both capital and non-capital last name");
        Stream.concat(list.stream().map(e -> e.getLastName()), list.stream().map(e -> e.getLastName().toUpperCase()))
                .forEach(System.out::println);

        //NO. 10 Calculate sum of Employee salaries using DoubleStream.
        System.out.println("\nNO.10 Calculate sum of Employee salaries using DoubleStream.");
        System.out.println(list.stream()
                .mapToDouble(Employee::getSalary)
                .sum());


        //NO. 11 Calculate sum of Employee salaries with Stream’s reduce method.
        System.out.println("\nNO.11 Calculate sum of Employee salaries with Stream’s reduce method.");
        System.out.println(list.stream()
                .mapToDouble(Employee::getSalary)
                .reduce(0.0, (x, y) -> x + y));

        //NO. 12 Count number of Employees in each department by using groupingBy operation.
        System.out.println("\nCount number of Employees in each department by using groupingBy operation.");
        System.out.println(list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())));

        //NO. 13 Print out each department name with the average salary by using groupingBy operation.
        System.out.println("\nNO.13 Print out each department name with the average salary by using groupingBy operation.");
        System.out.println(list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary))));

        //NO. 14 Print out each department and its corresponding employees by using groupingBy operation
        System.out.println("\nNO.14 Print out each department and its corresponding employees by using groupingBy operation");
        System.out.println(list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment)));


        //NO. 15 From given employee list, create Map<String, List<Double>> map: keys will be department names, and values
        //will be salaries of the department by using groupingBy operation and show the result using forEach method.
        System.out.println("\nNO. 15 Department Salary Map ....");
        Map<String, List<Double>> map = list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getSalary, Collectors.toList())));
        map.forEach((dept, salList) ->
                System.out.println(dept + " " + salList)
        );


    }


//
} // end class Problem2

