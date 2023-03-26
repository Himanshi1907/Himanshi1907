import java.sql.*;
public class Updatable{
public static void main(String args[])throws Exception{
		//Getting the connection
		String mysqlUrl="jdbc:mysql://localhost:3306/mca";
Connection con=DriverManager.getConnection(mysqlUrl,"root","845594");
System.out.println("Connection established....");
		//Creating a Statement object
    Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		//Retrrieving the data
    ResultSet rs=stmt.executeQuery("select * from employees");
		//Printing the contents of the Table
		System.out.println("Contents of the Table: ");
			rs.beforeFirst();
				while(rs.next()){
				System.out.print("ID: "+rs.getInt("ID"));
System.out.print(",Salary: "+rs.getInt("salary"));
System.out.print(", Name:" + rs.getString("Name"));
System.out.println(", Location:" +rs.getString("Location"));
}
System.out.println();
		//Moving the pointer to the starting point in the Resultset
			rs.beforeFirst();
		//Updating the salary of each employee by 5000
			while(rs.next()){
		//Retrieve by column name
			int newSal=rs.getInt("salary")+5000;
				rs.updateInt("salary",newSal);
				rs.updateRow();
			}
System.out.println("Contents of the ResultSet after increasing salaries");
rs.beforeFirst();
while(rs.next()){
System.out.print("ID: "+rs.getInt("id"));
System.out.print(", Salary: "+rs.getInt("salary"));
System.out.print(", Name: "+rs.getString("name"));
System.out.println(", Location: "+rs.getString("location"));
			}
			System.out.println();
			}
		}
	

