package OS;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int ch;
		Scanner sc=new Scanner(System.in);
		System.out.println("*** Menu for Banker's Algorithm***"); //menu driven
		
		BankersAlgo obj=new BankersAlgo(); //object of BankersAlgo
		do {
			System.out.println("1. Accept details\n"+ "2.Display details\n"	+ "3.Display safe sequence\n"+ "4.Exit");
			System.out.println("Enter the choice");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:obj.accept();//calling accept function
				break;
			case 2:obj.display(); //calling display function
				break;
			case 3:obj.safeSeq(); //calling safe sequence
			break;
			case 4:System.out.println("End of program");//end of program
			break;
			default:
				System.out.println("Invalid choice");
					break;
			}
		}while(ch!=4);
		

	}

}
