package newPackage;
import java.util.Scanner;
public class numberStringSum {

	public static void main(String[] args) {
		int inputNumber;
		int input1;
		int input2;
		int input3;
		int input4;
		int input5;
		int outResult;
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("Please enter a 5 digit number: ");
		inputNumber = scnr.nextInt();
		
		input1 = inputNumber / 10000;
		input2 = (inputNumber / 1000) % 10;
		input3 = (inputNumber / 100) % 10;
		input4 = (inputNumber / 10) % 10;
		input5 = inputNumber % 10;
		outResult = input1 + input2 + input3 + input4 + input5;
		
		System.out.println("The result is: " + outResult);

	}

}
