package Assignment.A5.fileManagement;

import java.sql.*;
import java.io.*;
import java.util.*;

/*
 * Assignment-5:
step-1 : Create table with name UserStream69
             (phno,name,mid,resume)
             Primary Key : phno

Program-1 : Construct JDBC Application to store resume
Program-2 : Construct JDBC Application to dispaly details based on PhNO.


CREATE TABLE USERSTREAM69(
PHNO NUMBER,
NAME VARCHAR2(10),
MID VARCHAR2(20),
RESUME BLOB,
PRIMARY KEY (PHNO)
);
 */
public class UserStream69 {
	static Scanner sc = new Scanner(System.in);
	public static void storeImage(Connection con) throws SQLException, FileNotFoundException {
		PreparedStatement ps = con.prepareStatement("insert into UserStream69 values(?,?,?,?)");
		System.out.println("Enter the Name: "); String name = sc.nextLine();
		System.out.println("Enter the mailId: "); String mid =sc.nextLine();
		System.out.println("Enter the phone Number: ");Long phno = Long.parseLong(sc.nextLine());
		System.out.println("Enter the filePath with fileName: "); String fPath = sc.nextLine();
		File f = new File(fPath);
		if(f.exists()) {
			
			FileInputStream fis = new FileInputStream(f);
			
			ps.setLong(1, phno);
			ps.setString(2, name);
			ps.setString(3, mid);
			ps.setBinaryStream(4, fis, f.length());
			
			if(ps.executeUpdate()>0) {
				System.out.println("User Details Updated successfully...");
			}
			else {
				System.out.println("Invalid file Path or fname");
				
			}
		}
		
	}
	public static void extractImage(Connection con) throws SQLException, IOException {
		PreparedStatement ps = con.prepareStatement("select * from UserStream69 where phno=?");
		System.out.println("Enter the PhoneNumber: "); Long phno = Long.parseLong(sc.nextLine());
		ps.setLong(1, phno);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			Blob b = rs.getBlob(4);
			byte by [] = b.getBytes(1,(int)b.length());
			
			System.out.println("Enter the fpath with name:");
			String fpath = sc.nextLine();
			File f = new File(fpath);
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(by);
			System.out.println("Retrived successfully");
			fos.close();
			
		}
		else {
			System.out.println("Invalid phone no");
		}
		
		
	}
	
}
