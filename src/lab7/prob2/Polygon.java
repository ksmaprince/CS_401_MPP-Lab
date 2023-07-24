package lab7.prob2;

public interface Polygon extends ClosedCurve{
    public double[] getSides();

    @Override
    default double computePerimeter() {
        double perimeter = 0;
        for (double v : getSides()) {
            perimeter += v;
        }
        return perimeter;
    }
}
