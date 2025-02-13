package test;

import java.sql.*;

public class LoginDAO {
	public UserBean ub =null;
	public UserBean login(String uN, String pw) {
		
		try {
			Connection con = DBConnection.getCon();
			
			String query = "select * from UserReg where Username=? and password=?";
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, uN);
			ps.setString(2, pw);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ub=new UserBean();
				ub.setuName(rs.getString(1));
				ub.setpWord(rs.getString(2));
				ub.setfName(rs.getString(3));
				ub.setlName(rs.getString(4));
				ub.setCity(rs.getString(5));
				ub.setmId(rs.getString(6));
				ub.setPhNo(rs.getLong(7));
				//System.out.println("SQL DOne");
			}
		}
		catch(Exception e) {
			e.getStackTrace();
		}
		
		return ub;
	}
}
