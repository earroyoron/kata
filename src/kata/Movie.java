package kata;

/**
 * Esta clase representa películas
 *
 */
public class Movie {
	Price myPrice;
	
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private String _title;
	private int _priceCode;

	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode(priceCode);
	}

	public void setPriceCode(Price _price) {
		myPrice = _price;
	}
	
	public int getPriceCode() {
		return _priceCode;
	}

	public void setPriceCode(int aPrice) {
		switch (aPrice) {
		case Movie.REGULAR:
			myPrice = new RegularPrice();
			break;
		case Movie.NEW_RELEASE:
			myPrice = new NewReleasePrice();
			break;
		case Movie.CHILDRENS:
			myPrice = new ChildrensPrice();
			break;
		}
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
		return myPrice.getPrice(daysRented);
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
		
		return (myPrice instanceof NewReleasePrice)
				&& rental.getDaysRented() > 1;
	}

	
}
