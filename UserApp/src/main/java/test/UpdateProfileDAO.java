package test;
import java.sql.*;
public class UpdateProfileDAO {

	public int k=0;
	public int update(UserBean ub) {
		
		try {
			Connection con =DBConnection.getCon();
			
			String query="Update UserReg set city=?,gmail=?,phno=? where Username=? and password=?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, ub.getCity());
			ps.setString(2, ub.getmId());
			ps.setLong(3, ub.getPhNo());
			ps.setString(4, ub.getuName());
			ps.setString(5, ub.getpWord());
			
			k=ps.executeUpdate();
			
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
		return k;
	}

}
