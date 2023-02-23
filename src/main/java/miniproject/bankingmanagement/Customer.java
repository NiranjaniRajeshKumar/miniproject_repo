package miniproject.bankingmanagement;

import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.Date;
import java.util.Scanner;
//import java.text.SimpleDateFormat;


public class Customer {
	
    int acc_no;
	int cust_id;
	//String period;
	PersonalDetails cus_pd=new PersonalDetails();
	ID_Details cus_id_detail=new ID_Details();
	BankAccounts account=new BankAccounts();
	Transcation trans=new Transcation();
	Scanner scanner;
	public Object formatter;
	
	public void createcustomer()
	{
		
    scanner=new Scanner(System.in);
		
		System.out.println("Enter Customer name : ");
		 cus_pd.name =scanner.nextLine();
		
		System.out.println("Enter Customer address1 : ");
		cus_pd.add1=scanner.nextLine();
		
		System.out.println("Enter Customer pincode : ");
		cus_pd.pincode=scanner.nextInt();
		
		System.out.println("Enter customer contact : ");
		 cus_pd.contact=scanner.next();
		
		System.out.println("Enter Customer email address : ");
		 cus_pd.email =scanner.next();
		 
		System.out.println("Enter Customer date of birth(yyyy-mm-dd): ");
		 cus_pd.dob = scanner.next();
		
		System.out.println("Enter Customer gender(Male,Female,Transgender,Agender) : ");
		cus_pd.gender=scanner.next();
		
		System.out.println("Enter the type of ID (AADHAR,DRIVINGLICENSE,PASSPORT,PANCARD,VOTERSID):");
		
		cus_id_detail.ID =scanner.next();
		
		if(cus_id_detail.ID.equalsIgnoreCase("aadhar"))
		{
			System.out.println("Enter Customer aadhar number : ");
			 cus_id_detail.id_num=scanner.next();
		}
		else if(cus_id_detail.ID.equalsIgnoreCase("drivinglicense"))
		{
			System.out.print("Enter drivinglicense number : ");
			cus_id_detail.id_num=scanner.next();
			
			System.out.println("Enter Expiry date (yyyy/mm/dd): ");
			cus_id_detail.expiry_date=scanner.next();
		}
		else if(cus_id_detail.ID.equalsIgnoreCase("passport"))
		{
			System.out.println("Enter passport number : ");
			cus_id_detail.id_num=scanner.next();
			
			System.out.println("Enter Expiry date (yyyy/mm/dd): ");
			cus_id_detail.expiry_date=scanner.next();
		}
		else if(cus_id_detail.ID.equalsIgnoreCase("pancard"))
		{
			System.out.println("Enter pancard number : ");
			cus_id_detail.id_num=scanner.next();
		}
		else if(cus_id_detail.ID.equalsIgnoreCase("votersid"))
		{
			System.out.println("Enter voter's id : ");
			cus_id_detail.id_num=scanner.next();
		}
		else
		{
			System.out.println("Invalid ID");
		}// collect id details
		DatabaseHelper.saveCustomer(this);
	}
	
	public void searchCustomer()
	{
		scanner=new Scanner(System.in);
		System.out.println("Enter Customer ID : ");
		  cust_id=scanner.nextInt();
		DatabaseHelper1.viewCustomer(this);
		
	}
	public void createAccount()
	{
		scanner=new Scanner(System.in);
		System.out.print("Enter Customer ID: ");  
        account.cus_id= scanner.nextInt();  
        System.out.println("Enter Name : ");
        account.name=scanner.next();
        
        System.out.println("Enter Account type (Savings/Current/RD/FD): ");  
       account.acc_type = scanner.next(); 
        
        System.out.println("Enter MinimumBalance (minibalance=1000): ");  
       account.minibalance = scanner.nextDouble(); 
       
        System.out.println("Enter Balance: ");  
       account.balance = scanner.nextDouble(); 
       
       DatabaseHelper1.openAccount(this);
        
	}
	public void showAccount()
	{
		scanner=new Scanner(System.in);
		System.out.println("Enter your Account number : ");
		acc_no=scanner.nextInt();
		DatabaseHelper1.searchAccount(this);
	}

	public  void createTranscation()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		{
			//transcation_date = new Date();
			trans.period = formatter.format(new Date());
			//System.out.println(trans.period);
			 
		
		System.out.println("Enter Account Number : ");
		scanner =new Scanner(System.in);
		trans.acc_no=scanner.nextInt();
		
		System.out.println("Enter Mode of Transcation [Deposit/Withdrawl]: ");
		trans.trans_type=scanner.next();
		
		//DatabaseHelper1.doTranscation(this);
		
		
		if(trans.trans_type.equalsIgnoreCase("deposit"))
		{
			
			System.out.println("Enter the amount you want to deposit: ");
			
			trans.amt = scanner.nextLong();
			DatabaseHelper1.doTranscation(this);
			trans.balance1 = trans.balance + trans.amt; 
			
			//System.out.println("Congratulations ! Deposit done successfully! on "+ trans.period);
			
		}
	      
		else if(trans.trans_type.equalsIgnoreCase("withdrawl"))
		{
			System.out.println("Enter the amount you want to withdraw: ");
			
			trans.amt = scanner.nextLong(); 
			DatabaseHelper1.doTranscation(this);
	        if (trans.balance >=trans. amt) 
	        {  
	            trans.balance1 = trans.balance - trans.amt; 
	            
	            System.out.println("Congratulations!  withdrawl done successfully! ");
	            
	        }
	         else
	         {  
	            System.out.println("Your balance is less than " + trans.amt + "\tTransaction failed...!!" );
	         }
	         
		}
		
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
//		Date transcation_date = new Date();
//		trans.period = formatter.format(transcation_date);
//		System.out.println(trans.period);
//		
		DatabaseHelper1.getTranscation(this);
		
}
}
	public void viewStatement()
	{
		scanner=new Scanner(System.in);
		System.out.println("Enter your Account number : ");
		acc_no=scanner.nextInt();
		DatabaseHelper1.showStatement(this);
	}
}