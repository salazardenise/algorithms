import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Insertionsort {

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
			
			// sort the array
			insertionSort(list);
			
			// write to output file
			File file = new File(outputFileName);
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int i = 0; i < n; i++) {
				bufferedWriter.write(Integer.toString(list.get(i)));
				bufferedWriter.newLine();
			}
			bufferedWriter.close();
			
		} catch (FileNotFoundException e){
			System.out.println(fileName + " file not found.");
		} catch (IOException e1) {
			System.out.println("Error writing to file " + outputFileName);
			e1.printStackTrace();
		}
	}
	
	public static void insertionSort(List<Integer> list) {
		for (int i = 1; i < list.size(); i++) {
			int j = i;
			while (j-1 >= 0 && list.get(j-1) > list.get(j)) {
				swap(list, j-1, j);
				j--;
			}
		}
	}
	
	private static void swap(List<Integer> list, int i, int j) {
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}

}
