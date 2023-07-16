package lab_practice_fun_gen.prob3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Problem3 {

    //Imperative Method
    public static <T> Collection<T> filterByCondition(Collection<? extends T> list, Predicate<T> valid) {
        Collection<T> newList = new ArrayList<>();
        for (T t : list) {
            if (valid.test(t)){
                newList.add(t);
            }
        }
        return newList;
    }

    //Declarative Method
    public static <T> Collection<T> filterByCondition1(Collection<? extends T> list, Predicate<T> valid) {
        return list.stream().filter(valid).collect(Collectors.toList());
    }


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
        List<Employee> emps = Arrays.asList(employees);

        List<Integer> ints = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        Predicate<Integer> f1 = n -> n%2 == 0;  // check if even
        System.out.println(filterByCondition(ints, f1)); // IMPERATIVE
        System.out.println(filterByCondition1(ints, f1)); // DECLARATIVE

        List<String> strs = List.of("John", "Paul", "Sam", "Henry", "Jone", "Smith", "Peter", "Song", "Elle", "Susan", "Merry");
        Predicate<String> f2 = str -> str.startsWith("S"); //check if startwith("S")
        System.out.println(filterByCondition(strs, f2)); // IMPERATIVE
        System.out.println(filterByCondition1(strs, f2)); // DECLARATIVE


        Predicate<Employee> f3 = e -> e.getSalary()>5000 && e.getDepartment().equals("IT");
        System.out.println(filterByCondition(emps, f3)); // IMPERATIVE
        System.out.println(filterByCondition1(emps, f3)); // DECLARATIVE

    }
}
