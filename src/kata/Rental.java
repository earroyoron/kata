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
		return _movie.getCharge(getDaysRented());
	}

	/**
	 * Get frequent rental points
	 * @param frequentRenterPoints
	 * @return
	 */
	public int getFrequentRentalPoints() {
		return _movie.getFrequentRentalPoints(this);
	}


	String showFiguresForRental(String result) {
		result += "\t" + getMovie().getTitle() + "\t"
				+ String.valueOf(getCharge()) + "\n";
		return result;
	}
}