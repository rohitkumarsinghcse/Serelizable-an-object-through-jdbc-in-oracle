package test;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
 

public class Serelization
{
	public static void main(String[] args) 
    {
		TransLog tobj = new TransLog();
		try 
		{
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\Adv JAVA\\ADV_JDBC_APPLICATION_07\\src\\test\\Serelizable\\file.ser") ); 
			oos.writeObject(tobj);
			
			Scanner sc = new Scanner(System.in);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##Coder","coder");
			PreparedStatement Ps = con.prepareStatement("insert into BINARYTAB51 values (?,?)");
			
			System.out.print("Enter The ID : ");
			String id = sc.nextLine();
			
			Ps.setString(1, id);
			
			System.out.print("Enter The Serializable Path Or Name Of The File (Source) : ");
			File f = new File (sc.nextLine());
			
			if(f.exists())
			{
				FileInputStream fis = new FileInputStream(f);
				Ps.setBinaryStream(2, fis,f.length());
				
				int k =Ps.executeUpdate();
				if(k>0)
				{
					System.out.println("Serializable Done !!!!!!!!!!!!");
				}
			}
			else
			{
				System.out.println("Invalid Serializable File Path Or Name !!!!!!!!!!!!!!!");
			}
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
    }
}
