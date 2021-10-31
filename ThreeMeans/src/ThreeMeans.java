//Jared Truitt
//CIS-315
//Jun 2, 2021
//Finding three means with user input

import java.util.Scanner; //library for input scanner
public class ThreeMeans{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Enter two positive floating-point numbers: ");
        //getting user input
        int a = scan.nextInt();
        int b = scan.nextInt();
        
        double modulo = a%b;

        System.out.print(modulo);

    }
}