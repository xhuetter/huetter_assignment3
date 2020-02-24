import java.security.SecureRandom;
import java.util.Scanner;
import java.lang.Math;

public class CAI4 
{
	private SecureRandom random = new SecureRandom();
	private int number1;
	private int number2;
	private int studentAnswer;
	private Scanner input = new Scanner(System.in);
	private boolean finished;
	private int difficulty;
	
	// Take in the desired difficulty level from the user.
	public void readDifficulty()
	{
		while (true)
		{
			System.out.printf("Choose a difficulty level from 1 to 4. ");
			setDifficulty(input.nextInt());
			if (difficulty < 1 || difficulty > 4)
			{
				System.out.println("Please input a valid difficulty level. ");
			}
			else 
			{
				break;
			}
		}
	}
	
	public void setDifficulty(int difficulty)
	{
		this.difficulty = difficulty;
	}
	
	public int getDifficulty()
	{
		return difficulty;
	}
	
	// Generate the question parameters based on the
	// level of difficulty the user selected.
	public void generateQuestionArgument(int difficulty)
	{
		if (difficulty == 1)
		{
			number1 = Math.abs(random.nextInt() % 10);
			number2 = Math.abs(random.nextInt() % 10);
		}
		else if (difficulty == 2)
		{
			number1 = Math.abs(random.nextInt() % 100);
			number2 = Math.abs(random.nextInt() % 100);
		}
		else if (difficulty == 3)
		{
			number1 = Math.abs(random.nextInt() % 1000);
			number2 = Math.abs(random.nextInt() % 1000);
		}
		else if (difficulty == 4)
		{
			number1 = Math.abs(random.nextInt() % 10000);
			number2 = Math.abs(random.nextInt() % 10000);
		}
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
	
	// Print out a positive response randomly from four options.
	public void displayCorrectResponse()
	{
		int promptNum = Math.abs(random.nextInt() % 4) + 1;
		switch (promptNum) 
		{
		case 1 :	
			System.out.println("Very good!");
			break;
		case 2 :	
			System.out.println("Excellent!");
			break;
		case 3 :	
			System.out.println("Nice work!");
			break;
		case 4 :	
			System.out.println("Keep up the good work!");
			break;

		}
	}
	
	// Print out a negative response randomly from four options.
	public void displayIncorrectResponse()
	{
		int promptNum = Math.abs(random.nextInt() % 4) + 1;
		switch (promptNum) 
		{
		case 1 :	
			System.out.println("No. Please try again.");
			break;
		case 2 :	
			System.out.println("Wrong. Try once more.");
			break;
		case 3 :	
			System.out.println("Don't give up!");
			break;
		case 4 :	
			System.out.println("No. Keep trying.");
			break;
		}
	}
	
	// Print out the student score and an extra message 
	// pertaining to their success.
	public void displayCompletionMessage(int correctAnswerCount)
	{
		double percentGrade = (double) correctAnswerCount / 10.0;
		System.out.printf("Score: %d%%. ", (int) Math.round(percentGrade * 100));
		if (percentGrade < .75)
		{
			System.out.println("Please ask your teacher for extra help.");
		}
		else
		{
			System.out.println("Congratulations, you are ready to go to the next level!");
		}
	}
	
	// Ask the user whether or not they want to solve a new set
	// of problems and save the answer.
	public void askForContinue()
	{
		String response;
		
		while(true) 
		{
			System.out.printf("Would you like to solve a new set of problems? (Y/N): ");
			response = input.next();
			if (response.equalsIgnoreCase("Y"))
			{
				finished = false;
				break;
			}
			else if (response.equalsIgnoreCase("N"))
			{
				finished = true;
				break;
			}
			System.out.println("Invalid response. Type Y for yes and N for no.");
		}
		
	}
	
	// Create a quiz function that contains the program logic.
	public void quiz()
	{
		
		while(finished == false)
		{
			int i;
			int correctAnswerCount = 0;
			
			readDifficulty();
			for (i = 0; i < 10; i++)
			{
				generateQuestionArgument(getDifficulty());
				askQuestion();
				readResponse();
				if(isAnswerCorrect() == false)
				{
					displayIncorrectResponse();
				}
				else
				{
					displayCorrectResponse();
					correctAnswerCount++;
				}
			}
			displayCompletionMessage(correctAnswerCount);
			askForContinue();
		}
		
	}
	
	// Create a main function that tests the program by calling the quiz method.
	public static void main(String[] args)
	{
		CAI4 test = new CAI4();
		test.quiz();
	}
}
