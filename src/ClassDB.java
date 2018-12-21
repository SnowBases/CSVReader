import static java.lang.System.out;

import java.sql.*;
import java.util.List;

public class ClassDB {
	// JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String MYSQL_URL = "jdbc:mysql://localhost/";
    static final String PARAMETER_URL = "?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT";
    //  Database credentials
    static final String USER = "syid";
    static final String PASS = "123456";
    static Connection conn = null;

	public ClassDB(String args) throws SQLException {
		if(args.equals("mysql")) {
	        try {
				// Connecting to MYSQL url
				System.out.println("Connecting to MySQL...");
				conn = DriverManager.getConnection(MYSQL_URL + PARAMETER_URL, USER, PASS);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        }
	        System.out.println("Successfully connected to MySQL");
		}else {
			try {
				// Connecting to database url
				System.out.println("Connecting to database...");
				String DB_NAME = args;
				conn = DriverManager.getConnection(MYSQL_URL + DB_NAME + PARAMETER_URL, USER, PASS);
	        } catch (Exception e) {
	        	e.printStackTrace();
	        	out.println("Database not found");
	        }
	        System.out.println("Successfully connected to database");
		}
	}
		
	
	public void createDB(String DB_NAME) {
        Statement stmt = null;
        try{
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Execute a query
            System.out.println("Creating database...");
            stmt = conn.createStatement();

            String sql = "CREATE DATABASE " + DB_NAME;
            stmt.executeUpdate(sql);
            System.out.println("Database created successfully...");
        } catch (SQLException se) {
            //Handle errors for JDBC
            //se.printStackTrace();
            System.out.println("Database name already exist");
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
	      Class.forName("com.mysql.cj.jdbc.Driver");

	      // THIS REQUIRED: Open a connection
	      System.out.println("Connecting to a selected database...");
	      conn = DriverManager.getConnection(MYSQL_URL, USER, PASS);
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
	
	public static void dropDB(String DB_NAME) {
	   Statement stmt = null;
	   try{
	      // Register JDBC driver
	      Class.forName("com.mysql.cj.jdbc.Driver");
	      
	      // Execute a query
	      System.out.println("Deleting database...");
	      stmt = conn.createStatement();
	      
	      String sql = "DROP DATABASE " + DB_NAME;
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
	
	public void createTables(String TABLE_NAME, List<String> COLUMN_NAME) {
		   Statement stmt = null;
		   try{
		      // Register JDBC driver
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      
		      //  Execute a query
		      System.out.println("Creating table in given database...");
		      stmt = conn.createStatement();
		      StringBuilder chars = new StringBuilder();
		      
		      for(String x : COLUMN_NAME ) {
		    	  	chars.append(" `" + x + "` VARCHAR(255)");
		    	  	//out.print(" " + x + " VARCHAR(255)");
		    	  	if( !x.equals( COLUMN_NAME.get(COLUMN_NAME.size() - 1) )) chars.append(",");
		      }

		      String sql = "CREATE TABLE " + TABLE_NAME + "(" + chars + ")"; 

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
		      Class.forName("com.mysql.cj.jdbc.Driver");
		
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
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      
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
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      
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
		      Class.forName("com.mysql.cj.jdbc.Driver");

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
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      
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
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      
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
		      Class.forName("com.mysql.cj.jdbc.Driver");

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
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      
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
