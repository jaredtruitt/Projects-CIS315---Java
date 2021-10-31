//Jared Truitt
//CIS-315
//June 4, 2021 
//Find the area of a triangle

import java.util.Scanner;
public class AreaOfATriangle{
	public static void main(String[] args) {
		double x1, x2, y1, y2, x3, y3, d, s, a; //declare variables
		double side1, side2, side3;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter three points for a triangle: ");
		
		//user input
		x1 = input.nextDouble();
		y1 = input.nextDouble();
		x2 = input.nextDouble();
		y2 = input.nextDouble();
		x3 = input.nextDouble();
		y3 = input.nextDouble();
	
		//logic to find area
		side1 = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
		side2 = Math.sqrt((x3 - x2) * (x3 - x2) + (y3 - y2) * (y3 - y2));
		side3 = Math.sqrt((x3 - x1) * (x3 - x1) + (y3 - y1) * (y3 - y1));
		
		s = (side1 + side2 + side3) / 2.0;
		a = Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
		
		//print out area
		System.out.println("The area of the triangle is " + String.format("%.2f",a) + ".");
	}
}
