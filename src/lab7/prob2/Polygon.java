package lab7.prob2;

public interface Polygon extends ClosedCurve{
    public double[] getLength();

    @Override
    default double computePerimeter() {
        double perimeter = 0;
        for (double v : getLength()) {
            perimeter += v;
        }
        return perimeter;
    }
}
