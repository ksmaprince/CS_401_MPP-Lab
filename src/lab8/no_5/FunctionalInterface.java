package lab8.no_5;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionalInterface {
    public static void main(String[] args) {
        Employee e1 = new Employee("John", 120000);
        Employee e2 = new Employee("John", 130000);
        //A
        Function<Employee, String> f1 = Employee::getName;
        System.out.println(f1.apply(e1));

        //B
        BiConsumer<Employee, String> f2 = Employee::setName;
        f2.accept(e1, "Smith");
        System.out.println(e1.name);

        //C
        BiFunction<String, String, Integer> f3 = String::compareTo;
        System.out.println(f3.apply("Hello", "Hello"));

        //D
        BiFunction<Integer, Integer, Integer> f4 = (x, y) -> (int) Math.pow(x, y);
        System.out.println(f4.apply(2,3));
        //E
        Apple a = new Apple(100);
        Function<Apple, Integer> f5 = Apple::getWeight;
        System.out.println(f5.apply(a));

        //F
        Function<String, Integer> f6 = Integer::parseInt;
        System.out.println(f6.apply("45"));
        //G
        EmployeeNameComparator comp = new EmployeeNameComparator();
        BiFunction<Employee, Employee, Integer> f7 = comp::compare;
        System.out.println(f7.apply(e1, e2));


    }
}
