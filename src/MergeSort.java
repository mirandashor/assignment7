import java.util.*;
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors


public class MergeSort {
    public static void main(String [] args){
        Random g = new Random();
        int [] arr = new int [10];
        FileWriter myWriter;
       //System.out.println();


        try {
            myWriter = new FileWriter("random-integers.txt");    

            for (int d = 0 ; d<arr.length ; d++){
                arr[d] = g.nextInt(100)+1;

                try {
                    myWriter.write(new Integer(arr[d]).toString());  
                    myWriter.write("\r\n");
                    //System.out.println(arr[d]);

                } catch (IOException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                }
            }
            
            myWriter.close();

        } catch (IOException e1) {
            e1.printStackTrace();
        }

        System.out.print("\nunsorted arrs:" + Arrays.toString(arr));

        mergeSort(arr, arr.length);

        System.out.print("\nSorted arrs:  [");
        for(int i = 0; i < arr.length; ++i){
            if(i < arr.length - 1)
                System.out.print(arr[i]+ ", ");
            else
                System.out.print(arr[i]);
        }

        System.out.print("]\n");

    }


    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];
    
        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }
        mergeSort(l, mid);
        mergeSort(r, n - mid);
    
        merge(a, l, r, mid, n - mid);
    } 

    public static void merge(int[] a, int[] l, int[] r, int left, int right) {
        
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            }
            else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }

}
