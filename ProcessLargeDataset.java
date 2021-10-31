//Jared Truitt
//CIS-315
//June 28, 2021
//LargeDataset

import java.io.*;
import java.net.*;
import java.util.*;
public class ProcessLargeDataset {
    public static void main(String[] args){
        try{
            URL urlObj = new URL("http://liveexample.pearsoncmg.com/data/Salary.txt");
            InputStream in = urlObj.openStream();
            Scanner scannerobj = new Scanner(in);
            double associate = 0;
            double full = 0;
            double assistant = 0;

            double associateCount = 0;
            double fullCount = 0;
            double assistantCount = 0;
            double allCount = 0;

            while(scannerobj.hasNext()){
                String temp[] = scannerobj.nextLine().split(" ");
                if(temp[2].equals("associate")){
                    associate+=Float.parseFloat(temp[3]);
                    associateCount++;
                }
                else if(temp[2].equals("full")){
                    full+=Float.parseFloat(temp[3]);
                    fullCount++;
                }
                else if(temp[2].equals("assistant")){
                    assistant+=Float.parseFloat(temp[3]);
                    assistantCount++;
                }
            }
            double all = associate + full + assistant;
            allCount = associateCount + fullCount + assistantCount;

            System.out.printf("Total salary for assistant professors is $%.2f\n", assistant);
            System.out.printf("Total salary for associate professors is $%.2f\n", associate);
            System.out.printf("Total salary for full professors is $%.2f\n", full);
            System.out.printf("Total salary for all professors is $%.2f \n \n", all);

            System.out.printf("Average salary for assistant professors is $%.2f\n", assistant/assistantCount);
            System.out.printf("Average salary for associate professors is $%.2f\n", associate/associateCount);
            System.out.printf("Average salary for full professors is $%.2f\n", full/fullCount);
            System.out.printf("Average salary for all professors is $%.2f\n", all/allCount);
            scannerobj.close();
        }catch(Exception e){
            System.out.println("URL is not working check once");
        }
    }
}

