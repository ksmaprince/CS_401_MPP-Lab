package lab9.part2.prob10c;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        IntStream myIntStream = IntStream.of(10, 6, 9, 12, 10, 7, 11, 30, 21, 5);
        IntSummaryStatistics summary = myIntStream.summaryStatistics();
        System.out.println("Maximum Value: "+summary.getMax());
        System.out.println("Minimum Value: "+summary.getMin());
    }
}
