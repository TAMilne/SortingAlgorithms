package Managers;

import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.Exchanger;

import problemdomain.Shape;

public class Sort {

	/**
	 * Bubble Sort Method
	 * @param arr Unsorted Array of Shapes
	 * @param comp Height/Volume/BaseArea Comparator
	 * @return Sorted Array of Shapes
	 */
	public Shape[] bubbleSort(Shape[]  arr, Comparator comp) {
		int l = arr.length;
		for(int i = 0; i < l-1; i++) {
			for(int j = 0; j< l-1; j++) {
				if(comp.compare(arr[j], arr[j+1]) < 0) {
					Shape temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}

	/**
	 * Insert Sort Method
	 * @param arr Unsorted Array of Shapes
	 * @param comp Height/Volume/BaseArea Comparator
	 * @return Sorted Array of Shapes
	 */
	public static Shape[] insertSort(Shape[] arr, Comparator comp) {
		
	        for (int i = 1; i < arr.length; ++i) {
	            Shape index;
	            
	            for(int j = i; j >0; j--) {
	            	if(comp.compare(arr[j], arr[j-1]) > 0) {
	            		swap(arr, i, j-1);
	            	}
	            }
	        }
			return arr;
	}

	/**
	 * Selection Sort Method
	 * @param arr Unsorted Array of Shapes
	 * @param comp Height/Volume/BaseArea Comparator
	 * @return Sorted Array of Shapes
	 */
	public static Shape[] selectionSort(Shape[] arr, Comparator comp) {
		
		for (int i = 0; i < arr.length - 1; ++i) {
			int minIndex = i;
			
			for (int j = i + 1; j < arr.length; ++j) {
				if (comp.compare(arr[j], arr[minIndex]) > 0) {
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
		return arr;
	}

	/**Driver of Merge Sort
	 * Recursive use divides elements. Then runs merge to sort them back together
	 * @param arr Unsorted Array of Shapes
	 * @param l Beginning Index of array to be sorted
	 * @param r Length of Array minus one
	 * @param comp Height/Volume/BaseArea Comparator
	 */
	public void mergeSort(Shape[] arr, int l, int r, Comparator comp) {
		if(l<r) {
			int m = (l + r) /2;
			mergeSort(arr, l, m, comp);
			mergeSort(arr, m+1, r, comp);
			merge(arr, l, m, r, comp);
		}
	}

	/**
	 * Utility merge method Used by merge sort
	 * Merge's sorted elements of array back together
	 * @param arr Unsorted Array of Shapes
	 * @param a Low index of left array
	 * @param b High index of left array
	 * @param c Right array is b+1 to c
	 * @param comp Height/Volume/BaseArea Comparator
	 */
	  void merge(Shape[] arr, int a, int b, int c, Comparator comp) {
		    int n1 = b - a + 1;
		    int n2 = c - b;

		    Shape left[] = new Shape[n1];
		    Shape right[] = new Shape[n2];

		    for (int i = 0; i < n1; i++)
		    	left[i] = arr[a + i];
		    for (int j = 0; j < n2; j++)
		    	right[j] = arr[b + 1 + j];

		    int i = 0;
		    int j = 0;
		    int k = a;
		    
		    while (i < n1 && j < n2) {
		      if (comp.compare(left[i], right[j])>0) {
		        arr[k] = left[i];
		        i++;
		      } else {
		        arr[k] = right[j];
		        j++;
		      }
		      k++;
		    }

		    while (i < n1) {
		      arr[k] = left[i];
		      i++;
		      k++;
		    }

		    while (j < n2) {
		      arr[k] = right[j];
		      j++;
		      k++;
		    }
		  }

	  /**
	   * Driver of Quick Sort
	   * 
	   * @param arr Unsorted Array of Shapes
	   * @param from Beginning Index of array to be sorted
	   * @param to Length of Array
	   * @param comp Height/Volume/BaseArea Comparator
	   */
	public void quickSort(Shape[] arr, int from, int to, Comparator comp) {

		if(from<to) {
			int part = partition(arr, from, to, comp);
			quickSort(arr, from, part-1, comp);
			quickSort(arr, part+1, to, comp);
		}
	}
	
	/**
	 * Utility method used by Quick sort method.
	 * Sets pivot and assigns it to it's correct postion in sorted list.
	 * Assigns all smaller elements to the lower side, and higher elements to higher side
	 * @param arr Unsorted Array of Shapes
	 * @param from Beginning Index of array to be sorted
	 * @param to Length of Array
	 * @param comp Height/Volume/BaseArea Comparator
	 * @return
	 */
	private static int partition(Shape[] arr, int from, int to, Comparator comp) {
		Shape pivot = arr[to];
		int i = (from-1);
		
		for (int j = from; j< to; j++) {
			if(comp.compare(arr[j], pivot)>0) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, to);
		return (i+1);
	}
	
	/**
	 * Gnome Sort
	 * Compares current element to previous. 
	 * If swap occurs, index decrements with element.
	 * @param arr Unsorted Array of Shapes
	 * @param l
	 * @param comp Height/Volume/BaseArea Comparator
	 */
	public void gnomeSort(Shape[] arr, int l, Comparator comp) {
		int index = 0;
		
		while(index < l) {
			if(index == 0)
				index++;
			if(comp.compare(arr[index], arr[index-1]) <= 0)
				index++;
			else {
				swap(arr, index, index-1);
				index--;
			}
		}
		return;
		}
	
	/**
	 * Utility swap method used by multiple Sorting methods
	 * @param arr Array with elements to be swapped
	 * @param i Index of Array element moving out of
	 * @param j Index of element to be swapped with
	 */
	private static void swap(Shape[] arr, int i, int j) {
		Shape temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
