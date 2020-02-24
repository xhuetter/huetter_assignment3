import java.math.BigDecimal;
import java.math.RoundingMode;

public class SavingsAccount 
{
	private static double annualInterestRate;
	private double savingsBalance;
	
	public double getSavingsBalance()
	{
		return savingsBalance;
	}
	
	// Constructor for savings account
	public SavingsAccount(double startingBalance)
	{
		savingsBalance = startingBalance;
	}
	
	// Calculate the monthly interest for the savings account
	public void calculateMonthlyInterest()
	{
		savingsBalance += savingsBalance * annualInterestRate / 12.0;
		BigDecimal roundedBalance = new BigDecimal(savingsBalance);
		roundedBalance.setScale(2, RoundingMode.HALF_UP);
		savingsBalance = roundedBalance.doubleValue();
	}
	
	// Modify the annual interest rate for all savings accounts
	public static void modifyInterestRate(double interestRate)
	{
		annualInterestRate = interestRate;
	}
	
	
}
