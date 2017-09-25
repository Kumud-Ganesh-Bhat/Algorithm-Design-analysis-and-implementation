package algorithms.greedy;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Greedy Algorithm - Fractional Knapsack
 * Input: capacity, weights, profits
 * Output: maximum profit
 * 
 * Procedure:
 * Compute profit per unit for each object
 * Sort the object in descending order of profit per unit and 
 * Place them in knapsack such that maximum profit is obtained and capacity of knapsack is not exceeded
 * 
 * @param capacity, weights, profits
 * @return maxProfit
 * 
 * @author Kumud Bhat
 * @version 1.0
 * 
 */

public class FractionalKnapsack{
    
    public static void getMaxProfit(int[] weights, int[] profits, int capacity, int n){
        double maxProfit = 0; //maximum optimal profit
        Objects[] objects = new Objects[n]; //Array of objects of class Objects - each object is an reference containing information about individual objects
        int i; //loop variable
        for(i=0; i<n; i++)
            objects[i] = new Objects(profits[i], weights[i]);
        //Sort the objects in the descending order of profits per unit / profit by wieght ratio
        Arrays.sort(objects, new Comparator<Objects>(){
           @Override
           public int compare(Objects obj1, Objects obj2){
               return obj1.pw_ratio > obj2.pw_ratio ? -1:1 ;
           }
        });
        for(i=0; i<n; i++){
            //checking whether object can be fully placed in knapsack or not
            if(capacity > 0 && objects[i].weight <= capacity){
                capacity-= objects[i].weight;
                maxProfit+= objects[i].profit;
            }
            else if(capacity > 0)
                maxProfit+= objects[i].pw_ratio * capacity;
            else break;
        } //for
        
        System.out.println("Maximum optimal profit" + " " + maxProfit);
        
        
    }
    public static void main(String[] args){
        
        int capacity; //capacity of knapsack
        int n; //number of objects
        int weights[]; //weights of objects
        int profits[]; //profits of objects
        int i;//loop variable
        
        Scanner sc = new Scanner(System.in); //reading input from command prompt
        
        System.out.println("Fractional Knapsack - Greedy Approach");
        
        System.out.println("Enter the capacity of knapsack");
        capacity = sc.nextInt();
        System.out.println("Enter the number of objects");
        n = sc.nextInt();
        
        weights = new int[n];
        profits = new int[n];
        
        System.out.println("Enter the object weights and profits");
        for(i=0; i<n; i++){
            weights[i] = sc.nextInt();
            profits[i] = sc.nextInt();
        }
        
        getMaxProfit(weights,profits,capacity,n);
        
        
    }
    
    //class is used before its declaration. Java doesn't require forward declarations
    private static class Objects{
        int profit; //profit of an individual object
        int weight; //weight of an individual object
        double pw_ratio; //profit per unit value for an individual object
        
        public Objects(int profit, int weight){
            this.profit = profit;
            this.weight = weight;
            pw_ratio = this.profit/this.weight;
            
        }
    }
}
