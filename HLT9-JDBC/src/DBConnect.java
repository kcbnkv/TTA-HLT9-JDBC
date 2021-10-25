import java.sql.DriverManager;// * -> all
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBConnect {
    public static void main(String[] args) {
        String driveName = "com.mysql.cj.jdbc.Driver";//mysql database
        String url = "jdbc:mysql://127.0.0.1:3306/TTA";//database location
        String user = "root";//database user name
        String password = "Michelin2903";//database password
        //exception handling -> try-catch
        try
        {
            //Load driver
            Class.forName(driveName);
            //get db connection from driver manager
            Connection con = DriverManager.getConnection(url , user , password);//return Connection
            //create statement
            Statement stmt = con.createStatement();//return Statement
            //execute SQL query
           
            //1. select 2.insert 3.delete 4.update
          
            //1. select -> display all data
            ResultSet rs = stmt.executeQuery( "select * from employee");//return all records

            while(rs.next()) {
                //read each record by column name
                System.out.println("EID :"+rs.getInt(1));
                System.out.println("ENAME :"+rs.getString(2));
                System.out.println("EMAIL :"+rs.getString(3));
                System.out.println("MOBILE :"+rs.getString(4));
                System.out.println("DESIGNATION :"+rs.getString(5));
                System.out.println("SALARY :"+rs.getDouble(6));
                
                System.out.println("==========================");
            }//while ends
            
            //2. Insert record
            int row_count = stmt.executeUpdate("insert into employee(eid,ename,email,mobile,designation,salary) values (345,'pete','Henrieta@outlook.co.uk','0 6789 345 543','Contractor',30000)");
            System.out.println("Row insert :"+row_count);//1-success
//            
//          //3. Delete
            stmt.executeUpdate("delete from employee WHERE eid = 67");
            
//            or
//            String row_deleted = "DELETE FROM employee " + "WHERE eid = 466";//
//            stmt.executeUpdate(row_deleted);
//            
            //4. update
            stmt.executeUpdate("update employee set designation='Admin Assistant' where eid=2");
//            
          
            
        }//try ends
        catch(Exception ex)
        {
            //handling exceptions and error
            System.out.println("DB error :"+ex);
        }//catch ends

    }//main ends
}//class ends
