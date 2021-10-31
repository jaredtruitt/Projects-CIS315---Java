//Jared Truitt
//CIS-315
//June 16th, 2021
//Finding the central city with coordinates
import java.util.Scanner;
public class CentralCity{
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter the number of cities: ");
		int cities = input.nextInt();
		double[][] coordinates = new double[cities][2];
		
		System.out.print("Enter the coordinates of the cities: ");
		for(int i=0; i<cities; i++){
			coordinates[i][0] = input.nextDouble();
			coordinates[i][1] = input.nextDouble();
		}

		double distance[] = new double[cities];

		//getting total distances
		for(int i=0; i<cities; i++){
			distance[i] = totalDistance(coordinates, i);
		}

		double minDist = distance[0];
		int index = 0;
		for(int i=1; i<cities; i++){
			if(distance[i] < minDist){
				minDist = distance[i];
				index = 1;
			}
		}

		//printing results

		System.out.printf("The central city is at (%.2f, %.2f).\n", coordinates[index][0], coordinates[index][1]);
		System.out.printf("The total distance from the central city to all other cities is %.2f.\n", distance[index]);

	}
	
	public static double distance(double [] c1, double [] c2){
	    double distance;
		distance = Math.sqrt(((c1[0]-c2[0])*(c1[0]-c2[0]))+((c1[1]-c2[1])*(c1[1]-c2[1])));
		return distance;
	}
	
	public static double totalDistance (double [][] cities, int i){
	    double distance = 0;

		for(int k=0; k<cities.length; k++){
			distance += distance(cities[i], cities[k]);
		}

		return distance;
	}
}
