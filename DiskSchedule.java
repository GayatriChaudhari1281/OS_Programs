package OS;
import java.util.Scanner;

public class DiskSchedule {
	
	public static void main(String[] args) {
		int ch;
		DiskSchedulingAlgo obj=new DiskSchedulingAlgo(); //creating object of class
		
		obj.accept(); //calling accept function
		System.out.println();
		obj.display();  //calling display function
		System.out.println();
		Scanner sc=new Scanner(System.in);
		do
		{
			System.out.println("\n***DISK SCHEDULING***");
			System.out.println("\n1:First Come,First Serve(FCFS)");
			System.out.println("2:Shortest-Seek-Time-first(SSTF)");
			System.out.println("3:Exit Menu\n");
			System.out.println("Enter your Choice:");
			
			ch=sc.nextInt(); //entering the choice
			switch(ch)
			{
				case 1:
					obj.FCFS(); //calling FCFS methode
					break;
				case 2:
					obj.SSTF();  //calling SSTF methods
					break;
				case 3:
					System.out.println("END OF PROGRAM\n");
					break;
				default:
					System.out.println("Invalid choice\n");
					break;
				
			}
		}while(ch!=3);

	}

}
