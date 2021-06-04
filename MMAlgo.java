package OS;

import java.util.Scanner;

public class MMAlgo {
	Scanner sc=new Scanner(System.in);
	int NoP,NoH;
	int[] size=new int[50];  //array to store the size of process
	int[] Holes=new int[50];	//array to store the size of Meomory blocks
	int[] flag=new int[50];   //array to check whether process visited or not
	public void accept()  //accepting the input
	{
		System.out.println("Enter no. of memory blocks available: ");
		NoH=sc.nextInt();
		for(int i=0;i<NoH;i++)  //accepting memory block sizes
		{
			System.out.println("Enter the block id : "+i);
			Holes[i]=sc.nextInt();
			flag[i]=0;
		}
		System.out.println("--------------------------------------------------");
		System.out.println("Enter the number of process: ");
		NoP=sc.nextInt();
		
		for(int i=0;i<NoP;i++)  //accepting process size
		{
			System.out.println("Enter the size of process "+i+ " in KB:");
			size[i]=sc.nextInt();
		}
		System.out.println("--------------------------------------------------");
	}
	
	
	public void display()  //to display the entered data
	{
		System.out.println("Entered Data");
		for(int i=0;i<NoH;i++)
		{
			System.out.println("Memory Block with id "+i+"Having "+Holes[i]+" in KB");
		}
		System.out.println("--------------------------------------------------");
		for(int i=0;i<NoP;i++)
		{
			System.out.println("Size of Process "+i+" is: "+size[i]);
		}
		System.out.println("--------------------------------------------------");
	}
	
	
	public void bestFit()   //bestfit algorithm
	{
		for(int i=0;i<NoH;i++)  //initialize the flag
		{
			flag[i]=0;
		}
		int temp;
		int[] Holes1=new int[50];   //to store the storted data
		for(int i=0;i<NoH;i++)
		 {
			Holes1[i]=Holes[i];
		 }
		 for (int i = 0; i <NoH; i++) {   //ascending order sorting 
	            for (int j = i+1; j <NoH; j++) {   
	               if(Holes1[i] > Holes1[j]) {  
	                   temp = Holes1[i];  
	                   Holes1[i] = Holes1[j];  
	                   Holes1[j] = temp;  
	               }   
	            }   
	        }  
		 for(int i=0;i<NoP;i++)  //traversing one by one process
			{
				for(int j=0;j<NoH;j++)  //traversing each block
				{
					if(size[i]<Holes1[j] && flag[j]==0)   //if process not allocated
					{
						flag[j]=1;  //process allocated
						System.out.println("Process "+i+" Is allocated to hole with size"+ Holes1[j]);
						break;
					}
				}
			}
		 System.out.println("--------------------------------------------------");
	}
	
	
	public void worstFit()  //worst fit algorithm
	{
		for(int i=0;i<NoH;i++)   //initialization 
		{
			flag[i]=0;
		}
		int[] Holes1=new int[NoH];
		for(int i=0;i<NoH;i++)  //storing holes to holes1 
		 {
			Holes1[i]=Holes[i];
		 }
		int temp;
		 for (int i = 0; i < NoH; i++) //sorting in descending
		 {   
	            for (int j = i+1; j <NoH; j++) 
	            {   
	               if(Holes1[i] < Holes1[j]) 
	               {  
	                   temp = Holes1[i];  
	                   Holes1[i] = Holes1[j];  //swapping 
	                   Holes1[j] = temp;  
	               }
	            }   
	        }  
		 for(int i=0;i<NoP;i++)
			{
				for(int j=0;j<NoH;j++)
				{
					if(size[i]<Holes1[j]&& flag[j]==0)  
					{
						flag[j]=1;
						System.out.println("Process "+i+" Is allocated to hole with size"+ Holes1[j]);
						break;
					}
				}
			}
		 System.out.println("--------------------------------------------------");
	}

	public void firstFit() 
	{
		for(int i=0;i<NoH;i++)  //initialize the memory block 
		{
			flag[i]=0;
		}
		for(int i=0;i<NoP;i++)    //traversing the process
		{
			for(int j=0;j<NoH;j++)		//traversing the memory block
			{
				if(size[i]<Holes[j] && flag[j]==0)  //checking whether size is efficient
				{
					flag[j]=1;
					System.out.println("Process "+i+" Is allocated to Block id "+j+" with size "+Holes[j]);
					break;
				}
			}
		}
		System.out.println("--------------------------------------------------");
	}

}
