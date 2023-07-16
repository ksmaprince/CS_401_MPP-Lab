package lab9.part2.prob9;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        printSquare(10);
        printSquare(10);
    }

    private static void printSquare(int num) {
        IntStream s = IntStream.iterate(1, n -> nextSquare(n)).limit(num);
        s.forEach(n -> System.out.print(n + " "));

    }
    private static int nextSquare(int n) {
        return (int) Math.pow((Math.sqrt(n) + 1), 2);
    }
}
