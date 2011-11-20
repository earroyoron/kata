package kata;

public final class NewReleasePrice extends Price {

	@Override
	public double getPrice(int daysRented) {
		return daysRented * 3;
	}

}
