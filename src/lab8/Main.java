package lab8;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

//Test
public class Main {

    Function<Employee, String> A = (Employee e) -> e.getName();
    Function<Employee, String> A1 = Employee::getName;
    BiConsumer<Employee, String> B = (Employee e, String s) -> e.setName(s);
    BiConsumer<Employee, String> B1 = Employee::setName;
    BiFunction<String, String, Integer> C = (String s1, String s2) -> s1.compareTo(s2);
    BiFunction<String, String, Integer> C1 = String::compareTo;
    BiFunction<Integer, Integer, Double> D = (Integer x,Integer y) -> Math.pow(x,y);
    BiFunction<Integer, Integer, Double> D1 = Math::pow;
    Consumer<String> F = (String x) -> Integer.parseInt(x);
    Consumer<String> F1 = Integer::parseInt;

    Comparator<Employee> comp = (e1, e2) -> e1.getName().compareTo(e2.getName());

    private void evaluator(){

    }
    public static void main(String[] args) {
        
    }
}
