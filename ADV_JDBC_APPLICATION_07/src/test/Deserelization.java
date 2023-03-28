package test;

import java.io.*;
import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Deserelization 
{
      public static void main(String[] args) 
      	{
    	  try 
  		{
  			Scanner sc = new Scanner(System.in);
  			Class.forName("oracle.jdbc.driver.OracleDriver");
  			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","c##Coder","coder");
  			PreparedStatement Ps = con.prepareStatement("select * from BINARYTAB51 where id =?");
  			
  			System.out.print("Enter The ID : ");
  			String id = sc.nextLine(); 
  			Ps.setString(1, id);
  			
  			ResultSet rs = Ps.executeQuery();
  			if(rs.next())
  			{
  				Blob b=rs.getBlob(2);
  				byte by[]=b.getBytes(1, (int)b.length());
  				System.out.print("Enter The fPath and fName For Deserializable(destinaton) : ");
  				File f =new File(sc.nextLine());
  				
  				FileOutputStream fos = new FileOutputStream(f);
  				fos.write(by);
  				System.out.println("Deserializable Successfully !!!!!!!!!!");
  		        fos.close();
  			}
  			else
  			{
  				System.out.println("Invalid ID !!!!!!!!!!!!!!!");
  			}
  			
  			System.out.print("Enter The Deserializable fPath and fName: ");
  			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(sc.nextLine()));
  			TransLog tobj1= (TransLog)ois.readObject();
  			
  			System.out.println("Home Account Number :"+tobj1.gethAccNo());
  			System.out.println("Benificiary Account Number :"+tobj1.getbAccNo());
  			System.out.println("Amount :"+tobj1.getAmt());
  			System.out.println("Date And Time :"+tobj1.getDateTime());
  		
  			con.close();
  		}
  		catch(Exception e)
  		{
  			e.printStackTrace();
  		}
      	}
}
