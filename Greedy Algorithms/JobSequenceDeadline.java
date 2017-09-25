package algorithms.greedy;

import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Greedy Algorithm - Job Sequence Deadline
 * Input: jobs, deadlines, profits
 * Output: sequence the jobs in a way that maximum profit is obtained
 * 
 * Procedure:
 * Select the maximum deadline and create data structure of that size in a constant time
 * Sort the jobs in descending order of their profits - nlogn time
 * Place the jobs in the data structure slot as far as possible i.e., starting from deadline slot - n jobs, n slots comparisons - O(n2)
 * 
 * @author kumud
 * @version 1.0
 * 
 */

public class JobSequenceDeadline {
    
   public static void getMaxProfit(int[] jobsArr, int[] profits, int[] deadlines, int n){
       int i,j; //loop variables
       int maxProfit;//maximum profit
       
       int[] ds = new int[getMaxDeadline(deadlines)]; //data structure of maximum deadline size
       //initialize the data structure contents to zero
       for(i=0; i<ds.length; i++)
           ds[i] = 0;
       
       Jobs[] jobs = new Jobs[n];
       for(i=0; i<n; i++)
           jobs[i] = new Jobs(jobsArr[i], profits[i], deadlines[i]);
       
       //Sort the jobs in descending order of their profits
       Arrays.sort(jobs, new Comparator<Jobs>(){
           @Override
           public int compare(Jobs job1, Jobs job2){
               return job1.profit > job2.profit ? -1:1;
           }
       });
       
       /*for(i=0; i<n; i++)
           System.out.println(jobs[i].profit + " " + jobs[i].deadline);*/
       
       //Finding slots for each job starting from deadline slot
       for(i=0; i<n; i++){
           for(j=jobs[i].deadline-1; j>=0; j--){
               if(ds[j] == 0){ //if the corresponding deadline slot is empty
                   ds[j] = jobs[i].profit;
                   jobs[i].visited = 1;
                   break;
               }
           }
       }
       System.out.println("Jobs visited:");
       
       for(i=0; i<n; i++){
           if(jobs[i].visited == 1)
               System.out.print("J"+jobs[i].job +" ");
       }
       
       System.out.println();
       
       maxProfit = sumArray(ds);
       System.out.println("Maximum profit "+ " " + maxProfit);
       
   }
   
   public static int getMaxDeadline(int[] deadlines){
       int maxDeadline = 0;
       for(int i=0; i<deadlines.length; i++){
           if(maxDeadline < deadlines[i])
               maxDeadline = deadlines[i];
       }
       return maxDeadline;
       
   }
   
   public static int sumArray(int[] ds){
       int i; //loop variable
       int sum =0;
       for(i=0; i<ds.length; i++)
           sum+=ds[i];
       return sum;
   }
   
   
   public static void main(String[] args){
       int n; //number of jobs
       int[] jobs; //jobs array
       int[] profits; //profits of jobs
       int[] deadlines; //deadlines of jobs
       int i; //loop variable
       
       Scanner sc = new Scanner(System.in); //reading input from command prompt
       
       System.out.println("Job Sequencing Deadline");
       System.out.println("Enter the number of jobs");
       n = sc.nextInt();
       
       jobs = new int[n];
       profits = new int[n];
       deadlines = new int[n];
       
       System.out.println("Enter the profits and deaadliness of jobs");
       for(i=0; i<n; i++){
           jobs[i] = i+1;
           profits[i] = sc.nextInt();
           deadlines[i] = sc.nextInt();
       }
       
       getMaxProfit(jobs, profits, deadlines, n);
   } 
   
   //Java doesn't require forward declarations
   private static class Jobs{
       int job; //individual job
       int profit; //profit of aan individual job
       int deadline; //deadline of an individual job
       int visited; //flag to check whether job has been visited or not
       
       public Jobs(int job, int profit, int deadline){
           this.job = job;
           this.profit = profit;
           this.deadline = deadline;
           this.visited = 0;
       }
   }
}

