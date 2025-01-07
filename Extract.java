import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLDataExtraction {

    public static void main(String[] args) {
        
        // Establishing connection to MySQL database ------ 
        try {
            // Load and register the JDBC driver (Optional for newer versions of Java)
            Class.forName("com.mysql.cj.jdbc.Driver");   //(1st step)

            // Create a connection
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database_name", "root", "");      //( step 2 )
            System.out.println("Connection established successfully.");

        
            // Creating a Statement object
            Statement stmt = conn.createStatement();    // (step 3)
 
            //

            Sytsem.out.print("enter student id : ");
            int stdid = sc.nextInt();

             Sytsem.out.print("enter student name : ");
            String stdname = sc.next();

             Sytsem.out.print("enter student mobile : ");
            String stdmob = sc.next();


             // Creating the SQL query to insert data into the student table
            // Concatenating user input directly into the query
            String sql = "INSERT INTO student (id, name, mobile) VALUES (" 
                         + stdid + ", '" 
                         + stdname + "', '"
                         + stdmob + "')";  // Step 3

            // Execute the insert query (Step 4)
            int rowsAffected = stmt.executeUpdate(sql);

            // Check if the insert was successful
            if (rowsAffected > 0) {
                System.out.println("Student data inserted successfully.");
            } else {
                System.out.println("Failed to insert student data.");
            }

            
            sc.close();  // Close the scanner

        } catch (Exception e) {
            System.err.println("Error occurred while connecting or interacting with the database.");
            e.printStackTrace();
        }
    }
}


