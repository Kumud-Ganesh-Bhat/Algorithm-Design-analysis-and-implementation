import java.util.Arrays;
import java.util.Scanner;

public class CountingSort{
    
    public static int[] countingSort(int[] arr, int[] result, int k){
        int i,j; //loop variables
        int[] count = new int[k]; //data structure in which each cell is dedicated to eleemnt in a range
        
        //initializing the data structure
        for(i=0; i<k; i++)
            count[i] = 0;
        //counting occurrences of distinct keys
        for(j=0; j<arr.length; j++)
            count[arr[j]]+=1;
        
        //doing some arithmetic to store output in result array
        for(i=1; i<k; i++)
            count[i] = count[i-1]+ count[i];
        for(j=arr.length-1; j>=0; j--){
            result[count[arr[j]]-1] = arr[j];
            count[arr[j]]-=1;
        }
        
        return result;
    }
    public static void main(String[] args){
        int n; //number of elements to be sorted
        int[] arr; //array of elements to be sorted
        int[] result; //resulting array;
        int k; // range variable
        int i=0; //loop variable
        
        Scanner sc = new Scanner(System.in); //reading input from command line prompt
        
        System.out.println("Counting Sort");
        System.out.println("Enter the number of elements to be sorted");
        
        n = sc.nextInt();
        arr = new int[n];
        result = new int[n];
        
        System.out.println("Enter the range of elements");
        k = sc.nextInt();
        
        System.out.println("Enter the array elements");
        while(sc.hasNextInt()){
            arr[i++] = sc.nextInt();
        }
        
        System.out.println("Before Sorting:" + " " + Arrays.toString(arr));
        result = countingSort(arr,result,k);
        System.out.println("After Sorting:" + " " + Arrays.toString(result));
    }
}
