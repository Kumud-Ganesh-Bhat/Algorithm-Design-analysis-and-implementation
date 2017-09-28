/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms.dynamicprogramming;

import java.util.Scanner;

/**
 * Algorithm : Fibonacci Series
 * fibonacci(n) = Sum of previous two natural numbers
 * Apply Dynamic Programming so that number of function calls will be polynomial
 * Optimized space approach
 * Time complexity - O(n)
 * Space complexity - O(1)
 *
 * @author kumud
 * @version 1.0
 * 
 */
public class FibonacciSeries {
    
    public static int fibonacci(int n){
        //Using Optimized space approach
        int a =0; 
        int b =1;
        int c,i;
        
        if(n==0)
            return a;
        
        for(i=2; i<=n; i++){
              c = a+b;
              a=b;
              b=c;
        } //for
            
        return b;    
        
        
    }
    
    public static void main(String[] args){
        int n, result; 
        Scanner sc = new Scanner(System.in); //Reading input from command prompt
        System.out.println("Fibonacci Series");
        System.out.println("Enter the value of n");
        n=sc.nextInt();
        result = fibonacci(n);
        System.out.println("Fibonacci of "+ n+":"+result);
    }
    
}

