package test;

/*
 * ProjectName : UserApp

DB table : UserReg69 (uname,pword,fname,lname,city,mid,phno)
           Primary Key : uname and pword
           
create table UserReg29(
uname varchar2(20),
pword varchar2(20),
fname varchar2(20),
lname varchar2(20),
city varchar2(20),
mid varchar2(20),
phno number(15),
primary key(uname,pword));

 */

public interface DBInfo {
	public static final String driver = "oracle.jdbc.driver.OracleDriver";
	public static final String dbURL ="jdbc:oracle:thin:@localhost:1521:xe";
	public static final String uName ="ADVJAVA";
	public static final String pwd ="DUNESH";
	
}
