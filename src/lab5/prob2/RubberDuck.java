package lab5.prob2;

public class RubberDuck extends Duck{
    public RubberDuck(){
        setFlyBehavior(new CannotFly());
        setQuackBehvior(new Squeak());
    }
    @Override
    public void display() {
        System.out.println("  displaying");
    }
}
