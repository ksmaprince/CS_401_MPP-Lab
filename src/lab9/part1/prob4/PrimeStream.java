package lab9.part1.prob4;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrimeStream {

   // static final Function<Integer, Stream<Integer>> f = n -> Stream.iterate(2, x -> PrimeOrdinary.nextPrime(x)).limit(n);

    static final Function<Integer, Stream<Integer>> f = n -> Stream.iterate(2, PrimeOrdinary::nextPrime).limit(n);

     class PrimeOrdinary{
        static int nextPrime(int num){
            if (num < 2) return 2;
            int next = num + 1;
            if (!isPrime(next)) return nextPrime(next);
            return next;
        }

        static boolean isPrime(int n){
            for (int k = 2; k*k <=n; ++k){
                if (n%k == 0) return false;
            }
            return true;
        }
    }


    public static void main(String[] args) {

        PrimeStream ps = new PrimeStream(); //PrimeStream is enclosing class
        ps.printFirstNPrimes(10);
        System.out.println("====");
        ps.printFirstNPrimes(5);


    }

    void printFirstNPrimes(int n) {
        System.out.println(f.apply(n).collect(Collectors.toList()));
    }

}
