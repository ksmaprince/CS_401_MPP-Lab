package lab8.no_1;

import java.util.function.Supplier;

public class No_b {
    Supplier<Double> f1 = () -> Math.random();
    Supplier<Double> f2 = Math::random;

    Supplier<Double> f3 = No_b::myRandomHelper;

    class MyRandomClass implements Supplier<Double>{
        @Override
        public Double get() {
            return Math.random();
        }
    }

    static Double myRandomHelper(){
        return Math.random();
    }

    MyRandomClass m = new MyRandomClass();

    private void evaluator(){
        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(m.get());
    }
    public static void main(String[] args) {
        No_b n = new No_b();
        n.evaluator();
    }
}
