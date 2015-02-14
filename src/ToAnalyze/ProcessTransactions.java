package ToAnalyze;

import java.util.Random;

/**
 * A utility class with a variety of static methods for processing
 *  Transactions.  See the Transaction class for some details.
 * @author Brian Patterson
 * DO NOT ALTER THIS FILE.
 */

public class ProcessTransactions {
	/**
	 * Analyzes the list of transactions and certifies if the array is legal.
	 *  It is legal as long as there are no null elements and each transaction
	 *  itself is legal (as per the definition in the Transaction class).
	 * @param transactions Array of Transaction.
	 * @return True iff the array of Transaction is legal.
	 */
	public static boolean legalTransactions(Transaction[] transactions) {
		boolean foundInvalid = false;
		for (int i = 0; i < transactions.length && !foundInvalid; i++) {
			if (transactions[i] != null && !transactions[i].isLegal())
				foundInvalid = true;
		}
		return !foundInvalid;
	}

	/**
	 * If legal transactions are provided, finds the sum of the costs
	 *  of the transactions.
	 * @param transactions Array of Transaction.
	 * @return Total cost of all transactions in the array.  -1 if 
	 * 		the array is not a legal array of transactions
	 */
	public static double subtotalAsTransactions(Transaction[] transactions) {
		if (!legalTransactions(transactions))
			return -1;
		double sum = 0;
		for (int i = 0; i < transactions.length; i++) {
			if(transactions[i] != null)
				sum += transactions[i].totalCost();
		}
		return sum;
	}

	/**
	 * If a legal list of transactions is provided, returns the total
	 *  tax on the transactions.
	 * @param transactions Array of Transaction.
	 * @param tax Tax, written as a decimal (e.g. 0.06 for 6%).
	 * @return Total tax on the transactions provided, -1 if not legal.
	 */
	public static double taxAsTransactions(Transaction[] transactions,
			double tax) {
		if (!legalTransactions(transactions))
			return -1;
		return subtotalAsTransactions(transactions) * tax;
	}

	/**
	 * Total cost for the input Transactions.
	 * @param transactions Array of Transaction to evaluate.
	 * @param tax Tax, written as a decimal (e.g. 0.06 for 6%).
	 * @return Total plus tax on the transactions provided, -1 if not legal.
	 */
	public static double totalAsTransactions(Transaction[] transactions,
			double tax) {
		if (!legalTransactions(transactions))
			return -1;
		double subtotal = subtotalAsTransactions(transactions);
		return subtotal * (1 + tax);
	}

	/**
	 * Generates a nice String representing the list of Transaction.  Uses the
	 *  toString method of the Transaction class.
	 * @param transactions Array of Transactions to put into String form.
	 * @return Header of Descr, Cost, and Num followed by the description, cost, 
	 *  and number in each component transaction.  Relies on Transaction class
	 *  for formatting.
	 */
	public static String retrieveStringVersion(Transaction[] transactions) {
		String rtn = "Descr\t\tCost\tNum\n";
		for (int i = 0; i < transactions.length; i++) {
			if(transactions[i] != null)
				rtn += transactions[i].toString() + "\n";
		}
		return rtn;
	}
	/**
	 * Prints the list of Transaction.  Uses the
	 *  retrieveStringVersion method.
	 * @param transactions Array of Transactions to put into String form.
	 */
	public static void printSummary(Transaction[] transactions) {
		System.out.println(retrieveStringVersion(transactions));
	}
	
	
	/**
	 * Generates a comma-delimited version of the list of Transaction.  Uses the
	 *  toCD() method of the Transaction class.
	 * @param transactions Array of Transactions to put into CD form.
	 * @return Comma-delimited, headerless listing of the Transactions.
	 *  Relies on Transaction class for formatting.
	 */
	public static String commaDelimited(Transaction[] transactions) {
		String rtn = "";
		for (int i = 0; i < transactions.length; i++) {
			if(transactions[i] != null)
				rtn += transactions[i].toCD() + "\n";
		}
		return rtn;
	}
	/**
	 * Randomly reorders the input array of transactions.
	 * @param transactions Array of Transaction to randomly reorder.
	 */
	public static void randomlyReorder(Transaction[] transactions) {
		//# swaps here is arbitrary but, for analysis, assume it is this value
		final int TARGET_SWAPS = transactions.length;
		int numSwaps = 0;
		Random gen = new Random();
		int start = 0;
		while(numSwaps < TARGET_SWAPS) {
			if(start >= transactions.length)
				start = 0;
			if(transactions[start] != null) {
				int end = gen.nextInt(transactions.length);
				if(transactions[end] != null) {
					Transaction temp = transactions[start];
					transactions[start] = transactions[end];
					transactions[end] = temp;
					numSwaps++; //Getting closer to done!
				}
			}
		}
	}
	/**
	 * Finds and generates as a String array the unique names used in the
	 *  input array of Transaction.
	 * @param transactions Array of Transactions to plumb for names.
	 * @return An array of Strings, each element of which is a description
	 *  present in the input array.  The descriptions do not repeat and
	 *  the array is exactly the right length to store these names.
	 */
	public static String[] getUniqueMembers(Transaction[] transactions) {
		String[] baseUniques = new String[transactions.length];
		//1. Find the unique descriptions (track the count)
		int index = 0;
		for(int i = 0; i < transactions.length; i++) {
			if(transactions[i] != null) {
				boolean found = false;
				for(int j = 0; j < index && !found; j++)
					//Completely violates encapsulation, yay
					found = transactions[i].description.equals(baseUniques[j]);
				if(!found) {
					baseUniques[index] = transactions[i].description;
					index++;
				}
			}
		}
		
		//2. Shrink the array to be returned
		String[] finalUniques = new String[index];
		for(int i = 0; i < finalUniques.length; i++)
			finalUniques[i] = baseUniques[i];
		
		return finalUniques;
	}
	
	//This method simply serves as an example of some ways to use the methods above
	// You do not need to test or analyze it
	public static void main(String[] args) {
		Transaction[] testArr = new Transaction[100];

		Random gen = new Random(0);

		testArr[0] = new Transaction("Ice", 0.99, 10);
		for (int i = 1; i < 10; i++) {
			switch (gen.nextInt(3)) {
			case 0:
				testArr[i] = new Transaction("Coffee", 3.99,
						gen.nextInt(i + 1) + 1);
				break;
			case 1:
				testArr[i] = new Transaction("Ham", 10.99,
						gen.nextInt(i + 1) + 1);
				break;
			case 2:
				testArr[i] = new Transaction("Orange", 1.99,
						gen.nextInt(i + 1) + 1);
				break;
			}
		}
		System.out.printf("Subtotal: $%.2f\n", subtotalAsTransactions(testArr));
		System.out.printf("Tax: $%.2f\n\n", taxAsTransactions(testArr, 0.1));
		// Note the change in tax rate!
		System.out.printf("Total: $%.2f\n", totalAsTransactions(testArr, 0.06));
		System.out
				.println("----------------------------------------------------------");
		System.out.println("retrieveStringVersion:");
		System.out.println(retrieveStringVersion(testArr));
		System.out.println("printSummary:");
		printSummary(testArr);
		System.out
				.println("----------------------------------------------------------");
		System.out.println("commaDelimited:");
		System.out.println(commaDelimited(testArr));
		System.out
				.println("----------------------------------------------------------");
		randomlyReorder(testArr); // Does not print anything!
		System.out
				.println("Your results may differ for this last bit: (depends on how you randomly reorder)");
		printSummary(testArr);
		System.out
				.println("----------------------------------------------------------");
		String[] members = getUniqueMembers(testArr);
		System.out.print("Unique transaction descriptions: ");
		for (int i = 0; i < members.length; i++)
			if (i < members.length - 1)
				System.out.print(members[i] + ",");
			else
				System.out.print(members[i]);
		System.out.println();

	}
}
