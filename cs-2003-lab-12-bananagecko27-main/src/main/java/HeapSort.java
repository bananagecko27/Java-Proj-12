package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/** An implementation of the heapsort algorithm. */
public class HeapSort {

  // **************************************************
  // Public static methods
  // **************************************************

  /**
   * Heapifies the provided array at the given root to
   * construct a max-heap.
   *
   * @param <E>   a comparable type for comparison-based sorting
   * @param arr   the array slice to be heapified
   * @param root  the root of the current subtree
   * @param n     the number of elements in the current heap
   */
  public static <E extends Comparable<? super E>> void heapify(E[] arr, int root, int n) {
    // implement heapify(E[], int, int)
    int left = 2 * root + 1;
    int right = 2 * root + 2;
    E largest;

    if(left < n && right < n){ 
      //largest = max((arr[left], (int)arr[right]);
      if(arr[left].compareTo(arr[right])>0){
        largest = arr[left];
      }
      else{
        largest = arr[right];
      }
    }
    else if(left<n){
      //largest = Math.max((int)arr[root], (int)arr[left]);
      if(arr[root].compareTo(arr[left])>0){
        largest = arr[root];
      }
      else{
        largest = arr[left];
      }
    }
    else if(right<n){
      //largest = Math.max((int)arr[root], (int)arr[right]);
      if(arr[root].compareTo(arr[right])>0){
        largest = arr[root];
      }
      else{
        largest = arr[right];
      }
    }
    else{
      largest = arr[root];
    }

    if(largest.compareTo(arr[root])>0){
      if(arr[left] == largest){
        E temp = arr[root]; 
        arr[root]= arr[left];
        arr[left] = temp;
         heapify(arr, left, n);
      }
      else{
        E temp = arr[root]; 
        arr[root]= arr[right];
        arr[right] = temp;
        heapify(arr, right, n);
      }
    }
}
  /**
   * Performs heapsort to sort the array in-place in ascending order.
   *
   * @param <E>  a comparable type for comparison-based sorting
   * @param arr  the array to be sorted in-place
   */
  public static <E extends Comparable<? super E>> void sort(E[] arr) {
    HeapSort.sort(arr, 0, arr.length - 1);
  }

  /**
   * Performs heapsort to sort the array from first to last in-place
   * in ascending order.
   *
   * @param <E>    a comparable type for comparison-based sorting
   * @param arr    the array slice to be sorted in-place
   * @param first  the first index of the array slice being sorted
   * @param last   the last index of the array slice being sorted
   */
  public static <E extends Comparable<? super E>> void sort(E[] arr, int first, int last) {
    if (first >= last) {
      return;
    }
    int n = last - first + 1;
    for (int i = first + n / 2 - 1; i >= first; i--) {
      HeapSort.heapify(arr, i, n);
    }
    for (int i = last; i > first; i--) {
      E tmp = arr[first];
      arr[first] = arr[i];
      arr[i] = tmp;
      HeapSort.heapify(arr, first, i - first);
    }
  }

  // **************************************************
  // Main
  // **************************************************

  /**
   * Reads a list of integers from lab13.txt and sorts them using
   * quicksort.
   *
   * @param args  the command-line args
   * @throws IOException if lab13.txt cannot be found
   */
  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("lab12.txt")));
    Integer[] data = reader.lines().mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new);
    reader.close();
    HeapSort.sort(data);
    System.out.println(Arrays.toString(data));
  }
}
