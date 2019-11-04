package Easy;
// Author: Eduard Le Roux

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;
 
public class myFile {
    /**
     * calculates the maximum value in the array
     * @param array takes in an integer array as an argument
     * @return returns the maximum value in the array
     */
    public static int max(int[] array) {
        int max;
        max = array[0]; 
        for (int i = 0; i < array.length; i++) { 
            if (array[i] > max) { 
                max = array[i];
            }
        } 
        return max; 
    }
    /**
     * calculates the minimum value in the array
     * @param array rakes in an integer array as an argument
     * @return returns the minimum values in the array
     */
     
    public static int min(int[] array) {
        int min; 
        min = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min; 
    }
    /**
     * Casts a String array to Integer
     * @param array takes in a string array as an argument 
     * @return returns the string array as a int array.
     */
    public static int[] cast (String[] array) { 
        int [] tempArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            tempArray[i] = Integer.parseInt(array[i]);
        }
        return tempArray;
    }
    /**
     * Calculates the average of a integer array
     * @param array takes in a integer array as an argument 
     * @return returns the average of the integers in the array
     */
    public static double avg(int[] array) { 
        double avg;
        double sum = 0.0;
        double len = array.length;
        for (int i = 0; i < array.length; i++) { 
            sum += array[i];
        }
        avg = sum / len;
        avg = Math.round(avg);
        return avg;
         
    }
    /**
     * Calculates the x'th percentile for a given integer array
     * 
     * 
     * @param array takes in a integer array
     * @param x takes the percentile that you want to calculate.
     * @return return's the percentile, rounded
     */
    public static double px(int[] array, double x) {
        double number = (x / 100.0) * array.length;
        return  Math.round(number);
    }
    /**
     * Calculates the sum of the array
     * @param array takes in an integer array 
     * @return returns the sum of the array.
     */
    public static int sum(int[] array) { 
        int sum = 0; 
        for (int i = 0; i < array.length; i++) { 
            sum += array[i];
        }
        return sum;
    }
     
    /**
     * 
     * @param filepath takes in a filepath and splits the text into an array
     */
     
    public static void print(int[] array) { 
        for (int i = 0; i < array.length; i ++) { 
            System.out.print(array[i]);
        }
    }
     
    /**
     * Creates a file object and a formatter object, splitting up the text into an array and then calls the 
     * respective functions in the order of the text file and writes them to an output file
     * @param filepath takes in the filepath as a parameter
     *
     */
    public static void read(String filepath) {
         
        try { 
            File file  = new File (filepath);
            Scanner fileContent = new Scanner(file);
            int count = 0;
            Formatter f = new Formatter("output.txt");
             
            while (fileContent.hasNext()) {
                     
                    String line = fileContent.next();
                    count++;
                    String[] array = new String[line.length()];
                    array = line.split(":");
                    String part1 = array[0]; 
                    String part2 = array[1];
                    String[] intArray = new String[part2.length()];
                    intArray = part2.split(",");
                    int[] newIntArray = new int[intArray.length];
                    newIntArray = cast(intArray);   
                     
                    switch (count) { 
                    case 1:
                        f.format("%s %s %s %s \r\n","The min of ", Arrays.toString(newIntArray)," is ",min(newIntArray));break;
                    case 2:
                        f.format("%s %s %s %s \r\n","The max of ", Arrays.toString(newIntArray)," is ",max(newIntArray));break;
                    case 3:
                        f.format("%s %s %s %s \r\n","The avg of ", Arrays.toString(newIntArray)," is ",avg(newIntArray));break;
                    case 4:
                        f.format("%s %s %s %s \r\n","The p90 of ", Arrays.toString(newIntArray)," is ",px(newIntArray, 90));break;
                    case 5:
                        f.format("%s %s %s %s \r\n","The sum of ", Arrays.toString(newIntArray)," is ",sum(newIntArray));break;
                    case 6:
                        f.format("%s %s %s %s \r\n","The p70 of ", Arrays.toString(newIntArray)," is ",px(newIntArray, 70));break;
                    }
            }
            f.close();
            fileContent.close();
        } catch (FileNotFoundException e) { 
            System.out.println(e.toString());
        }
    }
 
    public static void main(String[] args) { 
         
        String filePath = "input.txt"; 
        read(filePath);
        System.out.println("Please check your output file");
         
    }
 
     
 
}