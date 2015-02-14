package ToAnalyze;

/*
 * @author Haider Khan 
 * 
 * Class: CSC 202 - Data Structures
 * Description: Unit Tests for the 
 * 				classes Transaction 
 * 				and Process Transactions	
 * Pledge: "I pledge that I have acted honorably" - Haider Khan
 */

public class TransactionTests {
	
	/**** TEST CASES FOR TRANSACTION AND PROCESSTRANSACTIONS CLASSES ****/
	
	// Transaction Class
	
	public TransactionTests() {
		
	}
	
	public Transaction testTransactionConstructor() {
		String sampleString = "Sample";
		Transaction transaction = new Transaction(sampleString, 0, 0);
		
		System.out.println(transaction.toString());
		System.out.println(transaction.toCD());
		System.out.println("Total Cost: " + transaction.totalCost());
		System.out.println(transaction.isLegal());
		
		return transaction;
	}
	
	// Get the toString() of a example transaction object
	public String getTransactionString() {
		
		Transaction transaction = new Transaction(null, 0, 0);
		
		return transaction.toString();
	}
	
	// Get the legal value of an example transaction object
	public boolean getLegal() {
		
		Transaction transaction = new Transaction(null, 0, 0);
		
		return transaction.isLegal();
	}
	
	// Access the description variable directly 
	public String getDescription() {
		
		Transaction transaction = new Transaction("Description", 0, 0);
		
		return transaction.description;
	}
	
	public double getCost() {
		
		Transaction transaction = new Transaction("Description", 40.5, 1);
		
		return transaction.cost;
	}
	
	public int getNumber() {
		
		Transaction transaction = new Transaction("Description", 0, 10);
		
		return transaction.number;
	}
	
	public double getTax() {
		
		Transaction transaction = new Transaction("Description", 20.4, 2);
		
		return transaction.tax(0.15);
	}

	public void testLegalTransactions() {
		int size = 10;
		Transaction[] transactions = new Transaction[size];

		for (int i = 0; i < transactions.length; i++) {
			transactions[i] = new Transaction("Sample Transaction", 10.5, 5);
		}	

		boolean isLegal = ProcessTransactions.legalTransactions(transactions);
		
	}
	
	public void testSubtotalAsTransactions() {
		int size = 10;
		Transaction[] transactions = new Transaction[size];

		for (int i = 0; i < transactions.length; i++) {
			transactions[i] = new Transaction("Sample Transaction", 10.5, 5);
		}	
		
		ProcessTransactions.subtotalAsTransactions(transactions);
	}
	
	public void testTaxAsTransactions() {
		int size = 10;
		Transaction[] transactions = new Transaction[size];
		
		double tax = 0.15;

		for (int i = 0; i < transactions.length; i++) {
			transactions[i] = new Transaction("Sample Transaction", 10.5, 5);
		}	
		
		ProcessTransactions.taxAsTransactions(transactions, tax);
	}
	
	public void testTotalAsTransactions() {
		int size = 10;
		Transaction[] transactions = new Transaction[size];
		
		double tax = 0.17;

		for (int i = 0; i < transactions.length; i++) {
			transactions[i] = new Transaction("Sample Transaction", 10.5, 5);
		}	
		
		ProcessTransactions.totalAsTransactions(transactions, tax);
	}
	
	public void testRetrieveStringVersion() {
		int size = 10;
		Transaction[] transactions = new Transaction[size];

		for (int i = 0; i < transactions.length; i++) {
			transactions[i] = new Transaction("Sample Transaction", 10.5, 5);
		}	
		
		ProcessTransactions.retrieveStringVersion(transactions);
	}
	
	public void testPrintSummary() {
		int size = 10;
		Transaction[] transactions = new Transaction[size];

		for (int i = 0; i < transactions.length; i++) {
			transactions[i] = new Transaction("Sample Transaction", 10.5, 5);
		}	
		
		ProcessTransactions.printSummary(transactions);
	}
	
	public void testCommaDelimited() {
		int size = 10;
		Transaction[] transactions = new Transaction[size];

		for (int i = 0; i < transactions.length; i++) {
			transactions[i] = new Transaction("Sample Transaction", 10.5, 5);
		}	
		
		ProcessTransactions.commaDelimited(transactions);
	}
	
	public void testRandomlyReorder() {
		int size = 10;
		Transaction[] transactions = new Transaction[size];

		for (int i = 0; i < transactions.length; i++) {
			transactions[i] = new Transaction("Sample Transaction", 10.5, 5);
		}	
		
		ProcessTransactions.randomlyReorder(transactions);
	}
	
	public void testGetUniqueMembers() {
		int size = 10;
		Transaction[] transactions = new Transaction[size];

		for (int i = 0; i < transactions.length; i++) {
			transactions[i] = new Transaction("Sample Transaction", 10.5, 5);
		}	
		
		ProcessTransactions.getUniqueMembers(transactions);
	}
	

}
