//Jared Truitt
//CIS-315
//June 8, 2021
//Payroll Console

import java.util.Scanner;
public class PayrollConsole{
	public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);

		//prompt for/and getting input
		System.out.print("Enter employee's name: ");
		String name = input.nextLine();
		
		System.out.print("Enter number of hours worked: ");
		double hoursWork = input.nextDouble();
		
		System.out.print("Enter hourly pay rate: ");
		double payRate = input.nextDouble();
		
		System.out.print("Enter federal tax withholding rate: ");
        double fedTax = input.nextDouble();
		
		System.out.print("Enter state tax witholding rate: ");
		double stateTax = input.nextDouble();
		
		System.out.print("\n \n");
		
		//logic calculations
		double grossPay = hoursWork * payRate;
		double fedWith = fedTax * grossPay;
		double stateWith = stateTax * grossPay;
		double totalDeduction = stateWith + fedWith;
		double netPay = grossPay - totalDeduction;
		
		//output
		System.out.print(
            "Employee's Name: " + name +
		    "\nHours Worked: " + String.format("%.2f", hoursWork) +
		    "\nPay Rate: " + String.format("%.2f", payRate) +
		    "\nGross Pay: $" + String.format("%.2f", grossPay) +
		    "\nDeductions:\n  Federal Withholding (" +
		    String.format("%.2f", (fedTax * 100)) + "%): $" + 
			String.format("%.2f", fedWith) + 
			"\n  State Withholding (" + String.format("%.2f", (stateTax * 100)) +
			"%): $" + String.format("%.2f", stateWith) +
			"\n  Total Deduction: $" + String.format("%.2f", totalDeduction) +
			"\nNet Pay: $" + String.format("%.2f", netPay)
        );
	}
}
