package miniproject.bankingmanagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class DatabaseHelper {
	
	
	
	public static void saveCustomer(Customer cust)
	{
		
	
	try
	{
		//1
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		
		//2
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Banking","root","Nielniru@007");
		
		
		//3
		String query="insert into banking.personaldetails(cus_name,cus_add1,cus_pincode,cus_mobno,cus_email,cus_dob,cus_gender) values(?,?,?,?,?,?,?)";
		//String query="insert into banking.personaldetails(cus_name,cus_add1,cus_pincode,cus_mobno,cus_email,cus_dob,cus_gender) values("+cust.cus_pd.name+
		//		","+cust.cus_pd.add1+","+cust.cus_pd.add2+","+cust.cus_pd.pincode+","+cust.cus_pd.contact+","+cust.cus_pd.email+","+cust.cus_pd.dob+","+cust.cus_pd.gender+")";
		
		String query1="insert into banking.ID_details(id_type,id_num,expiry_date) values(?,?,?)";

		
		PreparedStatement ps=con.prepareStatement(query);
		PreparedStatement ps1=con.prepareStatement(query1);
		
		
		
		ps.setString(1, cust.cus_pd.name);
		ps.setString(2, cust.cus_pd.add1);
		ps.setInt(3,cust.cus_pd.pincode);
		ps.setString(4,cust.cus_pd.contact);
		ps.setString(5,cust.cus_pd.email);
		ps.setString(6,cust.cus_pd.dob);
		ps.setString(7, cust.cus_pd.gender);
		ps1.setString(1,cust.cus_id_detail.ID);
		ps1.setString(2,cust.cus_id_detail.id_num);
        ps1.setString(3, cust.cus_id_detail.expiry_date);
		
		
		//4
		int count=ps.executeUpdate();
		
		if(count>0)
		{
			
			System.out.println(" personal details inserted successfully !");
		}
		else
		{
			System.out.println("Oops! Unable to complete the registration. Please try again!!");
		}
		
		int count1=ps1.executeUpdate();
		if(count1>0)
		{
			System.out.println(" ID details inserted successfully !\n Customer created Successfully!");
		}
		else
		{
			System.out.println("Oops Id details cannot inserted");
		}
		//5
		ps.close();
		ps1.close();
		Statement stmt=con.createStatement();
		
		String query2="SELECT cus_id FROM id_details ORDER BY cus_id DESC  LIMIT 1";
		ResultSet rs=stmt.executeQuery(query2);
		while(rs.next())
		{
			System.out.print(" Customer Id : "+rs.getInt("cus_id"));
		}
		rs.close();
		stmt.close();
		//6 fetching customer id;
		con.close();	
	}
		
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
}
	
}