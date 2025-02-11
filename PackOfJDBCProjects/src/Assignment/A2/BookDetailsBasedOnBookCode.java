package Assignment.A2;
import java.util.*;
import java.sql.*;

/**
 * Construct JDBC Application to display book details based on book-Code.
 * 
step-1 : Construct DB-Table with name BookDetails69
          (bcode,bname,bauthor,bprice,bqty)
step-2 : Insert min 5 Bookdetails 
step-3 : Construct JDBC Application to display all Book details.


CREATE table BOOKDETAILS69(
BCODE NUMBER primary key,
BNAME VARCHAR2(10),
BAUTHOR VARCHAR2(10),
BPRICE number,
BQTY number);

insert into BOOKDETAILS69 VALUES(&BCODE,'&BNAME','&BAUTHOR',&BPRICE,&BQTY);
 */
public class BookDetailsBasedOnBookCode {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
			
			final String url = "jdbc:oracle:thin:@localhost:1521:xe";
			final String db = "ADVJAVA";
			final String pwd = "DUNESH";
			
			Connection con = DriverManager.getConnection(url,db,pwd);
			Statement st = con.createStatement();
			
			System.out.println("Enter the number book");
			int bcode= sc.nextInt();
		 	sc.nextLine();
			String query="select * from BookDetails69 where bcode="+bcode+"";
			
			ResultSet rs = st.executeQuery(query);
			
			while(rs.next()) {
				System.out.println("Bcode: "+rs.getInt(1)+"\nBook name: "+rs.getString(2)+"\nAuthor: "+rs.getString(3)+"\nPrice: "+rs.getInt(4)+"\nQty: "+rs.getInt(5));
			}
			con.close();
			sc.close();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}

}
