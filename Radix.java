import java.io.*;
import java.util.*;
 
public class Radix {
 
    //Find maximum value of array
    
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to current
        // digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
            
        for (i = 0; i < n; i++)
            System.out.print(arr[i]+" ");
    }
 
    // The main function to that sorts arr[] of
    // size n using Radix Sort
    static void radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);
 
        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10 )
        {
            System.out.print("\nPass at place value" + exp + " : ");
            countSort(arr, n, exp);
        }
    }
 
    //Print array unsorted
    static void print(int arr[], int n)
    {
        System.out.print("\nSorted array: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.print("\n");
    }
 
    // Main method
    public static void main(String[] args)
    {
        int arr1[] = {275, 87, 426, 61, 409, 170, 677, 503};
        float arr2[] = { 275.0f,87.1f,426.2f,61.3f,409.7f,170.0f,677.8f,503.2f };
        int m = arr1.length;
        int n = arr2.length;
        
        System.out.print("Integer: " );
        System.out.print("\nUnsorted array:" );
        for (int i = 0; i < m; i++)
            System.out.print(arr1[i] + " ");
        System.out.print("\n" );
        
        radixsort(arr1,m);
        System.out.print("\n" );
        
        System.out.print("\nSorted array:" );
        for (int i = 0; i < m; i++)
            System.out.print(arr1[i] + " ");
        
        
        System.out.print("\n\nDouble: " );
        System.out.print("\nUnsorted array:" );
        for (int i = 0; i < n; i++)
            System.out.print(arr2[i] + " ");
            
        int arri[] = new int[n];
        for(int i=0; i<n; i++) {
            arr2[i] = arr2[i]*10;
            arri[i] = (int)arr2[i];
        }
        
        System.out.print("\n" );
        radixsort(arri, n);
   
        float arrf[] = new float[n];
        for(int i=0; i<n; i++) {
            arrf[i] = (float)arri[i];
            arrf[i] = arrf[i]/10;
        }
        System.out.print("\n" );
        
        System.out.print("\nSorted array:" );
        for (int i = 0; i < n; i++)
            System.out.print(arrf[i] + " ");
    }
}
