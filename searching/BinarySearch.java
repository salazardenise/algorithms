import java.util.Scanner;
import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class BinarySearch {

	public static void main(String[] args) {
		
		// get fileName and key
		String fileName = args[0];
		int key = Integer.parseInt(args[1]);
		
		String outputFileName = "output.txt";
		try {
			// read in input file
			Scanner scanner = new Scanner(new File(fileName));
			List<Integer> list = new ArrayList<Integer>();
			while (scanner.hasNextInt()) {
				list.add(scanner.nextInt());
			}
			scanner.close();
			
			// check that list is in ascending order
			if (isInAscendingOrder(list) == false) {
				System.out.println("ERROR: input must be in ascending order.");
				return;
			}
			
			// determine the lower and upper bound index of key in list
			int[] inds = binarySearch(list, key);
			
			// write to output file
			File file = new File(outputFileName);
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(Integer.toString(inds[0]));
			bufferedWriter.newLine();
			bufferedWriter.write(Integer.toString(inds[1]));
			bufferedWriter.close();
			
		} catch (FileNotFoundException e){
			System.out.println("ERROR: " + fileName + " file not found.");
		} catch (IOException e1) {
			System.out.println("ERROR: could not write to file " + outputFileName +".");
			e1.printStackTrace();
		}

	}
	
	public static boolean isInAscendingOrder(List<Integer> list) {
		for (int i = 0; i < list.size()-1; i++) {
			if (list.get(i) > list.get(i+1)) return false;
		}
		return true;
	}
	
	public static int[] binarySearch(List<Integer> list, int key) {
		int lowerBound = binarySearchHelper(list, key, true);
		int upperBound = binarySearchHelper(list, key, false);
		return new int[] {lowerBound, upperBound};
	}
	
	public static int binarySearchHelper(List<Integer> list, int key, boolean first) {
		int l = 0;
		int r = list.size() - 1;
		int result = -1;
		while (l <= r) {
			int mid = l + ((r - l) / 2);
			if (list.get(mid) > key) {
				r = mid - 1;
			}
			else if (list.get(mid) == key) {
				result = mid;
				if (first) {
					r = mid - 1;
				}
				else {
					l = mid + 1;
				}
			}
			else { // (list.get(mid) < key)
				l = mid + 1;
			}
		}
		return result;
	}
  
}
