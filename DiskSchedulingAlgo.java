package OS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

class node {
    
    // represent difference between
    // head position and track number
    int distance = 0;
     
    // true if track has been accessed
    boolean accessed = false;
}

public class DiskSchedulingAlgo {
	int maxCy,accCy,head;
	ArrayList<Integer> arr=new ArrayList<>();//arraylist to store the request sequence
	
	public void accept() //function to accept the data
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Maximum Number of cylinders : ");
		maxCy=sc.nextInt();  //maximum cylinders 
		System.out.println("Enter total number of cylinders to be accessed: ");
		accCy=sc.nextInt();  //cylinders to be accessed
		System.out.println("Enter the sequence of cylinders: ");
		for(int i=0;i<accCy;i++)
		{
			arr.add(sc.nextInt()); //adding the request sequence in arraylist
		}
		System.out.println("Enter Starting location of head is: ");
		head=sc.nextInt();  //starting location
	}
	
	public void display()  //function to display entered data
	{
		System.out.println("Starting location of head is: "+head);
		System.out.println("Sequence is :"+arr);
		System.out.println("Maximum number of cylinders: "+maxCy);
	}
	
	public void FCFS()  //Function to find the seek time by FCFS algo
	{
		int seek_time=0;
		int distance,cur_track;
		System.out.println("Distance Calulation: ");
		int head1=head;
		for(int i=0;i<arr.size();i++)
		{
			cur_track=arr.get(i);
			distance=Math.abs(cur_track-head1);  //calculating difference
			System.out.println(cur_track+"-"+head1+"="+distance);
			seek_time+=distance;  //seek_time finding
			head1=cur_track;
		}
		System.out.println("Total distance travelled by head ="+seek_time);
	}
	
	
	public void calculateDifference(node diff[])  //function to calculate difference
    {
		for (int i = 0; i < diff.length; i++)
		{
			diff[i].distance = Math.abs(arr.get(i) - head);
			System.out.println(arr.get(i)+"-"+head+"="+diff[i].distance);
		}
    }

	// find unaccessed track
	// which is at minimum distance from head
	public int findMin(node diff[])
	{
		int index = -1, minimum = Integer.MAX_VALUE;
		
		for (int i = 0; i < diff.length; i++)
		{
			if (!diff[i].accessed && minimum > diff[i].distance) 
			{
				minimum = diff[i].distance;
				index = i;
			}
		}
		return index;
	}

	public void SSTF()               
	{
		if (arr.size() == 0)
		return;
	
	// create array of objects of class node   
		node diff[] = new node[arr.size()];
		
		// initialize array
		for (int i = 0; i < diff.length; i++)
		
		diff[i] = new node();
		
		// count total number of seek operation   
		int seek_count =0;
	
		for (int i = 0; i < arr.size(); i++) 
		{
			calculateDifference(diff);
			
			int index = findMin(diff);
			
			diff[index].accessed = true;
			
			// increase the total count
			seek_count += diff[index].distance;
			
			// accessed track is now new head
			head = arr.get(index);
		}
		System.out.println("\nTotal number of seek operations = "+ seek_count);
	}
	/*public void SSTF()
	{
		ArrayList <Integer> arr1=new ArrayList();
		int flag=0;
		boolean[] accessed=new boolean[accCy];
		int distance=0;
		arr1.add(head);
		arr1.addAll(arr);
		Collections.sort(arr1);
		int seek_time=0;
		if(arr.size()==0)
		{
			return;
		}
		System.out.println(arr1);
		int index=arr1.indexOf(head);
		int head1=head;
		while(true)
		{
			if(Math.abs(head-arr1.get(index-1))<Math.abs(head-arr1.get(index+1))&& arr1.get(0)!=-1)
			{
				System.out.println("hello");
				for(index=index-1;index>=0;index--)
				{
					distance=Math.abs(head1-arr1.get(index));
					seek_time += distance;
					head1=arr1.get(index);
					arr1.set(0, -1);
					flag=1;
				}
				index=arr1.indexOf(head)+1;
			}
			else if(Math.abs(head-arr1.get(index-1)) >= Math.abs(head-arr1.get(index+1)) && arr1.get(arr1.size()-1)!=-1 || flag==1)
			{
				System.out.println("hello1");
				for(index=index+1;index<arr1.size();index++)
				{
					distance=Math.abs(head1-arr1.get(index));
					seek_time += distance;
					head1=arr1.get(index);
					arr1.set(0, arr1.size()-1);
					flag=1;
				}
				index=arr1.indexOf(head)-1;
			}
			if(arr1.get(0)==-1 && arr1.get(arr1.size()-1)==-1)
			{
				System.out.println("hello2");
				break;
			}
		}
		System.out.println("Total distance travelled by head ="+seek_time);
		
	}
	 public int serviceRequests(){
	        int headMovement = 0;
	        int prev = head;
	        int [] rpath = path();
	        for (int i=0; i < rpath.length; i++) {
	            headMovement += Math.abs(rpath[i]-prev);
	            prev = rpath[i];
	        }
	        return headMovement;
	    }
	 public int[] path(){
	       int [] resultPath = new int[arr.size()];
	       int now = head;
	       int [] requests = new int[arr.size()];
	       for (int i = 0; i < arr.size(); i++){
	        requests[i] = arr.get(i);
	    }
	       for (int i = 0; i < resultPath.length; i++){
	        int closest = closest(now, requests);
	        resultPath[i] = closest;
	        now = closest;
	    }
	       return resultPath;
	    }
	   
	    int closest(int k, int[] requests){
	        int min = 5000000;
	        int minPos = -1;
	        for (int i = 0; i < requests.length; i++){
	            if (requests[i] == -1) continue;
	            else if  (Math.abs(k-arr.get(i)) < min) 
	            {
	                minPos = i;
	                min = Math.abs(k-arr.get(i++));           
	            }
	        }
	        int nearestCylinder = requests[minPos];
	        requests[minPos] = -1;
	        return nearestCylinder;
	    }
	   
	    public void println(){
	    System.out.println("SSTF head movement = " + serviceRequests());
	       
	        System.out.print("SSTF Path = ");
	        for(int i: path()){
	            System.out.print(i + " "); 
	        }
	        System.out.println("");
	}
		public int[] sstf()
		{
			int nearIndex=0;
			int nearNum=9999;
			visit=new int[arr.size()];
			for(int i=0;i<arr.size();i++)
			{
				for(int j=0;j<arr.size();j++)
				{
					if(arr.get(j)!=-1)
					{
						if(Math.abs(nearNum-head)>Math.abs(arr.get(j)-head))
						{
							nearNum=arr.get(j);
							nearIndex=j;
						}
					}
				}
				visit[i]=nearNum;
				arr.set(nearIndex, -1);
				head=nearNum;
				nearNum=9999;
			}
			return visit;
		}
		public void print(int visit[])
		{
			double sum=0;
			 System.out.print ("Access sequence:");
			for(int i=0;i<visit.length;i++)
			{
				System.out.print(visit[i]+" ");
				sum=Math.abs(visit[i]-head)+sum;
				head=visit[i];
			}
			System.out.println();
			 System.out.println ("Total number of tracks passed:" + sum);
			 System.out.println ("Average seek length:" + sum / visit.length);
		}*/

}
