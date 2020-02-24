import java.security.SecureRandom;
import java.util.Scanner;
import java.lang.Math;

public class CAI5 
{
	
	private SecureRandom random = new SecureRandom();
	private double number1;
	private double number2;
	private double studentAnswer;
	private Scanner input = new Scanner(System.in);
	private boolean finished;
	private int difficulty;
	private int problemType;
	private int problem;
	
	public double getNumber1()
	{
		return number1;
	}
	
	public void setNumber1(double number1)
	{
		this.number1 = number1;
	}
	
	public double getNumber2()
	{
		return number2;
	}
	
	public void setNumber2(double number2)
	{
		this.number2 = number2;
	}
	
	public void setProblem(int problem)
	{
		this.problem = problem;
	}
	
	public int getProblem()
	{
		return problem;
	}
	
	// Take in what type of problem set the user wants to study.
	public void readProblemType()
	{
		while (true)
		{
			System.out.printf("Choose a type of problem to study. %n");
			System.out.println("1: Addition");
			System.out.println("2: Subtraction");
			System.out.println("3: Multiplication");
			System.out.println("4: Division");
			System.out.println("5: Mixed");
			setProblemType(input.nextInt());
			if (problemType < 1 || problemType > 5)
			{
				System.out.println("Please input a valid problem type. ");
			}
			else 
			{
				break;
			}
		}
	}
	
	public void setProblemType(int problemType)
	{
		this.problemType = problemType;
	}
	
	public int getProblemType()
	{
		return problemType;
	}
	
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
			number1 = (double) Math.abs(random.nextInt() % 10) * 1.0;
			number2 = (double) Math.abs(random.nextInt() % 10) * 1.0;
		}
		else if (difficulty == 2)
		{
			number1 = (double) Math.abs(random.nextInt() % 100) * 1.0;
			number2 = (double) Math.abs(random.nextInt() % 100) * 1.0;
		}
		else if (difficulty == 3)
		{
			number1 = (double) Math.abs(random.nextInt() % 1000) * 1.0;
			number2 = (double) Math.abs(random.nextInt() % 1000) * 1.0;
		}
		else if (difficulty == 4)
		{
			number1 = (double) Math.abs(random.nextInt() % 10000) * 1.0;
			number2 = (double) Math.abs(random.nextInt() % 10000) * 1.0;
		}
	}
	
	// Ask the user a problem based on what type of problem
	// set they selected.
	public void askQuestion(int problemType)
	{
		if (problemType == 5)
		{
			setProblem(Math.abs(random.nextInt() % 4) + 1);
		}
		else
		{
			setProblem(problemType);
		}
		if (getProblem() == 1)
		{
			System.out.printf("How much is %d plus %d? ", (int) number1, (int) number2);
		}
		else if (getProblem() == 2)
		{
			System.out.printf("How much is %d minus %d? ", (int) number1, (int) number2);
		}
		else if (getProblem() == 3)
		{
			System.out.printf("How much is %d times %d? ", (int) number1, (int) number2);
		}
		else if (getProblem() == 4)
		{
			if (getNumber2() == 0)
			{
				double temp = getNumber1();
				setNumber2(getNumber1());
				setNumber1(temp);
			}
			System.out.printf("How much is %d divided by %d? Round to the nearest hundreth. ", (int) number1, (int) number2);
		}
	}
	
	// Take in the user's answer to a question.
	public void readResponse()
	{
		studentAnswer = input.nextDouble();
	}
	
	// Check if user input matches the answer.
	public boolean isAnswerCorrect(int problem)
	{
		if (getProblem() == 1)
		{
			return Math.abs(studentAnswer - (number1 + number2)) < .01;
		}
		else if (getProblem() == 2)
		{
			return Math.abs(studentAnswer - (number1 - number2)) < .01;
		}
		else if (getProblem() == 3)
		{
			return Math.abs(studentAnswer - (number1 * number2)) < .01;
		}
		else if (getProblem() == 4)
		{
			return Math.abs(studentAnswer - (number1 / number2) - .005) < .01;
		}
		return true;
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
			readProblemType();
			for (i = 0; i < 10; i++)
			{
				generateQuestionArgument(getDifficulty());
				askQuestion(getProblemType());
				readResponse();
				if(isAnswerCorrect(getProblem()) == false)
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
		CAI5 test = new CAI5();
		test.quiz();
	}
	
}
