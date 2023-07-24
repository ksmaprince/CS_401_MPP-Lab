package school_lab_practice.prob1;

import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class Problem1 {

    Random r = new Random();
    // name and type of lambda
    Supplier<Integer> f1 = () -> r.nextInt();

    // representing lambda as a method reference
    //Supplier<Integer> f2 = r::nextInt;

    //Function<Random, Integer> f2 = Random::nextInt;
    Supplier<Integer> f2 = Problem1::myMethodRefHelper;


    //representing lambda as a static nested class
    class MyNestedClass implements Supplier<Integer>{
        @Override
        public Integer get() {
            return new Random().nextInt();
        }
    }

    static int myMethodRefHelper(){
        Random r = new Random();
        return r.nextInt();
    }

    MyNestedClass c = new MyNestedClass();
    public void evaluator(){
        System.out.println("Random with Lambda: "+f1.get());
        System.out.println("Random with MethodRef: "+f2.get());
        System.out.println("Random with NestedClass: "+c.get());
    }

    public static void main(String[] args) {
        Problem1 p = new Problem1();
        p.evaluator();
    }
}
