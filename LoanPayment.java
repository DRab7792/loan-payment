import java.util.Scanner;

/**
 * This class will be able to calculate the monthly payment
 * as well as the total payment based on three values entered by the user:
 * the loan value, the apr, and the total amount of months.
 * @author Dan Rabinowitz
 */

public class loanPayment {

	/**
	 * This method will read the input, and check it to make sure it is a double,
	 * and it is positive. The method will then return the input number. 
	 * @param inputName
	 * @return num
	 */
	
	public double readInput(String inputName){
		boolean checkInput = false;
		double num = 0;
		while(checkInput==false){
			System.out.println("Enter a positive number for the "+inputName+": ");
			Scanner input = new Scanner(System.in);
			if (input.hasNextDouble()){
				num = input.nextDouble();
				if (num >= 0){
					checkInput = true;
				}else{
					System.out.println("The number you entered is not positive.");
				}
			}else{
				System.out.println("Please enter a number.");
			}
		}
		return num;
	}
	
	/**
	 * The main method will start by calling the readInput method three times, once for each number
	 * required by the user. Then the method will convert the number of months to an integer from a double.
	 * Third, the method will calculate the monthly interest factor, and the monthly payment based on the 
	 * numbers the user entered. Finally, the method will display the results. 
	 */
	
	public static void main(String[] args) {
		loanPayment loan = new loanPayment();
		double loanValue = loan.readInput("loan value");
		double apr = loan.readInput("APR");
		double months = loan.readInput("number of months");
		int numMonths = (int)months;
		double monthlyInterestFactor = apr/1200;
		double monthlyPayment = loanValue*monthlyInterestFactor / (1 - 1/Math.pow(1 + monthlyInterestFactor, numMonths)); 
		monthlyPayment = Math.round(100*monthlyPayment)/100.0;
		double totalPayment = monthlyPayment * numMonths;
		System.out.println("The monthly payment is $"+monthlyPayment+" and the total payment is $"+totalPayment+".\n");
	}

}
