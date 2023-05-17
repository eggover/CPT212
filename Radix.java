//Package java
import java.io.*;
import java.util.*;
 
//Class Radix
public class Radix {

    //Find maximum value in the arr[]
    //n: array size
    static void getMax(int arr[], int n, int a[])
    {
        int mx = arr[0];
        int counter = a[0]+1;

        for (int i = 1; i < n; i++)
        {
            counter+=3;
            if (arr[i] > mx)
            {
                mx = arr[i];
                counter +=2;
            }
            
            else
                counter+=2;
        }
        a[0]=counter;
        a[1]=mx;
    
    }
 
    //countSort function to sort for each place value
    static int countSort(int arr[], int n, int exp, int counter)
    {
        int output[] = new int[n]; //Output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
        counter+=1;
 
        //Store count in count[]
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
            counter += 6;
 
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
            counter += 6;

        for (i = n - 1; i >= 0; i--) { 
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
            counter +=10;
        }
 
        //Copy the output array to arr[]
        for (i = 0; i < n; i++)
        {
            arr[i] = output[i];
            counter +=1;
        }
        counter+=3;
        for (i = 0; i < n; i++)
            System.out.print(arr[i]+" ");
     
        return counter;
    }
    
    //The main function to that sorts arr[]
    //n : array size
    static int radixsort(int arr[], int n,int counter)
    {
        //Find maximum value in an array
        int a[] = new int[2];
        Arrays.fill(a,0);
        getMax(arr, n, a);
        int m = a[1];
        counter = a[0];
        //System.out.print(counter);
 
        //Do counting sort for every digit
        //exp: place value
        for (int exp = 1; m / exp > 0; exp *= 10 )
        {
            System.out.print("\nPass at place value " + exp + ": ");
            counter = countSort(arr, n, exp,counter) +1 ;
        }
     
        return counter;
    }
    
    //---------------------------------------------------Converter starts-------------------------------------------------
    //Change array from float to integer 
    //arr2: array, n: array size, arri: array in integer
    static int floattoint(float arr[], int n, int arri[], int counter)
    {
        
        for(int i=0; i<n; i++) 
        {
            arr[i] = arr[i]*10;
            arri[i] = (int)arr[i];
            counter +=7;
        }
        return counter;
    }
    
    //Change array from integer to float
    //arri: array in integer, n: array size, arri: array in integer
    static int inttofloat(int arri[], int n, float arrf[], int counter)
    { 
        for(int i=0; i<n; i++)  
        {
             arrf[i] = (float)arri[i];
             arrf[i] = arrf[i]/10;
             counter += 7;
        }
        System.out.print("\n" );
        return counter;
    }
    //-------------------------------------------------Converter ends-------------------------------------------------
    
    //-------------------------------------------------Print starts---------------------------------------------------
    //Print unsorted array float
    static void printUnsort(float arr[], int n)
    {
        System.out.print("\n\nUnsorted array: " );
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
    
    //Print sorted array float
    static void printSort(float arr[], int n)
    {
        System.out.print("\n\nSorted array: " );
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }
    //---------------------------------------------------Print end----------------------------------------------------
 
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
        counter = radixsort(arr1,m,counter);
        System.out.print("\n" );
        
        //Print output sorted int
        System.out.print("\nSorted array: " );
        for (int i = 0; i < m; i++)
            System.out.print(arr1[i] + " ");
        System.out.print("\nNumber of input: " + m);
        System.out.print("\nNumber of operation: " +counter);
        System.out.print("\n\n----------------------------------------------------------------" );
        //Radix sort integer stop-------------------------------------
        
        //Radix sort float starts-------------------------------------
        System.out.print("\n\n(Floating values for Radix Sort) " );
     
        float arr2[] = { 275.0f,87.1f,426.2f,61.3f,409.7f,170.0f,677.8f,503.2f };
        int n = arr2.length;
        counter = 1;
        
        printUnsort(arr2, n); //Print output unsorted float
        
        int arri[] = new int[n]; //New array for the array in integer
        counter = floattoint(arr2,n,arri,counter); //Change array from float to integer
           
        System.out.print("\n" );
        counter = radixsort(arri, n, counter); //Sort function
        
        float arrf[] = new float[n]; //New array for the array in float
        counter = inttofloat(arri,n,arrf,counter); //Change array from int to float
        
        printSort (arrf,n); //Print output sorted float
        System.out.print("\nNumber of input: " + n);
        System.out.print("\nNumber of operation: " +counter);
        System.out.print("\n\n----------------------------------------------------------------" );
        //Radix sort float ends--------------------------------------
     
        //Radix sort array(1 input) starts--------------------------------------
        System.out.print("\n\n(Array with 1 input)" );
     
        float arr3[] = {275.0f};
        int n3 = arr3.length;
        counter = 1;
        
        printUnsort(arr3, n3); //Print output unsorted float
        
        int arri3[] = new int[n3]; //New array for the array in integer
        counter = floattoint(arr3,n3,arri3,counter); //Change array from float to integer
           
        System.out.print("\n" );
        counter = radixsort(arri3, n3, counter); //Sort function
        
        float arrf3[] = new float[n3]; //New array for the array in float
        counter = inttofloat(arri3,n3,arrf3,counter); //Change array from int to float
        
        printSort (arrf3,n3); //Print output sorted float
        System.out.print("\nNumber of input: " + n3);
        System.out.print("\nNumber of operation: " +counter);
        System.out.print("\n\n----------------------------------------------------------------" );
        //Radix sort array(1 input) ends----------------------------------------
     
        //Radix sort array(2 input) starts--------------------------------------
        System.out.print("\n\n(Array with 2 input)" );
        float arr4[] = {275.0f, 87.1f};
        int n4 = arr4.length;
        counter = 1;
        
        printUnsort(arr4, n4); //Print output unsorted float
        
        int arri4[] = new int[n4]; //New array for the array in integer
        counter = floattoint(arr4,n4,arri4,counter); //Change array from float to integer
           
        System.out.print("\n" );
        counter = radixsort(arri4, n4, counter); //Sort function
        
        float arrf4[] = new float[n4]; //New array for the array in float
        counter = inttofloat(arri4,n4,arrf4,counter); //Change array from int to float
        
        printSort (arrf4,n4); //Print output sorted float
        System.out.print("\nNumber of input: " + n4);
        System.out.print("\nNumber of operation: " +counter);
        System.out.print("\n\n----------------------------------------------------------------" );
        //Radix sort array(2 input) ends----------------------------------------
        
        //Radix sort array(3 input) starts--------------------------------------
        System.out.print("\n\n(Array with 3 input)" );
        float arr5[] = {275.0f, 87.1f,426.2f};
        int n5 = arr5.length;
        counter = 1;
        
        printUnsort(arr5, n5); //Print output unsorted float
        
        int arri5[] = new int[n5]; //New array for the array in integer
        counter = floattoint(arr5,n5,arri5,counter); //Change array from float to integer
           
        System.out.print("\n" );
        counter = radixsort(arri5, n5, counter); //Sort function
        
        float arrf5[] = new float[n5]; //New array for the array in float
        counter = inttofloat(arri5,n5,arrf5,counter); //Change array from int to float
        
        printSort (arrf5,n5); //Print output sorted float
        System.out.print("\nNumber of input: " + n5);
        System.out.print("\nNumber of operation: " +counter);
        System.out.print("\n\n----------------------------------------------------------------" );
        //Radix sort array(3 input) ends----------------------------------------
     
        //Radix sort array(4 input) starts--------------------------------------
        System.out.print("\n\n(Array with 4 input)" );
        float arr6[] = {275.0f,87.1f,426.2f,61.3f};
        int n6 = arr6.length;
        counter = 1;
        
        printUnsort(arr6, n6); //Print output unsorted float
        
        int arri6[] = new int[n6]; //New array for the array in integer
        counter = floattoint(arr6,n6,arri6,counter); //Change array from float to integer
           
        System.out.print("\n" );
        counter = radixsort(arri6, n6, counter); //Sort function
        
        float arrf6[] = new float[n6]; //New array for the array in float
        counter = inttofloat(arri6,n6,arrf6,counter); //Change array from int to float
        
        printSort (arrf6,n6); //Print output sorted float
        System.out.print("\nNumber of input: " + n6);
        System.out.print("\nNumber of operation: " +counter);
        System.out.print("\n\n----------------------------------------------------------------" );
        //Radix sort array(4 input) ends----------------------------------------
        
    }
}
