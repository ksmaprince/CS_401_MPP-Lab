package lab9.part2.prob12;

import java.util.Optional;
import java.util.function.Supplier;

public class MySingletonLazy {
    private static MySingletonLazy instance;
    private MySingletonLazy(){
        System.out.println("You create new instance");
    }
    public static MySingletonLazy getInstance(){
        //Old Way
       /* if (instance == null){
            instance = new MySingletonLazy();
        }
        return instance;*/

        //New Way
       Supplier<MySingletonLazy> f = () -> {
             return new MySingletonLazy();
        };

       instance = Optional.ofNullable(instance).orElseGet(f);
       return instance;
    }

}
