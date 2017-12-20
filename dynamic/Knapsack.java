import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Knapsack {

	public static void main(String[] args) {
		// get fileName and total capacity
		String fileName = args[0];
		int W = Integer.parseInt(args[1]);
		if (W < 0) {
			System.out.println("ERROR: total capacity W mus be a nonnegative integer.");
			return;
		}

		String outputFileName = "output.txt";
		try {
			// read in input file
			Scanner scanner = new Scanner(new File(fileName));
			List<Item> list = new ArrayList<Item>();
			while (scanner.hasNextInt()) {
				int value = scanner.nextInt();
				int weight = scanner.nextInt();
				if (weight < 0 || value < 0) {
					System.out.println("ERROR: weight and value of all items must be nonengative integers.");
					return;
				}
				Item item = new Item(value, weight);
				list.add(item);
			}
			scanner.close();
			
			// determine the max total value possible subject to
			// the total weight of a subset of the items <= total capacity
			int optimalValue = getOptimalValue(list, W);
			
			// write to output file
			File file = new File(outputFileName);
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(Integer.toString(optimalValue));
			bufferedWriter.close();
			
		} catch (FileNotFoundException e){
			System.out.println("ERROR: " + fileName + " file not found.");
		} catch (IOException e1) {
			System.out.println("ERROR: could not write to file " + outputFileName +".");
			e1.printStackTrace();
		}
	}
	
	public static int getOptimalValue(List<Item> items, int W) {
		int n = items.size();
		int[] col1 = new int[W+1];
		int[] col2 = new int[W+1];
		for (int i = 1; i <= n; i++) {
			Item item = items.get(i-1);
			int v = item.getValue();
			int w = item.getWeight();
			for (int x = 0; x <= W; x++) {
				if (w > x) { // edge case
					col2[x] = col1[x];
				}
				else { // general case
				    col2[x] = (col1[x] >= col1[x-w] + v) ? col1[x] : col1[x-w] + v;
				}
			}
			col1 = col2;
			if (i != n) col2 = new int[W+1];
		}
		return col2[W];
	}
	
	public static class Item {
		// instance variables 
		private int value;
		private int weight;
		
		// constructor
		public Item(int value, int weight) {
			this.value = value;
			this.weight = weight;
		}
		
		// getter methods
		public int getValue() {
			return value;
		}
		
		public int getWeight() {
			return weight;
		}
	}

}
