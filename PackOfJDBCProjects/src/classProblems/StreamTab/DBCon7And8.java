package classProblems.StreamTab;
import java.io.*;
import java.sql.*;
import java.util.Scanner;
/*
 * Storing Image to data base product
 * 
 create table StreamTab69(
 id varchar2(10),
 mfile Blob,
 primary key(id));
 
 
 input:
 C:\MyWorld\ED\JAVA 37\05 ADV JAVA\wa.jpg
 */
class Image{
	static Scanner sc = new Scanner(System.in);
	public static void storeToDataBase(Connection con) throws SQLException, FileNotFoundException {
		
		PreparedStatement ps = con.prepareStatement("insert into StreamTab69 values(?,?)");
		System.out.println("Enter the user-id: "); String id = sc.nextLine();
		System.out.println("Enter the filePath with fileName(Source):"); String fPath = sc.nextLine();
		File f = new File(fPath);
		if(f.exists()) {
			FileInputStream fis = new FileInputStream(f);
			
			ps.setString(1, id);
			ps.setBinaryStream(2, fis,f.length());
			
			if(ps.executeUpdate()>0) {
				System.out.println("Image Stored successfully");
			}
		}
		else {
			System.out.println("Invalid file path or fname");
		}
	}
	
	public static void retriveFromDataBase(Connection con) throws SQLException, IOException{
		PreparedStatement ps = con.prepareStatement("select * from StreamTab69 where id=?");
		System.out.println("Enter the id to retrive images: ");
		ps.setString(1, sc.nextLine());
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			Blob b = rs.getBlob(2);
			byte by[] = b.getBytes(1,(int)b.length());
			
			System.out.println("Enter the fPath with name to store image: ");
			String fPath = sc.nextLine();
			File f = new File(fPath);
			FileOutputStream fos =new FileOutputStream(f);
			fos.write(by);
			System.out.println("Image Retrived Succesfully");
			fos.close();
		}
		else {
			System.err.println("Invalid id...");
		}
	}
	/**
	 * 
O/P:
Enter the id to retrive images: 
1
Enter the fPath with name to store image: 
C:\MyWorld\WAAP.JPG
Image Retrived Succesfully
	 */
	
	
}
public class DBCon7And8 {

	public static void main(String[] args) {
		try {
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ADVJAVA","DUNESH");
			//Image.storeToDataBase(con);
			Image.retriveFromDataBase(con);
			
			con.close();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
