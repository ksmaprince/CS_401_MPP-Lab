package lab5.prob2;

public class RedheadDuck extends Duck{
    public RedheadDuck(){
        setFlyBehavior(new FlyWithWings());
        setQuackBehvior(new Quack());
    }
    @Override
    public void display() {
        System.out.println("  displaying");
    }
}
