import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class Mergesort {

	public static void main(String[] args) {
		String fileName = args[0];
		
		String outputFileName = "output.txt";
		try {
			// read in input file
			Scanner scanner = new Scanner(new File(fileName));
			List<Integer> list = new ArrayList<Integer>();
			while (scanner.hasNextInt()) {
				list.add(scanner.nextInt());
			}
			scanner.close();
			int n = list.size();
			int[] arr = new int[n];
			int ind = 0;
			for (int num : list) {
				arr[ind] = num;
				ind++;
			}
			
			// sort the array
			int[] sortedArr = mergeSort(arr);
			
			// write to output file
			File file = new File(outputFileName);
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int i = 0; i < n; i++) {
				bufferedWriter.write(sortedArr[i] + " ");
			}
			bufferedWriter.close();
			
		} catch (FileNotFoundException e){
			System.out.println(fileName + " file not found.");
		} catch (IOException e1) {
			System.out.println("Error writing to file " + outputFileName);
			e1.printStackTrace();
		}
		
	}
	
	public static int[] mergeSort(int[] arr) {
		int n = arr.length;
		
		// first divide the array into two subarrays
		// if n is odd, n/2 casts down to an int
		// and then one of the subarrays will be odd
		int[] left = Arrays.copyOfRange(arr, 0, n/2);
		int[] right = Arrays.copyOfRange(arr,  n/2, n);
		
		// recursively call mergeSort on subarrays 
		if (left.length > 1) left = mergeSort(left);
		if (right.length > 1) right = mergeSort(right);
		
		// merge the 2 subarrays
		int[] result = merge(left, right);
		return result;
	}
	
	private static int[] merge(int[] arr1, int[] arr2) {
		
		int n = arr1.length + arr2.length;
		int[] output = new int[n];
		
		int i = 0; // points to index in arr1
		int j = 0; // points to index in arr2
		
		for (int k = 0; k < n; k++) {
			if (i < arr1.length && j < arr2.length) {
				if (arr1[i] <= arr2[j]) {
					output[k] = arr1[i];
					i++;
				}
				else { // (arr1[i] > arr2[j])
					output[k] = arr2[j];
					j++;
				}
			}
			else if (i == arr1.length && j != arr2.length) {
				output[k] = arr2[j];
				j++;
			}
			else { // (i != arr1.length && j == arr2.length)
				output[k] = arr1[i];
				i++;
			}
		}
		return output;
	}
  
}
