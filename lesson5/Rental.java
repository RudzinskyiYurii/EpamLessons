package com.lesson5;

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


	//private double amountFor(double result, Rental inputRental) {
		public double getCharge() {
		/*double result = 0;
		switch (_movie.getPriceCode()) {
			case Movie.REGULAR:
				result += 2;
				if (_daysRented > 2)
					result += (_daysRented - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				result += _daysRented * 3;
				break;
			case Movie.CHILDREN:
				result += 1.5;
				if (_daysRented > 3)
					result += (_daysRented - 3) * 1.5;
				break;
		}*/
		return _movie.getCharge(_daysRented);
	}

	public int getFrequentRenterPoints() {

		// add bonus for a two day new release rental
		return _movie.getFrequentRenterPoints(_daysRented);
	}
}