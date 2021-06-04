package OS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
class Process   //process class for each process
{
	 int PID,AT,BT,TT,WT,CT;  //variable declaration
     public Process()  //default constructor 
     {
    	 this.PID=0;
    	 this.AT=0;
    	 this.CT=0;
    	 this.TT=0;
    	 this.WT=0;
    	 this.BT=0;
     }
     public int getBT()  //to get BT variable for specific object
     {
 		return this.BT;
     }
}

public class CPUAlgo {
	int nProcess;     //declaring class variables
	Scanner sc=new Scanner(System.in);
	Process P[]=new Process[50];   //array of process object
	
	public void accept()  //method to accept all the parameters
	{
		System.out.println("Enter the number of process to be performed");
		nProcess=sc.nextInt();
		System.out.println("Enter the Arrival time and burst time for each process");
		for(int i=0;i<nProcess;i++)  //taking burst time and arrival time ffor specific id of function
		{
			P[i]=new Process();
			P[i].PID=i;
			System.out.println("Enter Arrival time for process :"+i);
			P[i].AT=sc.nextInt();
			System.out.println("Enter Burst time for process :"+i);
			P[i].BT=sc.nextInt();
			
		}
		System.out.println("--------------------------------------------------");

	}
	public void calculate()  //to calculate the CT and TT WT for process
	{
		int count=0;
		for(int i=0;i<nProcess;i++)
		{
			count=count+P[i].BT;  //to store the CT for specific object for next time
			P[i].CT=count;
		}
		for(int i=0;i<nProcess;i++)  //TT and WT
		{
			P[i].TT=P[i].CT-P[i].AT;
			P[i].WT=P[i].TT-P[i].BT;
		}
	}
	public void displayTable()  //Displaying the data
	{
		System.out.println("TABLE-");
		System.out.println("--------------------------------------------------");
		System.out.println("Process\t\tAT\tBT\tCT\tTT\tWT\n");
		for(int i=0;i<nProcess;i++)
		{
			System.out.println("P"+i+"\t\t"+P[i].AT+"\t"+P[i].BT+"\t"+P[i].CT+"\t"+P[i].TT+"\t"+P[i].WT);
		}
		System.out.println("--------------------------------------------------");
	}
	public void avgTime() //function to calculate the process AVG time of TT and WT
	{
		float avg_TT = 0,avg_WT = 0;
		for(int i=0;i<nProcess;i++)
		{
			avg_TT+=P[i].TT;
			avg_WT+=P[i].WT;
		}
		avg_TT=avg_TT/nProcess;  
		avg_WT=avg_WT/nProcess;
		System.out.println("The Average turnaround Time is : "+avg_TT);
		System.out.println("The Average Waiting Time is : "+avg_WT);
		System.out.println("--------------------------------------------------");

	}
	
	public void SRTF()  //SRTF function
	{
		Process front;
		int[] bt=new int[50];  //since BT will change so storing in another array
		for(int i=0;i<nProcess;i++)
		{
			bt[i]=P[i].BT;
		}
		Comparator<Process> BTSort = Comparator.comparingInt(Process::getBT); //to compare the BT of process
		Queue<Process> priority=new PriorityQueue<>(BTSort);  //Storing the BT according to priority of BT
		ArrayList timeline=new ArrayList<>();  //TO display the Gantt chart 
		int time_cnt=0;
		Process temp;
		do
		{
			for(int i=0;i<nProcess;i++)  //for loop
			{
				if(P[i].AT==time_cnt)  //checking if process arrived or not
				{
					priority.add(P[i]);
				}
				if(priority.isEmpty())  //if queue is empty
				{
					break;  
				}
				else
				{
					temp=priority.peek();  //front element
					front=priority.poll();  //returning the object and removing 
					if(!priority.isEmpty())   //if queue is empty
					{
						if(front.AT>priority.peek().AT && front.BT==priority.peek().BT) //to check whether the processes have same burst time
						{
							temp=front; //storing the front in temp
							front=priority.peek();  //assignning the front value to front
							priority.add(temp);  //adding again front in queue
						}
						else  //if BT is not same
						{
							priority.add(front);  //add the front in queue
							front=priority.peek();  //and peek the front element
						}
					}
					else   //if queue is empty
					{
						priority.add(temp);  //add temp in queue
						front=temp;  //assigning front to temp
					}
					timeline.add(front.PID);  //adding the process in timline array to show gnatt chart
					time_cnt+=1;  //inncrement time count
					front.BT+=-1;  //decrement BT of scheduled process
					if(front.BT==0)  //if process executed completely
					{
						priority.remove(P[front.PID]);  //remove
						
					}
				}
			}
		}while(!priority.isEmpty());
		
		for(int i=0;i<nProcess;i++)  //calculating the CT,TT,WT
		{
			P[i].CT=timeline.lastIndexOf(i)+1;
			P[i].TT=P[i].CT-P[i].AT;
			P[i].WT=P[i].TT-bt[i];	
			P[i].BT=bt[i];
		}
		displayTable();  //display table
		System.out.println("--------------------------------------------------");
		System.out.println("Gnatt Chart");
		System.out.println("--------------------------------------------------");
		for(int i=0;i<timeline.size();i++)  //Gnatt chart
		{
			System.out.print("|P"+timeline.get(i));
		}
		System.out.println("\n--------------------------------------------------");
		avgTime();  //calling avg_Time function show calculate avg waiting and turnaround time
		System.out.println("--------------------------------------------------");
	}
	
    
}
