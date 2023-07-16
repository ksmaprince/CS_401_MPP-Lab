package lab9.part2.prob12;

public class Main {
    public static void main(String[] args) {

        MySingletonLazy s = MySingletonLazy.getInstance(); //It create new instance
        MySingletonLazy s1 = MySingletonLazy.getInstance();// no need to create instance again

    }
}
