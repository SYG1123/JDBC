import java.sql.*;
public class PureJDBC {

        private static final String DB_URL = "jdbc:mysql://localhost:3306/test1";
        private static final String USER = "root";
        private static final String PASS = "123456";
        //STEP 1. Import required packages

                // JDBC driver name and database URL
        static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

                public static void main(String[] args) {
                        Connection conn = null;
                        Statement stmt = null;
                        try{
                                //STEP 2: Register JDBC driver
                                //Class.forName("com.mysql.jdbc.Driver");//可以不用
                                //STEP 3: Open a connection
                                System.out.println("Connecting to a selected database...");
                                conn = DriverManager.getConnection(DB_URL, USER, PASS);
                                System.out.println("Connected database successfully...");
                                //STEP 4: Execute a query
                                System.out.println("Creating statement...");
                                stmt = conn.createStatement();
                                String sql = "SELECT id, name, age FROM student";
                                ResultSet rs = stmt.executeQuery(sql);
                                //STEP 5: Extract data from result set
                                while(rs.next()){
                                        //Retrieve by column name
                                        int id = rs.getInt("id");
                                        int age = rs.getInt("age");
                                        String name = rs.getString("name");

                                        //Display values
                                        System.out.print("ID: " + id);
                                        System.out.print(", Age: " + age);
                                        System.out.print(", Name: " + name);
                                        System.out.print("\n");
                                         }
                                rs.close(); }
                        catch(SQLException se){
                                //Handle errors for JDBC
                                se.printStackTrace(); }catch(Exception e){
                                //Handle errors for Class.forName
                                e.printStackTrace(); }finally{
                                //finally block used to close resources
                                try{
                                        if(stmt!=null) conn.close();
                                }
                                catch(SQLException se){ }
                                // do nothing
                                try{
                                        if(conn!=null) conn.close();
                                }
                                catch(SQLException se){ se.printStackTrace(); }
                                //end finally try }
                                // end try
                                System.out.println("Goodbye!"); }
                        //end main //
                        // end JDBCExample
                        }

        }





