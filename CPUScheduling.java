package OS;

import java.util.Scanner;

public class CPUScheduling {

	public static void main(String[] args) {
		int ch;
		CPUAlgo obj=new CPUAlgo(); //creating object of class
	
		System.out.println();
		Scanner sc=new Scanner(System.in);
		do
		{   //Menu Driven Program
			System.out.println("\n***DISK SCHEDULING***");
			System.out.println("\n1:First Come,First Serve(FCFS)");
			System.out.println("2:Shortest-Remaining-Time-first(SRTF)");
			System.out.println("3:Exit Menu\n");
			System.out.println("Enter your Choice:");
			ch=sc.nextInt(); //entering the choice
			System.out.println("--------------------------------------------------");
			switch(ch)
			{
				case 1:
					obj.accept();//calling FCFS methode
					obj.calculate();
					obj.displayTable();
					obj.avgTime();
					break;
				case 2:
					obj.accept();
					obj.SRTF();  //calling SSTF methods
					break;
				case 3:
					System.out.println("END OF PROGRAM\n");
					System.out.println("--------------------------------------------------");
					break;
				default:
					System.out.println("Invalid choice\n");
					System.out.println("--------------------------------------------------");
					break;
				
			}
		}while(ch!=3);

	}

}

