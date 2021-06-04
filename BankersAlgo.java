package OS;
import java.util.Scanner;

class BankersAlgo
{  
	//array declaration
	int noP,noR;//noP=number of process and noR=number of resources
	int[] maxTR=new int[30]; //to store total number of resources
	int[][] maxR=new int [30][30];  //to store maximum resources require to each process
	int[][] allocR=new int [30][30]; //to store  total number allocated resources to each process
	int[][] needR=new int[30][30];  //to store how much more resources will require for each process
	int[] availR=new int[30];  //to store total resources available
	public void accept()
	{
		int sum = 0;  //to calculate avialable resources
		Scanner sc=new Scanner(System.in);  //scanner class object creation
		
		System.out.println("Enter the number of processes\n");
		noP=sc.nextInt(); //taking number of process
		
		System.out.println("Enter the number of resources\n");
		noR=sc.nextInt(); //accepting number of resources
		
		//accepting the total number of instances are there for each resource
		System.out.println("Enter the number of instances for each resource");
		for(int i=0;i<noR;i++)//for each resource  
		{
			System.out.print("for resource R"+i+":");
			maxTR[i]=sc.nextInt();
		}
		
		//accepting the total number of resources will require for each process
		System.out.println("Enter the elements of maximum matrix");
		for(int i=0;i<noP;i++)
		{
			System.out.print("For process P"+i+":");
			for(int j=0;j<noR;j++)//for each resource  
			{
				maxR[i][j]=sc.nextInt();
			}
			System.out.println();
		}
		
		//accepting the total number of resources are allocated to each process
		System.out.println("Enter the elements of allocation matrix");
		for(int i=0;i<noP;i++)
		{
			System.out.print("For process P"+i+":");
			for(int j=0;j<noR;j++)//for each resource  
			{
				allocR[i][j]=sc.nextInt();
			}
			System.out.println();
		}
		
		////calculating the total number of instances available for each resource
		for(int i=0;i<noR;i++)//for each resource  
		{
			sum=0;
			for(int j=0;j<noP;j++)// for each process  
			{
				sum+=allocR[j][i];
			}
			availR[i]=maxTR[i]-sum;
		}
		
		//calculating how uch more instances of resources will require to each process
		for (int i = 0 ; i <noP ; i++){    // for each process  
            for (int j = 0 ; j < noR ; j++){  //for each resource  
                needR[i][j] = maxR[i][j] - allocR[i][j];  
            }  
        }  
		
	}

	public void display() //function to display
	{
		System.out.println("Process\t\tAllocation\tMax\t\tNeed\t\tAvailable");
		System.out.println("\t\t\t\t\t\t\t\t"+availR[0]+" "+availR[1]+" "+availR[2]);
		for(int i=0;i<noP;i++)
		{
			System.out.print("P"+i+"\t\t");
			System.out.print(allocR[i][0]+" "+allocR[i][1]+" "+allocR[i][2]+"\t\t");
			System.out.print(maxR[i][0]+" "+maxR[i][1]+" "+maxR[i][2]+"\t\t");
			System.out.print(needR[i][0]+" "+needR[i][1]+" "+needR[i][2]+"\t\t");
			System.out.println("");
		}
	}

public void safeSeq() //to print the safe sequence
{
	int[] safe=new int[50]; //store the safe process number
	boolean[] finish=new boolean[50];  //store the process has finished or not
	int count=0;
	boolean flag=false;
	for(int i=0;i<noP;i++)//initializing the finish array with false
	{
		finish[i]=false;
	}
	int y=0;
	for(int k=0;k<5;k++) //to traverse the process until gets executed
	{
		for(int i=0;i<noP;i++)
		{
			if(finish[i]==false)//if process is not finished
			{
				flag=false;
				for(int j=0;j<noR;j++) //traversing the resources for each process
				{
					if(needR[i][j]>availR[j])//if need is greater than available
					{
						flag=true;
						break;
					}
				}
				if(flag==false)
				{
					safe[count++]=i;
					for(y=0;y<noR;y++) //empty the allocated resources and making available
					{
						availR[y]+=allocR[i][y];
					}
					finish[i]=true;
				}
			}
		}
		if(count==noP) //if all process are traversed
		{
			break;
		}
	}
	if(flag==true) //if process unsafe
	{
		System.out.println("Following  is not the safe sequence");
		return;
	}
	else //if process safe
	{
		System.out.println("Following  is the safe sequence");
		for(int i=0;i<noP-1;i++)
		{
			System.out.print("P"+safe[i]+"->");
		}
		System.out.println("P"+safe[noP-1]);

	}
		
}
}

