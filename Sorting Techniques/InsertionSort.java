import java.util.Scanner; 
import java.util.Arrays;

public class InsertionSort{
  
    public static int[] insertionSort(int[] arr, int n){
           int i,j; //loop variables
           int key;
           for(j=1; j<n; j++){
               key = arr[j]; //preventing from losing the value due to overrriding
               i = j-1; //insert the element to sorted sequence from 0-j-1
               while(i>=0 && arr[i]>=key){
                     arr[i+1] = arr[i];
                     i-=1;
               }
               arr[i+1] = key;
           }
    }
               
    public static void main(String[] args){
           int n; //size of array
           int i;//loop variable
           Scanner sc = new Scanner(System.in); //reading input from command prompt
           System.out.println("Insertion Sort Algorithm");
           System.out.println("Enter the number of numbers to be sorted");
           n = sc.nextInt();
           int[] arr = new int[n];
           System.out.println("Enter the array numbers");
           while(sc.hasNextInt()){
             arr[i++] = sc.nextInt();
           }
           System.out.println("Before Sorting:" + " " + Arrays.toString(arr));
           arr = insertionSort(arr,n);
           System.out.println("After Sorting:" + " " + Arrays.toString(arr));
    }
}
           
      
      
