
public class SavingsAccountTest 
{

	public static void main(String[] args)
	{
		SavingsAccount saver1 = new SavingsAccount(2000.00);
		SavingsAccount saver2 = new SavingsAccount(3000.00);
		
		SavingsAccount.modifyInterestRate(.04);
		
		System.out.printf("%-10s %-20s %-20s%n", "Month:", "Balance of saver1:", "Balance of saver2:");
		
		for(int i = 1; i <= 12; i++)
		{
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			
			System.out.printf("%-10s %-20.2f %-20.2f%n", i, saver1.getSavingsBalance(), saver2.getSavingsBalance());
		}
		
		SavingsAccount.modifyInterestRate(.05);
		
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		
		System.out.printf("Balance of saver1: %.2f%n", saver1.getSavingsBalance());
		System.out.printf("Balance of saver2: %.2f%n", saver2.getSavingsBalance());
	}

}
