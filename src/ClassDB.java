import java.sql.*;

public class ClassDB {
	// JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
    //  Database credentials
    static final String USER = "syid";
    static final String PASS = "123456";
    static Connection conn = null;

	public ClassDB() throws SQLException {
        // Open a connection
        System.out.println("Connecting to database...");
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
	}
	
	public static void createDB() {
        Statement stmt = null;
        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Execute a query
            System.out.println("Creating database...");
            stmt = conn.createStatement();

            String sql = "CREATE DATABASE STUDENTS";
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {} // nothing we can do
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } //end finally try
        } //end try
        System.out.println("Goodbye!");
	}
	
	public static void selectDB() {
	   Connection conn = null;
	   try{
	      // Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");

	      // THIS REQUIRED: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(DB_URL, USER, PASS);
	      System.out.println("Connected database successfully...");
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}//end main
	
	public static void dropDB(String[] args) {
	   Statement stmt = null;
	   try{
	      // Register JDBC driver
	      Class.forName("com.mysql.jdbc.Driver");
	      
	      // Execute a query
	      System.out.println("Deleting database...");
	      stmt = conn.createStatement();
	      
	      String sql = "DROP DATABASE STUDENTS";
	      stmt.executeUpdate(sql);
	      System.out.println("Database deleted successfully...");
	   }catch(SQLException se){
	      //Handle errors for JDBC
	      se.printStackTrace();
	   }catch(Exception e){
	      //Handle errors for Class.forName
	      e.printStackTrace();
	   }finally{
	      //finally block used to close resources
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }// do nothing
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }//end finally try
	   }//end try
	   System.out.println("Goodbye!");
	}//end main
	
	public static void createTables() {
		   Statement stmt = null;
		   try{
		      // Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      //  Execute a query
		      System.out.println("Creating table in given database...");
		      stmt = conn.createStatement();
		      
		      String sql = "CREATE TABLE REGISTRATION " +
		                   "(id INTEGER not NULL, " +
		                   " first VARCHAR(255), " + 
		                   " last VARCHAR(255), " + 
		                   " age INTEGER, " + 
		                   " PRIMARY KEY ( id ))"; 

		      stmt.executeUpdate(sql);
		      System.out.println("Created table in given database...");
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		}//end main
	
	public static void dropTables() {
		   Statement stmt = null;
		   try{
		      // Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		
		      // Execute a query
		      System.out.println("Deleting table in given database...");
		      stmt = conn.createStatement();
		      
		      String sql = "DROP TABLE REGISTRATION ";
		 
		      stmt.executeUpdate(sql);
		      System.out.println("Table  deleted in given database...");
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		}//end main
	
	public static void insertRecords() {
		   Statement stmt = null;
		   try{
		      // Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      // Execute a query
		      System.out.println("Inserting records into the table...");
		      stmt = conn.createStatement();
		      
		      String sql = "INSERT INTO Registration " +
		                   "VALUES (100, 'Zara', 'Ali', 18)";
		      stmt.executeUpdate(sql);
		      sql = "INSERT INTO Registration " +
		                   "VALUES (101, 'Mahnaz', 'Fatma', 25)";
		      stmt.executeUpdate(sql);
		      sql = "INSERT INTO Registration " +
		                   "VALUES (102, 'Zaid', 'Khan', 30)";
		      stmt.executeUpdate(sql);
		      sql = "INSERT INTO Registration " +
		                   "VALUES(103, 'Sumit', 'Mittal', 28)";
		      stmt.executeUpdate(sql);
		      System.out.println("Inserted records into the table...");

		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		}//end main
	
	public static void selectRecords() {
		   Statement stmt = null;
		   try{
		      // Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      // Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();

		      String sql = "SELECT id, first, last, age FROM Registration";
		      ResultSet rs = stmt.executeQuery(sql);
		      // Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         int age = rs.getInt("age");
		         String first = rs.getString("first");
		         String last = rs.getString("last");

		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", Age: " + age);
		         System.out.print(", First: " + first);
		         System.out.println(", Last: " + last);
		      }
		      rs.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		}//end main
	
	public static void updateRecords() {
		   Statement stmt = null;
		   try{
		      // Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      // Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql = "UPDATE Registration " +
		                   "SET age = 30 WHERE id in (100, 101)";
		      stmt.executeUpdate(sql);

		      // Now you can extract all the records
		      // to see the updated records
		      sql = "SELECT id, first, last, age FROM Registration";
		      ResultSet rs = stmt.executeQuery(sql);

		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         int age = rs.getInt("age");
		         String first = rs.getString("first");
		         String last = rs.getString("last");

		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", Age: " + age);
		         System.out.print(", First: " + first);
		         System.out.println(", Last: " + last);
		      }
		      rs.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		}//end main
	
	public static void deleteRecord() {
		   Statement stmt = null;
		   try{
		      // Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      // Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();
		      String sql = "DELETE FROM Registration " +
		                   "WHERE id = 101";
		      stmt.executeUpdate(sql);

		      // Now you can extract all the records
		      // to see the remaining records
		      sql = "SELECT id, first, last, age FROM Registration";
		      ResultSet rs = stmt.executeQuery(sql);

		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         int age = rs.getInt("age");
		         String first = rs.getString("first");
		         String last = rs.getString("last");

		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", Age: " + age);
		         System.out.print(", First: " + first);
		         System.out.println(", Last: " + last);
		      }
		      rs.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		}//end main
	
	public static void whereClause() {
		   Statement stmt = null;
		   try{
		      // Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      // Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();

		      // Extract records without any condition.
		      System.out.println("Fetching records without condition...");
		      String sql = "SELECT id, first, last, age FROM Registration";
		      ResultSet rs = stmt.executeQuery(sql);

		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         int age = rs.getInt("age");
		         String first = rs.getString("first");
		         String last = rs.getString("last");

		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", Age: " + age);
		         System.out.print(", First: " + first);
		         System.out.println(", Last: " + last);
		      }

		      // Select all records having ID equal or greater than 101
		      System.out.println("Fetching records with condition...");
		      sql = "SELECT id, first, last, age FROM Registration" +
		                   " WHERE id >= 101 ";
		      rs = stmt.executeQuery(sql);

		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         int age = rs.getInt("age");
		         String first = rs.getString("first");
		         String last = rs.getString("last");

		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", Age: " + age);
		         System.out.print(", First: " + first);
		         System.out.println(", Last: " + last);
		      }
		      rs.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		}//end main
	
	public static void likeClause() {
		   Statement stmt = null;
		   try{
		      //Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      // Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      // Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();

		      // Extract records without any condition.
		      System.out.println("Fetching records without condition...");
		      String sql = "SELECT id, first, last, age FROM Registration";
		      ResultSet rs = stmt.executeQuery(sql);

		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         int age = rs.getInt("age");
		         String first = rs.getString("first");
		         String last = rs.getString("last");

		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", Age: " + age);
		         System.out.print(", First: " + first);
		         System.out.println(", Last: " + last);
		      }

		      // Select all records having ID equal or greater than 101
		      System.out.println("Fetching records with condition...");
		      sql = "SELECT id, first, last, age FROM Registration" +
		                   " WHERE first LIKE '%za%' ";
		      rs = stmt.executeQuery(sql);

		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         int age = rs.getInt("age");
		         String first = rs.getString("first");
		         String last = rs.getString("last");

		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", Age: " + age);
		         System.out.print(", First: " + first);
		         System.out.println(", Last: " + last);
		      }
		      rs.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		}//end main
	
	public static void sortingData() {
		   Statement stmt = null;
		   try{
		      // Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");
		      
		      // Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();

		      // Extract records in ascending order by first name.
		      System.out.println("Fetching records in ascending order...");
		      String sql = "SELECT id, first, last, age FROM Registration" +
		                   " ORDER BY first ASC";
		      ResultSet rs = stmt.executeQuery(sql);

		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         int age = rs.getInt("age");
		         String first = rs.getString("first");
		         String last = rs.getString("last");

		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", Age: " + age);
		         System.out.print(", First: " + first);
		         System.out.println(", Last: " + last);
		      }

		      // Extract records in descending order by first name.
		      System.out.println("Fetching records in descending order...");
		      sql = "SELECT id, first, last, age FROM Registration" +
		                   " ORDER BY first DESC";
		      rs = stmt.executeQuery(sql);

		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         int age = rs.getInt("age");
		         String first = rs.getString("first");
		         String last = rs.getString("last");

		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", Age: " + age);
		         System.out.print(", First: " + first);
		         System.out.println(", Last: " + last);
		      }
		      rs.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		}//end main
}
