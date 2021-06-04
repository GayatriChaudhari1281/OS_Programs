package OS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PageFaultFunction {
	int fsize;      		//frame size
	int pageSize;			//number of reference string
	Scanner sc=new Scanner(System.in);
	Queue<Integer> frame=new LinkedList<>();  //queue for frame 
	Queue<Integer> q=new LinkedList<>();	
	ArrayList<Integer> arr=new ArrayList<>(); 	//to keep the copy of reference string
	int page_fault;								//page fault variable to store page fault
	
	//function to accept the reference string and fsize and page size
	public void accept()
	{
		System.out.println("Enter the number of frames: ");
		fsize=sc.nextInt();			//accepting the input
		System.out.println("Enter the number of pages in the reference string: ");
		pageSize=sc.nextInt();
		System.out.println("Enter the reference string: ");
		for(int i=0;i<pageSize;i++)		//adding ref string into arr and queue
		{
			int temp=sc.nextInt();
			arr.add(temp);
			q.add(temp);
		}
	}
	
	//FCFS function body
	public int FCFS() {
		page_fault=0;		//to store page fault value
		int page_hit = 0;	//to store page hit
		int[][] dis=new int[fsize+1][pageSize];		//To print the table form storing frame element everytime 
		Queue<Integer> q3=new LinkedList<>();		//to store temporarily the q vqlue
		System.out.println("-----------------------------------------------------------------------------------------------");
		for(int i=0;i<pageSize;i++)		//traversing string completes
		{
			if(frame.contains(q.peek()))		//if frame already contains the element
			{
				page_hit++;			//page hit
				q.poll();			//removing from queue
			}
			else 
			{
				if(frame.size()<fsize)	//if size of frame is less than the fsize
				{
					frame.add(q.peek());	//adding the peek element from sourcce queue to frame
					q.remove();				//removing from source queue
					page_fault++;			//incrementing page fault
				}
				else if(!frame.contains(q.peek()))	//if frame doesn't contains the peek element of src queue and size is greater than fsize
				{
					int val=q.peek();	//peeking the src queue value
					q.remove();			//removing from src queue since it will bw addded to frame queue
					frame.remove();		//removing the old element was inserted in frame queue
					frame.add(val);		//and adding the peek element of queue stored in val 
					page_fault++;		//incrementing page fault
				}
			}
			for(int j=0;j<fsize && !frame.isEmpty();j++)
			{
				dis[j][i]=frame.peek();		//adding all the frame elements to dis array for displaying purpose
				q3.add(frame.poll());		//removing the peek element from frame and adding to q3 queue
			}
			for(int j=0;j<fsize && !q3.isEmpty();j++)  //adding again the in the frame queue from q3
			{
				frame.add(q3.poll());	
			}
			dis[3][i]=page_fault;//last row for pagefault in display array
		}
		display(dis);			//calling display function
		System.out.println("Page hit for FIFO : "+page_hit);	//printing page hit 
		return page_fault;		//returning page fault
	}//function FCFS close

	//LRU function
	public int LRU() 
	{
		Queue<Integer> q2=new LinkedList<>();		//
		Queue<Integer> q3=new LinkedList<>();
		page_fault=0;			//to store page fault
		int page_hit = 0;		//to store number of page hit
		int[][] dis=new int[fsize+1][pageSize];		//display array
		System.out.println("-----------------------------------------------------------------------------------------------");
		for(int i=0;i<pageSize;i++)
		{
			if(q2.contains(q.peek()))			//if frame already contains the element
			{
				q2.remove(q.peek());		//if contains then removing the element from queue 
				q2.add(q.peek());			//and adding again so that the order of popping will be according the recently used
				q.poll();					//and removing the element from source queue
				page_hit++;				//incrementing page hit
			}
			else
			{
				if(q2.size()<fsize)		//if the frame has empty place
				{
					q2.add(q.peek());	//adding the q2 element from source queue
					q.poll();			//removing the element from source queue
					page_fault++;		//incrementing page fault
				}
				else		
				{
					q2.poll();			//removing the least recently used element from frame
					q2.add(q.peek());	//adding the element from  source queue to frame
					page_fault++;		//incrementing page fault
					q.poll();			//removing from the source queue
				}			
			}
			for(int j=0;j<fsize && !q2.isEmpty();j++)	//adding all the frame elements to dis array for displaying purpose
			{
				dis[j][i]=q2.peek();
				q3.add(q2.poll());		//removing the peek element from frame and adding to q3 queue
			}
			for(int j=0;j<fsize && !q3.isEmpty();j++)
			{
				q2.add(q3.poll()); //adding again the in the frame queue from q3
			}
			dis[3][i]=page_fault;		//last row for pagefault in display array
		}
		display(dis);		//calling display function
		System.out.println("Page hit for LRU : "+page_hit);		//printing page hit 
		return page_fault;		//returning page fault
	}//function FCFS close
	
	//Displaying the table 
	public void display(int[][] dis)
	{
		System.out.print("Str ");		//printing the source reference string
		for(int i=0;i<pageSize;i++)
		{
			System.out.print(arr.get(i)+"\t");
		}
		System.out.println("\n-----------------------------------------------------------------------------------------------");
		System.out.print("\nF1"+"\t");		//printing the element from frame1
		for(int i=0;i<pageSize;i++)
		{
			System.out.print(dis[0][i] +"\t");
		}
		System.out.print("\nF2"+"\t");		//printing the element from frame2
		for(int i=0;i<pageSize;i++)
		{
			System.out.print(dis[1][i]+"\t");
		}
		System.out.print("\nF3"+"\t");		//printing the element from frame3
		for(int i=0;i<pageSize;i++)
		{
			System.out.print(dis[2][i]+"\t");
		}
		System.out.println("\n-----------------------------------------------------------------------------------------------");
		System.out.print("\nPF"+"\t");	//printing page fault
		for(int i=0;i<pageSize;i++)
		{
			System.out.print(dis[3][i]+ "\t");
		}
		System.out.println("\n-----------------------------------------------------------------------------------------------");
		System.out.println();
	}
}