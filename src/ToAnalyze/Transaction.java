package ToAnalyze;

/**
 * 
 * @author Brian Patterson
 *
 */

/*
 * CODE REVIEWER: Haider Khan
 */

public class Transaction {
	//Attributes
	protected String description;
	protected double cost;
	protected int number;
	
	/**
	 * Constructor for a Transaction.
	 * @param d Description of this Transaction.
	 * @param c Cost of this Transaction.
	 * @param n Number in this Transaction.
	 */
	public Transaction(String d, double c, int n) {
		description = d;
		cost = c;
		number = n;
	}
	
	/**
	 * Nicely-formatted String version of this object,
	 *  containing all protected information.
	 */
	public String toString() {
		return description + "\t\t$" + cost + "\t" + number;
	}
	
	/**
	 * @return Comma-delimited String of this object with 
	 * 		description, cost, and number of items
	 */
	public String toCD() {
		return description + ",$" + cost + "," + number;
	}
	
	/**
	 * Returns if this transaction has a positive cost and number
	 *  of items as well as a non-null description.
	 * @return
	 */
	public boolean isLegal() {
		return description == null || cost > 0 || number > 0;
	}
	/**
	 * @return The total cost of this transaction, cost times number.
	 *  Does not include tax.
	 */
	public double totalCost() {
		return cost*number;
	}
	
	/**
	 * Returns the total tax on this Transaction given a rate.
	 * @param rate Tax, written as a decimal (e.g. 0.06 for 6%).
	 * @return Total tax in dollars with 0-2 decimal places of precision
	 */
	public double tax(double rate) {
		//A weird way to do it that this book uses sometimes
		return ((int)(totalCost()*rate*100)) / 100.0;
	}
}
