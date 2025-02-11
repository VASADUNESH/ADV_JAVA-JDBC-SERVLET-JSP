package Assignment.A1;

import java.sql.*;

/**
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

public class BookDetails69 {

	public static void main(String[] args) {
		
		try {
			
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ADVJAVA","DUNESH");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from bookdetails69");
			
			while(rs.next()) {
				System.out.println("BookNo:"+rs.getInt(1)+"\nBookName: "+rs.getString(2)+"\nAuthor: "+rs.getString(3)+"\nPrice:"+rs.getInt(4)+"\nQuantity: "+rs.getInt(5)+"\n");
			}
			
			con.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
