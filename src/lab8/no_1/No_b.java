package lab8.no_1;

import java.util.function.Supplier;

public class No_b {
    public static void main(String[] args) {
        //Method 1 lambda
        Supplier<Double> f = () -> Math.random();
        System.out.println(f.get());

        //Method 2 inner class
        class MyRandom implements Supplier<Double>{
            @Override
            public Double get() {
                return Math.random();
            }
        }

        MyRandom r = new MyRandom();
        System.out.println(r.get());
    }
}
