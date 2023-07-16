package lab5.prob2;

public class MallardDuck extends Duck{
    public MallardDuck(){
        setFlyBehavior(new FlyWithWings());
        setQuackBehvior(new Quack() );
    }
    @Override
    public void display() {
        System.out.println("  displaying");
    }
}
