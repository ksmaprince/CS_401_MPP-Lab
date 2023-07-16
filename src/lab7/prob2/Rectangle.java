package lab7.prob2;

public final class Rectangle implements Polygon {
	final private double width;
	final private double length;

	public Rectangle(double width, double length) {	
		this.width = width;
		this.length = length;
	}

	@Override
	public double[] getLength() {
		return new double[]{width, length};
	}
}
