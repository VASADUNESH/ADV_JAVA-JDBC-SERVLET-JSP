package classProblems.TYPE_SCROLL;
import java.util.*;
import java.sql.*;

/**
 * 
 * ResultSet :which is instantiated to hold the result generated from select-queries
 * two types => 1. Non-Scrollable ResultSet Objects
 * 				2. Scrollable Result Objects => type,MODE
 * 
 * TYPE_FORWARD_ONLY
 * TYPE_SCROLL_INSENSITIVE
 * TYPE_SCROLL_SENSITIVE
 * 
 * CONCUR_READ_ONLY
 * CONCUR_UPDATABLE
 * 
 * RESULTSET OBJECTS:
 *   1.afterLast()
     2.beforeFirst()
     3.first()
     4.last()
     5.previous()
     6.next()
     7.absolute(int)
     8.relative(int)

 */
public class DBCon6 {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","ADVJAVA","DUNESH");
			Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs1 = st.executeQuery("select * from Product69");
			rs1.absolute(3);// Display 3rd row
			System.out.println("=>3rd row");
			System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"
        			+rs1.getInt(3)+"\t"+rs1.getInt(4));
			
			System.out.println("=>relative jumps 2 rows");
			rs1.relative(+2);
			System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"
        			+rs1.getInt(3)+"\t"+rs1.getInt(4));
			
			System.out.println("relative backward jumps 1 rows");
			rs1.relative(-1);
			System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"
        			+rs1.getInt(3)+"\t"+rs1.getInt(4));
			
			System.out.println("Going to 1st");
			rs1.first();
			System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"
        			+rs1.getInt(3)+"\t"+rs1.getInt(4));
			
			System.out.println("Going to last row");
			rs1.last();
			System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"
        			+rs1.getInt(3)+"\t"+rs1.getInt(4));
			
			PreparedStatement ps = con.prepareStatement("select * from product69",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs2 = ps.executeQuery();
			
			
			System.out.println("=>");
			rs2.afterLast();;
			System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"
        			+rs1.getInt(3)+"\t"+rs1.getInt(4));
			System.out.println("-----Product details in reverse-------");
        	while(rs2.previous()) {
        		System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"
            			+rs2.getFloat(3)+"\t"+rs2.getInt(4));
        	}
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}

}
