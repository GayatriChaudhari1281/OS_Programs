/*************************************************
Name:Gayatri Suresh Chaudhari
RollNum:2321
CNUM:C22019221323
Assignment #8: (Group-‘B4’)
Title: Write a Java program to implement following page replacement algorithms: First In First Out (FIFO) and Least Recently Used (LRU)
************************************************/

package OS;
import java.util.Scanner;

public class Page_Fault {

	public static void main(String[] args) {
		PageFaultFunction obj=new PageFaultFunction();	//creating the object of class
		int fault;
		Scanner sc=new Scanner(System.in);
		int ch;
		do
		{		//Menu Driven
			System.out.println("Enter\n1:First in First Out\n2:Least recently used\n3:Exit");
			System.out.println("Enter your choice from above list");
			ch=sc.nextInt();
			System.out.println("-----------------------------------------------------------------------------------------------");
			switch(ch)
			{
			case 1:
				obj.accept();
				fault=obj.FCFS();		//calling fcfs function
				System.out.println("-----------------------------------------------------------------------------------------------");
				System.out.println("Page Faults for FIFO "+fault);
				System.out.println("-----------------------------------------------------------------------------------------------");
				break;
			case 2:
				obj.accept();
				fault=obj.LRU();		//calling lru function
				System.out.println("-----------------------------------------------------------------------------------------------");
				System.out.println("Page Faults for LRU "+fault);
				System.out.println("-----------------------------------------------------------------------------------------------");
				break;
			case 3:
				System.out.println("EXIT");		//exit
				System.out.println("-----------------------------------------------------------------------------------------------");
				break;
			default:System.out.println("INVALID INPUT!!!");
			System.out.println("-----------------------------------------------------------------------------------------------");
				break;
			}
		}while(ch!=3);
	}

}
/****************************************************
output:
Enter
1:First in First Out
2:Least recently used
3:Exit
Enter your choice from above list
1
-----------------------------------------------------------------------------------------------
Enter the number of frames: 
3
Enter the number of pages in the reference string: 
12
Enter the reference string: 
144
11
144
236
144
168
144
11
179
11
12
263
-----------------------------------------------------------------------------------------------
Str 144	11	144	236	144	168	144	11	179	11	12	263	
-----------------------------------------------------------------------------------------------

F1	144	144	144	144	144	11	236	168	144	144	11	179	
F2	0	11	11	11	11	236	168	144	11	11	179	12	
F3	0	0	0	236	236	168	144	11	179	179	12	263	
-----------------------------------------------------------------------------------------------

PF	1	2	2	3	3	4	5	6	7	7	8	9	
-----------------------------------------------------------------------------------------------

Page hit for FIFO : 3
-----------------------------------------------------------------------------------------------
Page Faults for FIFO 9
-----------------------------------------------------------------------------------------------
Enter
1:First in First Out
2:Least recently used
3:Exit
Enter your choice from above list
2
-----------------------------------------------------------------------------------------------
Enter the number of frames: 
3
Enter the number of pages in the reference string: 
12
Enter the reference string: 
144
11
144
236
144
168
144
11
179
11
12
263
-----------------------------------------------------------------------------------------------
Str 144	11	144	236	144	168	144	11	179	11	12	263	
-----------------------------------------------------------------------------------------------

F1	144	144	11	11	11	236	236	168	144	144	179	11	
F2	0	11	144	144	236	144	168	144	11	179	11	12	
F3	0	0	0	236	144	168	144	11	179	11	12	263	
-----------------------------------------------------------------------------------------------

PF	1	2	2	3	3	4	4	5	6	6	7	8	
-----------------------------------------------------------------------------------------------

Page hit for LRU : 4
-----------------------------------------------------------------------------------------------
Page Faults for LRU 8
-----------------------------------------------------------------------------------------------
Enter
1:First in First Out
2:Least recently used
3:Exit
Enter your choice from above list
4
-----------------------------------------------------------------------------------------------
INVALID INPUT!!!
-----------------------------------------------------------------------------------------------
Enter
1:First in First Out
2:Least recently used
3:Exit
Enter your choice from above list
3
-----------------------------------------------------------------------------------------------
EXIT
-----------------------------------------------------------------------------------------------
*****************************************************************/