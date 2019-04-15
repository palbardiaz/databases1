/***********
 * 
 *  MariaDB [(none)]> GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' IDENTIFIED BY 'root' WITH GRANT OPTION;
 * 
 * download and place on your java classpath:
 * Canvas  "Files/notes/mariadb-java-client-2.2.3.jar"
 * 
 ***********/

import java.sql.*;

class SimpleJDBC {
  public static void main(String[] args) {
    Connection connection;
    ResultSet rs;
    ResultSet r2; 
    Statement statement;

    String JDBC_DRIVER = "org.mysql.jdbc.Driver";
    String LOCAL_HOST = "jdbc:mariadb://localhost:3306/";
    String db = "hw3";
    String username = "root";
    String password = "";
    String sql = "SELECT * FROM drinkers;";
    String sql2 = "SELECT * FROM Likes;"; 

    try {

      connection = DriverManager.getConnection( LOCAL_HOST + db, username, password );
      System.out.println( db + " connected." );
      System.out.println();


      statement = connection.createStatement();
      rs = statement.executeQuery( sql );
      r2 = statement.executeQuery(sql2); 


      while ( rs.next() ) {
        System.out.println( "( " + rs.getString( "name" ) + ", " + rs.getString( "address" ) + " ) " );
      }

      System.out.println();

      while ( r2.next() ) {
        String beer = r2.getString("beer"); 
        String drinker = r2.getString("drinker"); 
       
        if(beer.equals("Miller Light")){
          System.out.println(drinker);
        }
      }
        
   
      System.out.println();
      

      if ( connection != null ) {
        connection.close();
      }

    }
    catch ( SQLException sqle ) {
      sqle.printStackTrace();
    }
  }
}
