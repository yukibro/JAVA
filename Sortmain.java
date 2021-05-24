
import java.util.Random;
import java.util.concurrent.TimeUnit;

class Sorting{
	public static void insertionSort(int[] a) {
		for(int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j;
			for(j = i -1; j > 0 && temp < a[j]; j--) {
				a[j + 1] = temp;
			}
			a[j + 1] = temp;
		}
	}

	public static int partition(int a[], int i, int j) {
		int pivot = a[i];
		int p = i;
		int temp;
		for(int k = i + 1; k<=j; k++) {
			if(a[k]<pivot) {
				p = p+1;
				temp = a[p];
				a[p] = a[k];
				a[k] = temp;
			}
			
		}
		temp = a[i];
		a[i] = a[p];
		a[p] = temp;
		return p;
	}
	public static void internalQuickSort(int[] a, int m, int n) {
		int p;
		if(m >= n) {return;}
		p = partition(a, m, n);
		internalQuickSort(a, m, p-1);
		internalQuickSort(a, p+1, n);
	}
	public static void quickSort(int[] a) {
		internalQuickSort(a, 0, a.length-1);
	}
	
	private static void merge(int[] a, int[] temp, int m, int p, int q, int n) {
		int t = m;
		int numElements = n - m + 1;
		while (m <= p && q <= n) {
			if (a[m] < a[q])
				temp[t++] = a[m++];
			else 
				temp[t++] = a[q++];
			}
		while (m <= p) 			
			temp[t++] = a[m++];
		while (q <= n) 		
			temp[t++] = a[q++];
		for (int i = 0; i < numElements; i++, n--)
			a[n] = temp[n];

	}
	public static void internalMergeSort(int[] a, int[] temp, int m, int n) {
		if(m < n) {
			int middle = (m + n) / 2;
			internalMergeSort(a, temp, m, middle);
			internalMergeSort(a, temp, middle+1, n);
			merge(a, temp, m, middle, middle+1, n);
		}
	}
	
	public static void mergeSort(int[] a) {
		int temp[] = new int[a.length];
		internalMergeSort(a, temp, 0, a.length-1);
	}
	
	public static void heapify(int[] a, int h, int m) {
		int j;
		for(j = 2 * h; j <= m; j = 2 * j) {
			if(j < m)
				if(a[j] < a[j+1])
					j = j + 1;
			if(a[h] >= a[j])
				break;
			else
				a[j/2] = a[j];
		}
		a[j/2] = a[h];
	}
	
	public static void heapSort(int[] a) {
		int n = a.length - 1;
		int temp, i;
		for(i = n / 2; i >= 1; i = i - 1) 
			heapify(a, i, n);
		for(i = n - 1; i >=1; i = i - 1) {
			temp = a[1];
			a[1] = a[i + 1];
			a[i + 1] = temp;
			heapify(a, 1, i);
		}	
	}
}
public class Sortmain {
	private static int SIZE = 100;
	private static final int MAX = 100;
	public static void main(String[] args) {
		
		int a[] = new int[SIZE];
		
		Random R = new Random();
		for(int i = 0; i<SIZE; i++) {
			R.nextInt(MAX);
		}
	}
		
		
		long start = System.currentTimeMillis();
		Sorting.insertionSort(a);
		Sorting.quickSort(a);
		long end = System.currentTimeMillis();
		System.out.println(" Execution Time =" + (end - start));
	}
}
