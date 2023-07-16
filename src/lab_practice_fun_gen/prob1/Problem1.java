package lab_practice_fun_gen.prob1;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Problem1 {

    public static final BiPredicate<Integer, Integer> f1 = (x, y) -> x + y < x * y;

    public static final BiPredicate<Integer, Integer> f2 = (x, y) -> myCompare(x, y);

    static class MyBiPredicate implements BiPredicate<Integer, Integer>{
        @Override
        public boolean test(Integer x, Integer y) {
            return x + y < x * y;
        }
    }

    //helper method
    public static Boolean myCompare(Integer x, Integer y) {
        return x+y < x*y;
    }
    private void evaluator(){
        //Test 1
        System.out.println(f1.test(2, 3));

        //Test2
        System.out.println(f2.test(2, 3));

        //Test3
        MyBiPredicate myBiPredicate = new MyBiPredicate();
        System.out.println(myBiPredicate.test(2, 3));
    }
    public static void main(String[] args) {
        Problem1 p = new Problem1();
        p.evaluator();
    }
}
