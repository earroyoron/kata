package kata;

/**
 * Esta clase representa películas
 *
 */
public class Movie {
	private Price myPrice;	
	private String _title;

	public Movie(String title, Price priceCode) {
		_title = title;
		myPrice = priceCode;
	}

	public void setPriceCode(Price _price) {
		myPrice = _price;
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
