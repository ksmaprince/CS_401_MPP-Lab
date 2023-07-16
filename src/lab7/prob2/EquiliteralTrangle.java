package lab7.prob2;

public class EquiliteralTrangle implements Polygon {
    double side;

    EquiliteralTrangle(double side){
        this.side=side;
    }

    @Override
    public double[] getLength() {
        return new double[]{side, side, side};
    }
}
