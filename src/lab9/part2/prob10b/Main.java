package lab9.part2.prob10b;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream<String> stringStream = Stream.of("Bill", "Thomas", "Mary");
        //stringStream.forEach(s -> System.out.print(s+" "));
        //OR
        // System.out.println(stringStream.collect(Collectors.joining(", ")));
        //OR
        System.out.println(stringStream.reduce("", (s1, s2) -> s1 + " " + s2));
    }
}
