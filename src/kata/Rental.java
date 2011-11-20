package kata;

class Rental {
	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

	/**
	 * determine charge for a rentaleach line
	 * @return
	 */
	double getCharge() {
		double thisAmount = 0;
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (getDaysRented() > 2)
				thisAmount += (getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			thisAmount += getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (getDaysRented() > 3)
				thisAmount += (getDaysRented() - 3) * 1.5;
			break;
		}
		return thisAmount;
	}

	/**
	 * Get frequent rental points
	 * @param frequentRenterPoints
	 * @return
	 */
	public int getFrequentRentalPoints() {
		// add frequent renter points
		// add bonus for a two day new release rental
		if (isSpecialPointsPolicy()) {
			return 2;
		}
		else return 1;
	}

	private boolean isSpecialPointsPolicy() {
		return (getMovie().getPriceCode() == Movie.NEW_RELEASE)
				&& getDaysRented() > 1;
	}

	String showFiguresForRental(String result) {
		result += "\t" + getMovie().getTitle() + "\t"
				+ String.valueOf(getCharge()) + "\n";
		return result;
	}
}