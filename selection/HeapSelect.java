import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class HeapSelect {

	public static void main(String[] args) {
		// get fileName
		String fileName = args[0];
		
		// get k
		int k = Integer.parseInt(args[1]);
		if (k < 1) {
			System.out.println("k must be larger than or equal to one.");
			return;
		}
		
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
			if (k > n) {
				System.out.println("k must be smaller than or equal tp the total number of integers");
				return;
			}
			int[] arr = new int[n];
			int ind = 0;
			for (int num : list) {
				arr[ind] = num;
				ind++;
			}
			
			// determine kth order statistic
			int stat = priorityQueueSelection(arr, k);
			
			// write to output file
			File file = new File(outputFileName);
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write(Integer.toString(stat));
			bufferedWriter.close();
			
		} catch (FileNotFoundException e){
			System.out.println(fileName + " file not found.");
		} catch (IOException e1) {
			System.out.println("Error writing to file " + outputFileName);
			e1.printStackTrace();
		}

	}
	
	public static int priorityQueueSelection(int[] arr, int i) {
		Queue<Integer> pq = new PriorityQueue<Integer>(i, Collections.reverseOrder());
		for (int k = 0; k < arr.length; k++) {
			if (k < i) {
				pq.add(arr[k]);
			}
			else {
				if (arr[k] < pq.peek()) {
					pq.poll();
					pq.add(arr[k]);
				}
			}
		}
		return pq.poll();
	}

}
