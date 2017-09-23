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

public class MergeSort {
    
    public static int[] merge(int[] arr, int p, int q, int r){
        int n1 = q-p+1; //number of elements of first sorted list
        int n2 = r-q; //number of elements of second sorted list
        int[] L = new int[n1+1]; //first sorted list
        int[] R = new int[n2+1]; //second sorted list
        int i,j,k; //loop variables
        for(i=0; i<n1; i++)
            L[i] = arr[p+i];
        for(j=0;j<n2;j++)
            R[j] = arr[q+1+j];
        L[n1] = Integer.MAX_VALUE; //storing kind of infinity
        R[n2] = Integer.MAX_VALUE;
        i=0; //element examining the first list
        j=0; //element examining the second list
        for(k=p; k<=r; k++){
            if(L[i] <= R[j]){
                arr[k] = L[i++];
            }
            else{
                arr[k] = R[j++];
            }
        }
        
        return arr;
    }
    
    public static int[] mergeSort(int[] arr, int p ,int r){
        int q ; //middle index
        if(p < r){
            q = (p+r)/2;
            mergeSort(arr, p,q);
            mergeSort(arr, q+1, r);
            arr = merge(arr,p,q,r);
        }
        
        return arr;
        
    }
    
    public static void main(String[] args){
        //local variables
        int n; //number of elements to be sorted
        int[]arr; //array of elements to be sorted
        int i=0; //loop variable
        int p,r; //variables representing first and last index of an array respectively
        
        Scanner sc = new Scanner(System.in); //to read input from command prompt
        
        System.out.println("Merge Sort Algorithm");
        System.out.println("Enter the number of elements to be sorted");
        
        n =  sc.nextInt();
        arr = new int[n];
        
        System.out.println("Enter the array elements");
        
        while(sc.hasNextInt()){
            arr[i++] = sc.nextInt();
        }
        
        p = 0;
        r = arr.length - 1; //or n-1;
        
        System.out.println("Before Sorting:" + " " + Arrays.toString(arr));
        arr = mergeSort(arr,p,r);
        System.out.println("After Sorting:" + " " + Arrays.toString(arr));    
        }
        
        
    }
    

