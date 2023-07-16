package lab7.prob2;

public class Ellipse implements ClosedCurve{

    double a, E;

    Ellipse(double a, double E){
        this.a = a;
        this.E = E;
    }

    @Override
    public double computePerimeter() {
        return 4 * a * E;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getE() {
        return E;
    }

    public void setE(double e) {
        E = e;
    }
}
