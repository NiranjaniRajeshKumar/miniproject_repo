package miniproject.bankingmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class DatabaseHelper1 {
	
	
	public static void viewCustomer(Customer cust)
	{
		
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","Nielniru@007");
					
					Statement stmt=con.createStatement();
					
					String query="SELECT cus_id, cus_name,cus_add1,cus_pincode,cus_mobno, cus_email,cus_DOB,cus_gender from personaldetails where cus_id="+cust.cust_id;
					//String query3="SELECT personaldetails.cus_id, personaldetails.cus_name,personaldetails.cus_add1,personaldetails.cus_pincode,personaldetails.cus_mobno,personaldetails.cus_email,personaldetails.cus_DOB,personaldetails.cus_gender,id_details.id_type,id_details.id_num,id_details.expiry_date from personaldetails inner join id_details on "+cust.cust_id+"="+cust.cust_id+" ";
					
					System.out.println("SELECT personaldetails.cus_id, personaldetails.cus_name,personaldetails.cus_add1,personaldetails.cus_pincode,personaldetails.cus_mobno,personaldetails.cus_email,personaldetails.cus_DOB,personaldetails.cus_gender,id_details.id_type,id_details.id_num,id_details.expiry_date from personaldetails inner join id_details on "+cust.cust_id+"=id_details.cus_id");
					
					ResultSet rs=stmt.executeQuery(query);
					while(rs.next())
					{
						System.out.print("\nCustomer Id: "+rs.getInt("cus_id")+"\nName : "+rs.getString("cus_name")+"\nAddress : "+rs.getString("cus_add1")+"\npincode : "+rs.getString("cus_pincode")+"\nContact : "+rs.getString("cus_mobno")+"\nEmail : "+rs.getString("cus_email")+"\nDOB : "+rs.getString("cus_dob")+"\nGender: "+rs.getString("cus_gender"));//+"Customer Id type: "+rs.getString("id_type")+"\nId Number : "+rs.getString("id_num")+"\nExpiry Date : "+rs.getString("expiry_date"));
					}
						
					
					
					String query1="select id_type,id_num,expiry_date from ID_details where cus_id ="+cust.cust_id ;
					ResultSet rs1= stmt.executeQuery(query1);
					while(rs1.next())
					{
						System.out.println("\nCustomer Id type: "+rs1.getString("id_type")+"\nId Number : "+rs1.getString("id_num")+"\nExpiry Date : "+rs1.getString("expiry_date"));
					}
					
					rs1.close();
					rs.close();
					stmt.close();
					con.close();
				
					
					
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}

	public static void openAccount(Customer cust)
	{  
		try
		{
			//1
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking","root","Nielniru@007");
        String query4="insert into banking.account_details(cus_id,cus_name,acctype,minimumbalance,balance) values(?,?,?,?,?)";
  
        PreparedStatement ps1 =con1.prepareStatement(query4);
        
		ps1.setInt(1,cust.account.cus_id);
		ps1.setString(2, cust.account.name);
		ps1.setString(3,cust.account.acc_type);
		ps1.setDouble(4, cust.account.minibalance);
		ps1.setDouble(5,cust.account.balance);
		
		int count=ps1.executeUpdate();
		if(count>0)
		{
			
			System.out.println(" Congratulations "+ cust.account.name +"\n Account Created Succesfully  \n Account Numer generated!");
		}
		else
		{
			System.out.println("Oops! Unable to complete the registration. Please try again!!");
		}
		//5
		ps1.close();
		Statement stmt=con1.createStatement();
		
		String query5="SELECT accno FROM account_details ORDER BY accno DESC  LIMIT 1";
		ResultSet rs=stmt.executeQuery(query5);
		while(rs.next())
		{
			//System.out.println("\nCustomer id : \n"+rs.getInt(1)+"\nCustomer Name : \n"+rs.getString(2)+"\n Customer Account number :\n "+rs.getInt(3)+"\n Account Type : \n"+rs.getString(4)+"\nMinimumBalance :\n "+rs.getDouble(5)+"\nBalance :\n "+rs.getDouble(6));
			System.out.println(" Customer Account number : "+rs.getInt("accno"));
		}
		rs.close();
		stmt.close();
		con1.close();
		
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public static void searchAccount(Customer cust)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","Nielniru@007");
			
			Statement stmt=con.createStatement();
			String query6="select * from account_details where accno ="+cust.acc_no;
			ResultSet rs=stmt.executeQuery(query6);
			while(rs.next())
			{
				
				System.out.print("\nCustomer id : "+rs.getInt(1)+"\nCustomer Name : "+rs.getString(2)+"\nCustomer Account number : "+rs.getInt(3)+"\nAccount Type : "+rs.getString(4)+"\nMinimumBalance : "+rs.getDouble(5)+"\nBalance : "+rs.getDouble(6));
			}
			rs.close();
			stmt.close();
			con.close();
			
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		
	}
	
	public static void doTranscation(Customer cust)
	{
		
		try
		{
			//1
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking","root","Nielniru@007");
//        String query4="insert into banking.Transcation(accno,transtype,period,balance) values(?,?,?,?)";
//  
//        PreparedStatement ps1 =con1.prepareStatement(query4);
//        
//		ps1.setInt(1,cust.trans.acc_no);
//		ps1.setString(2, cust.trans.trans_type);
//		ps1.setString(3,cust.trans.period);
//		ps1.setDouble(4, cust.trans.balance);
//		
//		
//		int count=ps1.executeUpdate();
//		if(count>0)
//		{
//			
//			System.out.println(" Congratulations "+ cust.trans.trans_type +" is done Successfully");
//		}
//		else
//		{
//			System.out.println("Oops! Unable to complete Transcation ! Please try again!!");
//		}
//		
//		ps1.close();
//		
		Statement stmt=con1.createStatement();
		
		String query5="SELECT balance FROM account_details where accno = "+cust.trans.acc_no;
		ResultSet rs=stmt.executeQuery(query5);
		//cust.trans.balance=rs.getDouble("balance");
		while(rs.next())
		{
			cust.trans.balance=rs.getDouble("balance");
		System.out.println("Your  before  balance : "+ cust.trans.balance);
		}
		rs.close();
		stmt.close();
		con1.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();

		}
	}
	
	public static void getTranscation(Customer cust)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con1=DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking","root","Nielniru@007");
		 String query5="update account_details set balance="+cust.trans.balance1+"where accno ="+cust.trans.acc_no+" ";
		 String query4="insert into banking.Transcation(accno,transtype,Amount,period,balance) values(?,?,?,?,?)";
		 PreparedStatement pstm = con1.prepareStatement(query5);
		// PreparedStatement ps =con1.prepareStatement(query5);
		 
		 pstm.executeUpdate();
		  
	        PreparedStatement ps1 =con1.prepareStatement(query4);
	        
			ps1.setInt(1,cust.trans.acc_no);
			ps1.setString(2, cust.trans.trans_type);
			ps1.setDouble(3, cust.trans.amt);
			ps1.setString(4,cust.trans.period);
			ps1.setDouble(5, cust.trans.balance1);
			
			
			int count=ps1.executeUpdate();
			if(count>0)
			{
				System.out.println("your after  balance : "+cust.trans.balance1);
			}
			else
			{
				System.out.println("Oops! Unable to complete Transcation ! Please try again!!");
			}
			
		pstm.close();
		ps1.close();
		con1.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();

		}
	}
	
	public static void showStatement(Customer cust)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/banking","root","Nielniru@007");
			
			Statement stmt=con.createStatement();
			String query6="select * from transcation where accno ="+cust.acc_no;
			ResultSet rs=stmt.executeQuery(query6);
			while(rs.next())
			{
				
				System.out.print("\nAccount Number : "+rs.getInt(1)+"\nTranscation Mode : "+rs.getString(2)+"\nAmount : "+rs.getDouble(3)+"\nTranscation Date and Time : "+rs.getTimestamp(4)+"\nTotal Balance : "+rs.getDouble(5));
			}
			rs.close();
			stmt.close();
			con.close();
			
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
	}
}

