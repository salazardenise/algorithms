import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quicksort {

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
			int comp = quickSort(arr, 0, arr.length-1);
			
			// write to output file
			File file = new File(outputFileName);
			FileWriter fileWriter = new FileWriter(file);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			for (int i = 0; i < n; i++) {
				bufferedWriter.write(Integer.toString(arr[i]));
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
	
	public static int quickSort(int[] arr, int l, int r) {
		//System.out.println("l: " + l + ",r: " + r);
		int comp = 0;
		if (l < r) {
			choosePivot(arr, l, r);
			//System.out.println("Before partition: " + Arrays.toString(arr));
			//System.out.println("pivot: " + arr[l]);
			int pInd = partition(arr, l, r);
			comp = r - l;
			//System.out.println(comp);
			//System.out.println("After partition: " + Arrays.toString(arr));
			//System.out.println("Index of pivot: " + pInd);
			//System.out.println("-------");
			comp += quickSort(arr, l, pInd - 1);
			comp += quickSort(arr, pInd + 1, r);
		}
		return comp;
	}
	
	/*
	 * Moves pivot of choice to be first element in arr
	 * @return pivot value
	 */
	public static int choosePivot(int[] arr, int l, int r) {
		//*****Option 1: Pick First Element
		// do nothing
		
		//*****Option 2: Pick Last Element
		/*
		swap(arr, l, r);
		*/
		
		//*****Option 3: Pick Median Element
		/*
		int p;
		int n = r - l + 1;
		p = l + (int) n / 2;
		swap(arr, l, p);
		*/
		
		//*****Option 4: Pick Random Element
		/*
		int p;
		int n = r - l + 1;
		Random rand = new Random();
		p = l + rand.nextInt(n);
		swap(arr, l, p);
		*/
		
		//*****Option 5: Pick pivot using Median-3-Rule
		int n = r - l + 1;
		int mid = l + (int) (n-1) / 2;
		int p;
		if ((arr[l] < arr[mid] && arr[l] > arr[r]) || (arr[l] > arr[mid] && arr[l] < arr[r])) {
			p = l;
		}
		else if ((arr[r] < arr[mid] && arr[r] > arr[l]) || (arr[r] > arr[mid] && arr[r] < arr[l])) {
			p = r;
		}
		else {
			p = mid;
		}
		swap(arr, l, p);
		
		return arr[l];
	}
	
	public static int partition(int[] arr, int l, int r) {
		int pval = arr[l];
		int i = l + 1;
		for (int j = l + 1; j <= r; j++) {
			if (arr[j] < pval) {
				swap(arr, i, j);
				i = i + 1;
			}
		}
		swap(arr, l, i-1);
		return i-1;
	}
	
	public static void swap(int[] arr, int p1, int p2) {
		int temp = arr[p1];
		arr[p1] = arr[p2];
		arr[p2] = temp;
	}

}
