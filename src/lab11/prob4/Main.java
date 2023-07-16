package lab11.prob4;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> l = List.of(4, 2, 5, 7, 8, 1, 10, 5, 7, 9);
        System.out.println("Second Smallest Integer: "+secondSmallest(l));

        List<Double> l1 = List.of(1.01, 1.03, 1.05, 0.11, 0.01, 0.02);
        System.out.println("Second Smallest Double: "+secondSmallest(l1));

        List<Character> l2 = List.of('A', 'E', 'I', 'O', 'U');
        System.out.println("Second Smallest Character: "+secondSmallest(l2));

        List<String> l3 = List.of("John", "Peter", "Henry", "Mona", "Elizabeth", "Juse", "Sam", "Paul");
        System.out.println("Second Smallest String: "+ secondSmallest(l3));
    }

    public static <T extends Comparable> T secondSmallest(List<T> list) {
        List<T> l = list.stream().sorted().collect(Collectors.toList());
        return l.get(1);
    }
}
