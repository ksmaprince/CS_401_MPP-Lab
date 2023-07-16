package lab3.prob3;

public class Admin {
	/*public static double computeTotalRent(Object[] properties) {
		double totalRent = 0;
		for (Object o : properties) {
			if (o instanceof House) {
				House h = (House) o;
				totalRent += h.computeRent();
			}
			else if (o instanceof Condo) {
				Condo h = (Condo) o;
				totalRent += h.computeRent();
			}
			else if (o instanceof Trailer) {
				Trailer h = (Trailer) o;
				totalRent += h.computeRent();
			}	
		}
		return totalRent;
	}*/

	public static double computeTotalRent(Property[] properties) {
		double totalRent = 0;
		for (Property property : properties) {
			totalRent +=property.computeRent();
		}
		return totalRent;
	}
}