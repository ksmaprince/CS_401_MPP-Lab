package lab3.prob3;

public abstract class Property {

    private double rent;

    private Address address;

    Property(Address address){
        this.address = address;
        rent = 0.0;
    }

    abstract double computeRent();
}
