package OS;

import java.util.Scanner;

public class MemoryManagement {

	public static void main(String[] args) {
		int ch;
		MMAlgo obj=new MMAlgo(); //creating object of class
	
		System.out.println();
		Scanner sc=new Scanner(System.in);
		obj.accept();
		obj.display();
		do
		{   //Menu Driven Program
			System.out.println("\n***Memory Management***");
			System.out.println("\n1:First Fit");
			System.out.println("2:Worst fit");
			System.out.println("3:Best fit");
			System.out.println("4:Exit Menu\n");
			System.out.println("Enter your Choice:");
			ch=sc.nextInt(); //entering the choice
			System.out.println("--------------------------------------------------");
			
			switch(ch)
			{
				case 1:obj.firstFit(); //calling first fit function
					break;
				case 2:obj.worstFit();  //calling worst fit function
					
					break;
				case 3:obj.bestFit();   //calling bestfit function
					break;
				case 4:
					System.out.println("END OF PROGRAM\n");
					System.out.println("--------------------------------------------------");
					break;
				default:
					System.out.println("Invalid choice\n");
					System.out.println("--------------------------------------------------");
					break;
				
			}
		}while(ch!=4);


	}

}
/******************************************************
 * output:
 * 
Enter no. of memory blocks available: 
5
Enter the block id : 0
100
Enter the block id : 1
500
Enter the block id : 2
200
Enter the block id : 3
300
Enter the block id : 4
600
--------------------------------------------------
Enter the number of process: 
4
Enter the size of process 0 in KB:
212
Enter the size of process 1 in KB:
417
Enter the size of process 2 in KB:
112
Enter the size of process 3 in KB:
426
--------------------------------------------------
Entered Data
Memory Block with id 0Having 100 in KB
Memory Block with id 1Having 500 in KB
Memory Block with id 2Having 200 in KB
Memory Block with id 3Having 300 in KB
Memory Block with id 4Having 600 in KB
--------------------------------------------------
Size of Process 0 is: 212
Size of Process 1 is: 417
Size of Process 2 is: 112
Size of Process 3 is: 426
--------------------------------------------------

***Memory Management***

1:First Fit
2:Worst fit
3:Best fit
3:Exit Menu

Enter your Choice:
1
--------------------------------------------------
Process 0 Is allocated to Block id 1 with size 500
Process 1 Is allocated to Block id 4 with size 600
Process 2 Is allocated to Block id 2 with size 200
--------------------------------------------------

***Memory Management***

1:First Fit
2:Worst fit
3:Best fit
3:Exit Menu

Enter your Choice:
2
--------------------------------------------------
Process 0 Is allocated to hole with size600
Process 1 Is allocated to hole with size500
Process 2 Is allocated to hole with size300
--------------------------------------------------

***Memory Management***

1:First Fit
2:Worst fit
3:Best fit
3:Exit Menu

Enter your Choice:
3
--------------------------------------------------
Process 0 Is allocated to hole with size300
Process 1 Is allocated to hole with size500
Process 2 Is allocated to hole with size200
Process 3 Is allocated to hole with size600
--------------------------------------------------

***Memory Management***

1:First Fit
2:Worst fit
3:Best fit
3:Exit Menu

Enter your Choice:
4
--------------------------------------------------
END OF PROGRAM

--------------------------------------------------
****************************************************/
