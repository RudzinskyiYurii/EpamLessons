package com.lesson5;

import java.util.Enumeration;
import java.util.Vector;

class Customer {
	private String _name;
	private Vector _rentals = new Vector();

	public Customer(String name) {
		_name = name;
	}

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasMoreElements()) {
			//double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement();
			// determine amounts for each line
			/*thisAmount = each.getCharge();*/
			// add frequent renter points

			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";

		}

		totalAmount = getTotalCharge(rentals);
		frequentRenterPoints = getTotalFrequentRenterPoints(rentals);
		// add footer lines
		result += "Amount owed is " + String.valueOf(getTotalCharge(rentals)) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints(rentals)) + " frequent renter points";
		return result;
	}

	private int getTotalFrequentRenterPoints(Enumeration rentals) {
		int frequentRenterPoints = 0;
		while (rentals.hasMoreElements()){
			Rental each = (Rental) rentals.nextElement();
		frequentRenterPoints += each.getFrequentRenterPoints();

		}
		return frequentRenterPoints;
	}

	private double getTotalCharge(Enumeration rentals) {
		double totalAmount = 0;
		while (rentals.hasMoreElements()) {
			Rental each = (Rental) rentals.nextElement();
			totalAmount += each.getCharge();
		}
		return totalAmount;
	}





	/*refactoring methods*/
	private int getFrequentRenterPoints(int frequentRenterPoints, Rental each) {
		frequentRenterPoints++;
		// add bonus for a two day new release rental
		if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
            frequentRenterPoints++;
		return frequentRenterPoints;
	}

	private double amountFor(double result, Rental inputRental) {
		result = inputRental.getCharge();
		return result;
	}


}