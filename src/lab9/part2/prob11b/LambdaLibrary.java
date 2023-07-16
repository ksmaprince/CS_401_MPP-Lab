package lab9.part2.prob11b;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LambdaLibrary {
    public static final
    Function<List<Employee>, String> NAMES_IN_NZ_SAL_10000
            = list -> list.stream()
            .filter(e -> e.salary > 100000 && e.lastName.matches("[N-Z].*"))
            .map(e -> e.firstName + " " + e.lastName)
            .sorted()
            .collect(Collectors.joining(","));
}



