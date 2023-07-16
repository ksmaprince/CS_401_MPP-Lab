package lab8.no_3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class BiFunctionLab {
    public static void main(String[] args) {
        class MyBiFunction implements BiFunction<Double, Double, List<Double>>{
            @Override
            public List<Double> apply(Double x, Double y) {
                List<Double> list = new ArrayList<>();
                list.add(Math.pow(x, y));
                list.add(x * y);
                return list;
            }
        }

        MyBiFunction f = new MyBiFunction();
        System.out.println(f.apply(2.0, 3.0));

        //Java 8 - With Lambda
        BiFunction<Double, Double, List<Double>> f1 = (x, y) -> {
            List<Double> list = new ArrayList<>();
            list.add(Math.pow(x, y));
            list.add(x * y);
            return list;
        };
        System.out.println(f.apply(2.0, 3.0));
    }
}
