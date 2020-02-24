import java.security.SecureRandom;
import java.util.Scanner;
import java.lang.Math;

public class CAI1 
{
	
	private SecureRandom random = new SecureRandom();
	private int number1;
	private int number2;
	private int studentAnswer;
	private Scanner input = new Scanner(System.in);
	
	// Generate the question parameters.
	public void generateQuestion()
	{
		number1 = Math.abs(random.nextInt() % 10);
		number2 = Math.abs(random.nextInt() % 10);
	}
	
	// Ask the user a multiplication problem.
	public void askQuestion()
	{
		System.out.printf("How much is %d times %d? ", number1, number2);
	}
	
	// Take in the user's answer to a question.
	public void readResponse()
	{
		studentAnswer = input.nextInt();
	}
	
	// Check if user input matches the answer.
	public boolean isAnswerCorrect()
	{
		return studentAnswer == number1 * number2;
	}
	
	// Print out a positive response.
	public void displayCorrectResponse()
	{
		System.out.println("Very good!");
	}
	
	// Print out a negative response.
	public void displayIncorrectResponse()
	{
		System.out.println("No. Please try again. ");
	}
	
	// Create a quiz function that contains the program logic.
	public void quiz()
	{
		generateQuestion();
		askQuestion();
		readResponse();
		while(isAnswerCorrect() == false)
		{
			displayIncorrectResponse();
			askQuestion();
			readResponse();
		}
		displayCorrectResponse();
	}
	
	// Create a main function that tests the program by calling the quiz method.
	public static void main(String[] args)
	{
		CAI1 test = new CAI1();
		test.quiz();
	}

}
