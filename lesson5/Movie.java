package com.lesson5;

public class Movie {
	public static final int CHILDREN = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	private String _title;
	private int _priceCode;

	private Price _price;

	public Movie(String title, int priceCode) {
		_title = title;
		//_priceCode = priceCode;
        setPriceCode(priceCode);


	}

	public int getPriceCode() {
		return _price.getPriceCode();
	}

	public void setPriceCode(int arg) {
	    switch (arg){
            case Movie.REGULAR:
                _price = new RegularPrice();
                break;
            case Movie.CHILDREN:
                _price = new ChildrensPrice();
                break;
            case Movie.NEW_RELEASE:
                _price = new NewReleasePrice();
                break;
                default:
                    throw new IllegalArgumentException("Incorrect price code!");
        }
		_priceCode = arg;
	}

	public String getTitle() {
		return _title;
	}

	public double getCharge (int days){
		/*double result = 0;
		switch (getPriceCode()) {
			case Movie.REGULAR:
				result += 2;
				if (days > 2)
					result += (days - 2) * 1.5;
				break;
			case Movie.NEW_RELEASE:
				result += days * 3;
				break;
			case Movie.CHILDREN:
				result += 1.5;
				if (days > 3)
					result += (days - 3) * 1.5;
				break;
		}
		return result;*/

		return _price.getCharge(days);
	}


    public int getFrequentRenterPoints(int daysRented) {

        // add bonus for a two day new release rental
        return _price.getFrequentRenterPoints(daysRented);
    }
}