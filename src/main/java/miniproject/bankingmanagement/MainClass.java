package miniproject.bankingmanagement;
//import java.text.SimpleDateFormat;
//import java.util.Date;
import java.util.Scanner;


public class MainClass {

	//String period;

	private static Scanner scanner;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Customer customer=new Customer();
		int choice;
		do {
			
			System.out.println("           Welcome to Bank of Niranjani       ");
			System.out.println();
			System.out.println(" 1.Create Customer\n 2.Search Customer\n 3.Create Account\n 4.View Account\n 5.Transcation\n 6.Bank Statement\n 7.Exit");
			scanner = new Scanner(System.in);
			System.out.println("Enter your choice : ");
			choice =scanner.nextInt();
			
			switch(choice)
			{
			case 1 :
				customer.createcustomer();
				break;
			case 2:
				customer.searchCustomer();
				break;
			case 3:
				customer.createAccount();
				break;
			case 4:
				 customer.showAccount();
			    break;
			case 5:
				customer.createTranscation();
				break;
			case 6:
				customer.viewStatement();
				break;
			case 7:
				System.exit(0);
			default:
				System.out.println("Invalid choice !");
				break;
			}
		}
		while(choice!=0);
		
	}
}
