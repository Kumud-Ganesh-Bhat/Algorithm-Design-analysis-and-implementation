/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.sorting;

import java.util.Scanner;
import java.util.Arrays;

/**
 *
 * @author kumud
 */
public class BubbleSort {
    
    public static int[] bubbleSort(int[] arr, int n){
        int i,j; //loop variables
        int swapped = 0; //flag variable sued for optimal implementation
        int temp; //variable used during swapping
        
        for(i=0; i<n; i++){
            swapped = 0;
            for(j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){ //ascending order..descending order - arr[j] < arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = 1;
                } //if
            } //for j
            if(swapped == 0)//all elements are sorted
                break;
        } //for i
        
        return arr;
    }
    
    public static void main(String[] args){
        int n; //number of elements to be sorted
        int[] arr; //array of elements to be sorted
        int i=0; //loop variable
        
        Scanner sc = new Scanner(System.in); //reading input from command prompt
        
        System.out.println("Bubble Sort");
        System.out.println("Enter the number of elements to be sorted");
        
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        while(sc.hasNextInt())
            arr[i++] = sc.nextInt();
        
        System.out.println("Before Sorting:" + " " + Arrays.toString(arr));
        arr = bubbleSort(arr, n);
        System.out.println("After Sorting:" +  " " + Arrays.toString(arr));
    }
    
}

