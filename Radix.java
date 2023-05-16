//Package java
import java.io.*;
import java.util.*;
 
//Class Radix
public class Radix {
 
    // Find maximum value in the arr[]
    // n: array size
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
 
    //countSort function to sort for each place value
    static void countSort(int arr[], int n, int exp, int counter)
    {
        int output[] = new int[n]; //Output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
 
        //Store count in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
            counter += 6;
 
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
 
        //Copy the output array to arr[]
        //arr[] now contains sorted numbers according to current digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
            
        for (i = 0; i < n; i++)
            System.out.print(arr[i]+" ");
    }
 
    //The main function to that sorts arr[]
    //n : array size
    static void radixsort(int arr[], int n,int counter)
    {
        //count = 1;
        //Find maximum value in an array
        int m = getMax(arr, n);
 
        //Do counting sort for every digit
        //exp: place value
        for (int exp = 1; m / exp > 0; exp *= 10 )
        {
            System.out.print("\nPass at place value " + exp + ": ");
            counter =1;
            countSort(arr, n, exp,counter);
            counter ++;
        }
    }
 
    //Print array sorted 
    //n: array size
    static void print(float arr[], int n,int counter)
    {
        System.out.print("\nSorted array: ");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
        System.out.print("\n");
        counter += 3;
    }
 
    //Change array from float to integer 
    //arr2: array 2, n: array size, arri: array in integer
    static void floattoint(float arr2[], int n, int arri[], int counter)
    {
        
        for(int i=0; i<n; i++) 
        {
            arr2[i] = arr2[i]*10;
            arri[i] = (int)arr2[i];
            counter +=7;
        }
    }
 
    //Change array from integer to float
    //arri: array in integer, n: array size, arri: array in integer
    static void inttofloat(int arri[], int n, float arrf[], int counter)
    { 
        for(int i=0; i<n; i++)  
        {
             arrf[i] = (float)arri[i];
             arrf[i] = arrf[i]/10;
             counter += 7;
        }
        System.out.print("\n" );
    }
 
    //Print unsorted array float
    static void printUnsort(float arr[], int n)
    {
        System.out.print("\n\nUnsorted array: " );
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
    
    //Print sorted array float
    static void printSort(float arr[], int n, int counter)
    {
        System.out.print("\n\nSorted array: " );
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
            counter += 3;
    }
 
    //Main code
    public static void main(String[] args)
    {              
        //Radix sort integer start-------------------------------------
        int arr1[] = {275, 87, 426, 61, 409, 170, 677, 503};
        int m = arr1.length;
        int counter=1;
        System.out.print("(Integer for Radix Sort) " );
        System.out.print("\n\nUnsorted array: " );
        for (int i = 0; i < m; i++)
            System.out.print(arr1[i] + " ");
        System.out.print("\n" );
        
        //Calling function
        
        radixsort(arr1,m,counter);
        System.out.print("\n" );
        
        //Print output sorted int
        System.out.print("\nSorted array: " );
        for (int i = 0; i < m; i++)
            System.out.print(arr1[i] + " ");
            System.out.print("\n\n----------------------------------------------------------------" );
        //Radix sort integer stop-------------------------------------
        
        //Radix sort float starts-------------------------------------
        float arr2[] = { 275.0f,87.1f,426.2f,61.3f,409.7f,170.0f,677.8f,503.2f };
        float arr3[] = {275.0f};
        float arr4[] = {275.0f, 87.1f};
        float arr5[] = {275.0f, 87.1f,426.2f};
        float arr6[] = {275.0f,87.1f,426.2f,61.3f}; 
        int n = arr2.length;
        System.out.print("\n\n(Floating values for Radix Sort) " );
     
        //Calling function for print output unsorted float
        printUnsort(arr2, n);
        
        //Change array to integer
        int arri[] = new int[n];
        floattoint(arr2,n,arri,counter);
           
        System.out.print("\n" );
        radixsort(arri, n, counter); //Calling function
        
        //Change int to float
        float arrf[] = new float[n];
        inttofloat(arri,n,arrf,counter);
        
        //Calling function for print output sorted float
        printSort (arrf,n,counter);
    }
}
