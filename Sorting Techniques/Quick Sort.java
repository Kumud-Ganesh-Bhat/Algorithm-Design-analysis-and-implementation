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
public class QuickSort {
    
    public static int partition(int[] arr, int p, int r){
        int i,j,pivot,temp;
        pivot = arr[r];
        i=p-1;
        for(j=p; j<r; j++){
            if(arr[j] <= pivot){
                temp = arr[++i];
                arr[i] = arr[j];
                arr[j] = temp;
                
            } //if
        } //for
        temp = arr[++i];
        arr[i] = arr[r];
        arr[r] = temp;
        
        return i;
    }
    
    public static int[] quickSort(int[] arr, int p, int r){
        int q; //position of element based on which partition is done
        if(p<r){
            q = partition(arr,p,r);
            quickSort(arr,p,q-1);
            quickSort(arr,q+1,r);
        }
        
        return arr;
    }
    
    public static void main(String[] args){
        int n; //number of elements to be sorted
        int[] arr; //array of elements to be sorted
        int i=0; //loop variable
        Scanner sc = new Scanner(System.in); //reading input from command line prompt
        
        System.out.println("Quick Sort Algorithm");
        System.out.println("Enter the number of elements to be sorted");
        
        n = sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        while(sc.hasNextInt()){
            arr[i++] = sc.nextInt();
        }
        
        System.out.println("Before Sorting:" + " " + Arrays.toString(arr));
        arr = quickSort(arr,0,n-1);
        System.out.println("After Sorting:" + " " + Arrays.toString(arr));
    }
    
}

