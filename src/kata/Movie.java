package kata;

/**
 * Esta clase representa películas
 *
 */
public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private String _title;
	private int _priceCode;

	public Movie(String title, int priceCode) {
		_title = title;
		_priceCode = priceCode;
	}

	public int getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(int arg) {
		_priceCode = arg;
	}

	public String getTitle() {
		return _title;
	}

	/**
	 * determine charge for a rentaleach line
	 * @param rental TODO
	 * @return
	 */
	double getCharge(int daysRented) {
		double thisAmount = 0;
		switch (getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (daysRented > 2)
				thisAmount += (daysRented - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			thisAmount += daysRented * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (daysRented > 3)
				thisAmount += (daysRented - 3) * 1.5;
			break;
		}
		return thisAmount;
	}

	/**
	 * Get frequent rental points
	 * @param frequentRenterPoints
	 * @param rental TODO
	 * @return
	 */
	public int getFrequentRentalPoints(Rental rental) {
		// add frequent renter points
		// add bonus for a two day new release rental
		if (isSpecialPointsPolicy(rental)) {
			return 2;
		}
		else return 1;
	};

	boolean isSpecialPointsPolicy(Rental rental) {
		return (getPriceCode() == Movie.NEW_RELEASE)
				&& rental.getDaysRented() > 1;
	}

	
}
