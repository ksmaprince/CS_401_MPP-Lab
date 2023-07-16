package lab5.prob2;

public class DecoyDuck extends Duck{
    public DecoyDuck(){
        setFlyBehavior(new CannotFly());
        setQuackBehvior(new MuteQuack());
    }
    @Override
    public void display() {
        System.out.println("  displaying");
    }
}
