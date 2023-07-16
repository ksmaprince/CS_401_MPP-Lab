package lab5.prob2;

public abstract class Duck {
    FlyBehavior f;
    QuackBehavior q;
    public abstract void display();
    public void fly(){
        f.fly();
    }
    public void quack(){
       q.quack();
    }
    protected void setFlyBehavior(FlyBehavior b){
        this.f = b;
    }

    protected void setQuackBehvior(QuackBehavior b){
        this.q = b;
    }

    public void swim(){
        System.out.println("  swimming");
    }
}
